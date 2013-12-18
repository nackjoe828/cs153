package wci.backend.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import wci.frontend.*;
import wci.intermediate.*;
import wci.backend.compiler.CodeGenerator;
import wci.intermediate.symtabimpl.Predefined;
import wci.intermediate.typeimpl.TypeFormImpl;
import wci.intermediate.typeimpl.TypeKeyImpl;
import wci.intermediate.typeimpl.TypeSpecImpl;
import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;

public class CodeGeneratorVisitor
    extends AlminParserVisitorAdaptor
    implements AlminParserTreeConstants
{
	private int labelCount = 1;
	
    public Object visit(ASTASSIGN node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode variableNode   = (SimpleNode) node.jjtGetChild(0);
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(1);
        TypeSpec expressionType = expressionNode.getTypeSpec();
        TypeSpec targetType = variableNode.getTypeSpec();
        

        ArrayList<SymTabEntry> list = CodeGenerator.paramIndexAndEntry;
        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
        int slotNumber = 0;
        for(SymTabEntry e : list){
        	if(e == id) break;
        	slotNumber++;
        }
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        String typeCode;
        if(type == Predefined.integerType) typeCode = "i";
        else if(type == Predefined.realType) typeCode = "f";
        else if(type == Predefined.stringType) typeCode = "a";
        else if(type.getForm() == TypeFormImpl.RECORD) typeCode = "a";
        else typeCode = "i";
        
        
        //if array, program enters here.
        if(variableNode.getTypeSpec().getForm() == TypeFormImpl.ARRAY){
        	TypeSpec elementType = (TypeSpec) type.getAttribute(TypeKeyImpl.ARRAY_ELEMENT_TYPE);
        	if(elementType == Predefined.integerType){
        		typeCode = "i";
        	}
        	if(elementType == Predefined.realType){
        		typeCode = "f";
        	}
        	CodeGenerator.objectFile.println("    aload " + slotNumber + " ;" + "array/" + fieldName);
        	variableNode.jjtGetChild(0).jjtAccept(this, data);
        	expressionNode.jjtAccept(this, data);
        	CodeGenerator.objectFile.println("    " + typeCode + "astore " + " ;" + "array/" + fieldName);
        	return data;
        }
        
        /*
        //assigning one record to another
        if(variableNode.getTypeSpec().getForm() == TypeFormImpl.RECORD
        		&& expressionNode.getTypeSpec().getForm() == TypeFormImpl.RECORD){
        	expressionNode.jjtAccept(this, data);
        	CodeGenerator.objectFile.println("    astore " + slotNumber + " ;" + "record/" + fieldName);
        	return data;
        }*/
        
        //if record type, program enters here
        if(variableNode.getTypeSpec().getForm() == TypeFormImpl.RECORD){
        	//variableNode.jjtAccept(this, data);
        	//expressionNode.jjtAccept(this, data);
        	
        	//load record type
        	//CodeGenerator.objectFile.println("    aload " + slotNumber + " ;" + "record/" + fieldName);
        	
        	//if function is returning record, record variable does not have child
        	if(variableNode.jjtGetNumChildren() == 0) return data;
        	
        	SimpleNode childOfField = (SimpleNode) variableNode.jjtGetChild(0).jjtGetChild(0);
        	TypeSpec childType = childOfField.getTypeSpec();
        	
        	//for nested record type
        	while(childType.getForm() == TypeFormImpl.RECORD){
        		id = (SymTabEntry) childOfField.getAttribute(ID);
        		childOfField = (SimpleNode) childOfField.jjtGetChild(0).jjtGetChild(0);
        		childType = childOfField.getTypeSpec();
        	}
        	
        	slotNumber = 0;
        	for(SymTabEntry e : list){
            	if(e == id) break;
            	slotNumber++;
            }
        	fieldName = id.getName();
        	//load record type
        	CodeGenerator.objectFile.println("    aload " + slotNumber + " ;" + "record/" + fieldName);
        	CodeGenerator.objectFile.println("    dup");
        	
        	
        	//get field name
        	id = (SymTabEntry) childOfField.getAttribute(ID);
        	fieldName = id.getName();
        	CodeGenerator.objectFile.println("    ldc \"" + fieldName + "\"");
        	expressionNode.jjtAccept(this, data);
        	
        	//if record, step down to get type
        	if(expressionType.getForm() == TypeFormImpl.RECORD){
        		expressionType = childType;
        	}
        	
        	if(expressionType == Predefined.integerType){
        		CodeGenerator.objectFile.println("    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;");
        	}
        	else if(expressionType == Predefined.realType){
        		CodeGenerator.objectFile.println("    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;");
        	}
        	else{
        		
        	}
        	CodeGenerator.objectFile.println("    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;"
        			+ "Ljava/lang/Object;)Ljava/lang/Object;");
        	CodeGenerator.objectFile.println("    pop");
        	
        	
        	return data;
        }
        	
        
        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);

        // Convert an integer value to float if necessary.
        if ((targetType == Predefined.realType) &&
            (expressionType == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate store instruction.
        CodeGenerator.objectFile.println("    " + typeCode + "store " + slotNumber + " ;" + "Local/" + fieldName);
        //CodeGenerator.objectFile.println("    putstatic " + programName + "/" + fieldName);
        //odeGenerator.objectFile.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
        //CodeGenerator.objectFile.println("    getstatic " + programName + "/" + fieldName + " " + typeCode);
        //CodeGenerator.objectFile.println("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTVariable node, Object data)
    {
    	//get a map representing which entry goes to which slot
    	ArrayList<SymTabEntry> list = CodeGenerator.paramIndexAndEntry;
    	
    	String programName = (String) data;
        SymTabEntry id = (SymTabEntry) node.getAttribute(ID);
        int slotNumber = 0;
        for(SymTabEntry e : list){
        	if(e == id) break;
        	slotNumber++;
        }
        TypeSpec type = id.getTypeSpec();
        String typeCode;
        if(type == Predefined.integerType) typeCode = "i";
        else if(type == Predefined.realType) typeCode = "f";
        else if(type == Predefined.stringType) typeCode = "a";
        else if(type.getForm() == TypeFormImpl.RECORD) typeCode = "a";
        else typeCode = "a";
        
        
        //if array, program goes here
        if(type.getForm() == TypeFormImpl.ARRAY){
        	CodeGenerator.objectFile.println("    aload " + slotNumber + "  ;" + "Local/" + id.getName());
        	TypeSpec elementType = (TypeSpec)type.getAttribute(TypeKeyImpl.ARRAY_ELEMENT_TYPE);
            if(elementType == Predefined.integerType) typeCode = "i";
            else if(elementType == Predefined.realType) typeCode = "f";
            else typeCode = "not defined yet";
            node.jjtGetChild(0).jjtAccept(this, data);
            CodeGenerator.objectFile.println("    " + typeCode + "aload ");
            CodeGenerator.objectFile.flush();
            return data;
        }
        
        //if record, program goes here
        if(type.getForm() == TypeFormImpl.RECORD){
        	if(node.jjtGetNumChildren() == 0)return data;
        	SimpleNode childOfField = (SimpleNode) node.jjtGetChild(0).jjtGetChild(0);
        	TypeSpec childType = childOfField.getTypeSpec();
        	SimpleNode currentNode = childOfField;
        	
        	//for nested record type
        	while(childType.getForm() == TypeFormImpl.RECORD){
        		id = (SymTabEntry) childOfField.getAttribute(ID);
        		currentNode = childOfField;
        		childOfField = (SimpleNode) childOfField.jjtGetChild(0).jjtGetChild(0);
        		childType = childOfField.getTypeSpec();
        	}
        	
        	slotNumber = 0;
        	for(SymTabEntry e : list){
            	if(e == id) break;
            	slotNumber++;
            }
        	String fieldName = id.getName();
        	
        	CodeGenerator.objectFile.println("    aload " + slotNumber + " ;Record/" + fieldName);
        	
        	currentNode.jjtGetChild(0).jjtAccept(this, data);

        	return data;
        	
        }

        // Emit the appropriate load instruction.
        //CodeGenerator.objectFile.println("    getstatic " + programName + "/" + fieldName + " " + typeCode);
        CodeGenerator.objectFile.println("    " + typeCode + "load " + slotNumber + "  ;" + "Local/" + id.getName());
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTIndex node, Object data){
    	node.jjtGetChild(0).jjtAccept(this, data);
    	return data;
    }
    
    public Object visit(ASTField node, Object data){
    	//get variable node under field
    	SimpleNode varUnderField = (SimpleNode) node.jjtGetChild(0);
    	SymTabEntry id = (SymTabEntry) varUnderField.getAttribute(ID);
    	CodeGenerator.objectFile.println("    ldc \"" + id.getName() + "\"");
    	
    	//get value
    	CodeGenerator.objectFile.println("    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)"
    			+ "Ljava/lang/Object;");
    	TypeSpec varType = varUnderField.getTypeSpec();
        if(varType == Predefined.integerType){
        	CodeGenerator.objectFile.println("    checkcast java/lang/Integer");
        	CodeGenerator.objectFile.println("    invokevirtual java/lang/Integer.intValue()I");
        }
        else if(varType == Predefined.realType){
        	CodeGenerator.objectFile.println("    checkcast java/lang/Float");
        	CodeGenerator.objectFile.println("    invokevirtual java/lang/Float.floatValue()F");
        }
        else if(varType == Predefined.stringType){
        	CodeGenerator.objectFile.println("    checkcast java/lang/String");
        }
        else {
        	
        }

    	return data;
    }

    public Object visit(ASTLiteral node, Object data)
    {
    	TypeSpec type = node.getTypeSpec();
    	Object at = node.getAttribute(VALUE);
    	if(type == Predefined.integerType){
            int value = (Integer) at;

            // Emit a load constant instruction.
            CodeGenerator.objectFile.println("    ldc " + value);
            //CodeGenerator.objectFile.println("invokevirtual java/io/PrintStream/println(Ljava/lang/Integer;)V");
            CodeGenerator.objectFile.flush();

            return data;
    	}
    	else if(type == Predefined.realType){
            float value = (Float) at;

            // Emit a load constant instruction.
            //CodeGenerator.objectFile.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
            CodeGenerator.objectFile.println("    ldc " + value);
            //CodeGenerator.objectFile.println("invokevirtual java/io/PrintStream/println(Ljava/lang/Float;)V");
            CodeGenerator.objectFile.flush();

            return data;
    	}
        return null;
    }
    
    public Object visit(ASTStringLiteral node, Object data){
    	String str = (String) node.getAttribute(VALUE);
    	CodeGenerator.objectFile.println("    ldc \"" + str + "\"");
    	CodeGenerator.objectFile.flush();
    	return data;
    }

    public Object visit(ASTadd node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        	
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";
        
        //if first add is string type, invoke append
        if(type == Predefined.stringType){
        	CodeGenerator.objectFile.println("    new java/lang/StringBuilder");
        	CodeGenerator.objectFile.println("    dup");
        	//create string builder object with empty string
        	CodeGenerator.objectFile.println("    ldc \"\"");
        	CodeGenerator.objectFile.println("    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V");
        	
        	//append first operand
        	addend0Node.jjtAccept(this, data);
        	if(type0 == Predefined.stringType)
        		CodeGenerator.objectFile.println("    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
        	if(type0 == Predefined.integerType)
        		CodeGenerator.objectFile.println("    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;");
        	else if(type0 == Predefined.realType)
        		CodeGenerator.objectFile.println("    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;");
        	
        	//append second operand
        	addend1Node.jjtAccept(this, data);
        	if(type1 == Predefined.stringType)
        		CodeGenerator.objectFile.println("    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
        	if(type1 == Predefined.integerType)
        		CodeGenerator.objectFile.println("    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;");
        	else if(type1 == Predefined.realType)
        		CodeGenerator.objectFile.println("    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;");
        	
        	CodeGenerator.objectFile.println("    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;");
        	return data;
        }

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) &&
            (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }
        
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) &&
            (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "add");
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTsub node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) &&
            (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) &&
            (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "sub");
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTmult node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) &&
            (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) &&
            (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "mul");
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTdiv node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if ((type == Predefined.realType) &&
            (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if ((type == Predefined.realType) &&
            (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "div");
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTFunctionCall node, Object data){
    	String programName = (String) data;
    	SymTabEntry id = (SymTabEntry) node.getAttribute(ID);
    	String fieldName = id.getName();
    	TypeSpec type = id.getTypeSpec();
    	String typeCode;
    	if(type == Predefined.integerType) typeCode = "I";
    	else if(type == Predefined.realType) typeCode = "F";
    	else typeCode = "";
    	
    	//generate code for printf
    	if(fieldName.equals("printf")){
    		CodeGenerator.objectFile.println("    getstatic java/lang/System/out Ljava/io/PrintStream;");
    		//code for string
    		SimpleNode stringNode = (SimpleNode) node.jjtGetChild(0);
    		stringNode.jjtAccept(this, data);
    		//code for object array
    		int objArrayCount = node.jjtGetNumChildren()-1;
    		CodeGenerator.objectFile.println("    ldc " + objArrayCount);
    		CodeGenerator.objectFile.println("    anewarray java/lang/Object");
    		CodeGenerator.objectFile.println();
    		for(int i = 0; i < objArrayCount; i++){
    			CodeGenerator.objectFile.println("    dup");
    			CodeGenerator.objectFile.println("    ldc " + i);
    			//needed for checking type
    			ICodeNode iNode = (ICodeNode) node.jjtGetChild(i+1);
    			SimpleNode objNode = (SimpleNode) node.jjtGetChild(i+1);
    			objNode.jjtAccept(this, data);
    			type = iNode.getTypeSpec();
    			
        		if(type == Predefined.integerType){
        			CodeGenerator.objectFile.println("    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
        		}
        		else if(type == Predefined.realType){
        			CodeGenerator.objectFile.println("    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;");
        		}
        		else if(type.getForm() == TypeFormImpl.RECORD || type.getForm() == TypeFormImpl.ARRAY){
        			SimpleNode varUnderField = (SimpleNode) objNode.jjtGetChild(0).jjtGetChild(0);
        			TypeSpec fieldType = varUnderField.getTypeSpec();
        			if(fieldType == Predefined.integerType){
            			CodeGenerator.objectFile.println("    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
            		}
            		else if(fieldType == Predefined.realType){
            			CodeGenerator.objectFile.println("    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;");
            		}
        		}
    			
    			CodeGenerator.objectFile.println("    aastore");
    			CodeGenerator.objectFile.println();
    		}
    		CodeGenerator.objectFile.print("    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[");
    		CodeGenerator.objectFile.println("Ljava/lang/Object;)Ljava/io/PrintStream;");
    		CodeGenerator.objectFile.println("   pop");
    		CodeGenerator.objectFile.println("");
    		return data;
    	}
    	
    	//check type id for each parameters
    	int argCount = node.jjtGetNumChildren();
    	String[] typeCodes = new String[argCount]; //store type codes for each parameter
    	SimpleNode currentChildNode;
    	for(int i = 0; i < argCount; i++){
    		currentChildNode = (SimpleNode) node.jjtGetChild(i);
    		currentChildNode.jjtAccept(this, data);
    		TypeSpec currentChildType = currentChildNode.getTypeSpec();
    		if(currentChildType.getForm() == TypeFormImpl.ARRAY){
    			currentChildType = (TypeSpec) currentChildType.getAttribute(TypeKeyImpl.ARRAY_ELEMENT_TYPE);
    		}
    		if(currentChildType.getForm() == TypeFormImpl.RECORD){
    			typeCodes[i] = "Ljava/util/HashMap;";
    		}
    		else if(currentChildType == Predefined.integerType){
    			typeCodes[i] = "I";
    		}
    		else if(currentChildType == Predefined.realType){
    			typeCodes[i] = "F";
    		}
    		else if(currentChildType == Predefined.stringType){
    			typeCodes[i] = "Ljava/lang/String;";
    		}
    		else if(currentChildType == Predefined.booleanType){
    			typeCodes[i] = "Z";
    		}
    		else typeCodes[i] = "error";
    	}
    	
    	//generate code to call function
    	String signature = programName + "/" + fieldName + "(";
    	for(int i = 0; i < argCount; i++){
    		signature += typeCodes[i];
    	}

    	//append return type
		if(type == Predefined.integerType){
			typeCode = "I";
		}
		else if(type == Predefined.realType){
			typeCode = "F";
		}
		else if(type == Predefined.stringType){
			typeCode = "Ljava/lang/String;";
		}
		else if(type == Predefined.booleanType){
			typeCode = "Z";
		}
		else if(type == Predefined.voidType){
			typeCode = "V";
		}
		else if(type.getForm() == TypeFormImpl.RECORD){
			typeCode = "Ljava/util/HashMap;";
		}
		else typeCode = "error";
    	
    	
    	signature += ")" + typeCode;
    	CodeGenerator.objectFile.println("    invokestatic " + signature);
    	
    	return data;
    }
    
    public Object visit(ASTIfStatement node, Object data){
    	SimpleNode conditionNode = (SimpleNode) node.jjtGetChild(0);
    	
    	conditionNode.jjtAccept(this, data);
    	//store the label number before being incremented
    	int storedNumber = labelCount;
    	
    	CodeGenerator.objectFile.println("    goto L" + String.format("%03d", ++labelCount));
    	CodeGenerator.objectFile.println("L" + String.format("%03d", storedNumber) + ":");
    	storedNumber = labelCount;
    	
    	// execute if block
    	SimpleNode ifBlockNode = (SimpleNode) node.jjtGetChild(1);
    	ifBlockNode.jjtAccept(this, data);
    	
    	// if else block follows, execute
    	if(node.jjtGetNumChildren() == 3){
    		CodeGenerator.objectFile.println("    goto L" + String.format("%03d", ++labelCount));
    		CodeGenerator.objectFile.println("L" + String.format("%03d", storedNumber) + ":");
    		storedNumber = labelCount;
    		SimpleNode elseBlockNode = (SimpleNode) node.jjtGetChild(2);
    		elseBlockNode.jjtAccept(this, data);
    	}
    	
    	CodeGenerator.objectFile.println("L" + String.format("%03d", storedNumber) + ":");
    	CodeGenerator.objectFile.flush();
    	
    	return data;
    }
    
    public Object visit(ASTLOOP node, Object data){
    	CodeGenerator.objectFile.println("L" + String.format("%03d", ++labelCount) + ":");
    	int indexToCondition = labelCount;
    	
    	SimpleNode conditionNode = (SimpleNode) node.jjtGetChild(0);
    	conditionNode.jjtAccept(this, data);
    	
    	int storedNumber = labelCount;
    	CodeGenerator.objectFile.println("    goto L" + String.format("%03d", ++labelCount));
    	CodeGenerator.objectFile.println("L" + String.format("%03d", storedNumber) + ":");
    	storedNumber = labelCount;
    	
    	SimpleNode blockNode = (SimpleNode) node.jjtGetChild(1);
    	blockNode.jjtAccept(this, data);
    	CodeGenerator.objectFile.println("    goto L" + String.format("%03d", indexToCondition));
    	CodeGenerator.objectFile.println("L" + String.format("%03d", storedNumber) + ":");
    	CodeGenerator.objectFile.flush();
    	return data;
    }
    
    public Object visit(ASTGT node, Object data){
    	SimpleNode leftHand = (SimpleNode) node.jjtGetChild(0);
    	SimpleNode rightHand = (SimpleNode) node.jjtGetChild(1);
    	
    	leftHand.jjtAccept(this, data);
    	rightHand.jjtAccept(this, data);
    	TypeSpec type = leftHand.getTypeSpec();
    	if(type == Predefined.realType){
    		CodeGenerator.objectFile.println("    fcmpl");
    		CodeGenerator.objectFile.println("    ifgt L" + String.format("%03d", ++labelCount));
    		return data;
    	}
    	String typePrefix = (type == Predefined.integerType) ? "i" : "f";
    	CodeGenerator.objectFile.println("    if_" + typePrefix + "cmpgt L" + String.format("%03d", ++labelCount));
    	return data;
    }
    
    public Object visit(ASTGE node, Object data){
    	SimpleNode leftHand = (SimpleNode) node.jjtGetChild(0);
    	SimpleNode rightHand = (SimpleNode) node.jjtGetChild(1);
    	
    	leftHand.jjtAccept(this, data);
    	rightHand.jjtAccept(this, data);
    	TypeSpec type = leftHand.getTypeSpec();
    	if(type == Predefined.realType){
    		CodeGenerator.objectFile.println("    fcmpl");
    		CodeGenerator.objectFile.println("    ifge L" + String.format("%03d", ++labelCount));
    		return data;
    	}
    	String typePrefix = (type == Predefined.integerType) ? "i" : "f";
    	CodeGenerator.objectFile.println("    if_" + typePrefix + "cmpge L" + String.format("%03d", ++labelCount));
    	return data;
    }
    
    public Object visit(ASTLT node, Object data){
    	SimpleNode leftHand = (SimpleNode) node.jjtGetChild(0);
    	SimpleNode rightHand = (SimpleNode) node.jjtGetChild(1);
    	
    	leftHand.jjtAccept(this, data);
    	rightHand.jjtAccept(this, data);
    	TypeSpec type = leftHand.getTypeSpec();
    	if(type == Predefined.realType){
    		CodeGenerator.objectFile.println("    fcmpl");
    		CodeGenerator.objectFile.println("    iflt L" + String.format("%03d", ++labelCount));
    		return data;
    	}
    	String typePrefix = (type == Predefined.integerType) ? "i" : "f";
    	CodeGenerator.objectFile.println("    if_" + typePrefix + "cmplt L" + String.format("%03d", ++labelCount));
    	return data;
    }
    
    public Object visit(ASTLE node, Object data){
    	SimpleNode leftHand = (SimpleNode) node.jjtGetChild(0);
    	SimpleNode rightHand = (SimpleNode) node.jjtGetChild(1);
    	
    	leftHand.jjtAccept(this, data);
    	rightHand.jjtAccept(this, data);
    	TypeSpec type = leftHand.getTypeSpec();
    	if(type == Predefined.realType){
    		CodeGenerator.objectFile.println("    fcmpl");
    		CodeGenerator.objectFile.println("    ifle L" + String.format("%03d", ++labelCount));
    		return data;
    	}
    	String typePrefix = (type == Predefined.integerType) ? "i" : "f";
    	CodeGenerator.objectFile.println("    if_" + typePrefix + "cmple L" + String.format("%03d", ++labelCount));
    	return data;
    }
    
    public Object visit(ASTEQ node, Object data){
    	SimpleNode leftHand = (SimpleNode) node.jjtGetChild(0);
    	SimpleNode rightHand = (SimpleNode) node.jjtGetChild(1);
    	
    	leftHand.jjtAccept(this, data);
    	rightHand.jjtAccept(this, data);
    	TypeSpec type = leftHand.getTypeSpec();
    	if(type == Predefined.realType){
    		CodeGenerator.objectFile.println("    fcmpl");
    		CodeGenerator.objectFile.println("    ifeq L" + String.format("%03d", ++labelCount));
    		return data;
    	}
    	String typePrefix = (type == Predefined.integerType) ? "i" : "f";
    	CodeGenerator.objectFile.println("    if_" + typePrefix + "cmpeq L" + String.format("%03d", ++labelCount));
    	return data;
    }
    
    public Object visit(ASTNE node, Object data){
    	SimpleNode leftHand = (SimpleNode) node.jjtGetChild(0);
    	SimpleNode rightHand = (SimpleNode) node.jjtGetChild(1);
    	
    	leftHand.jjtAccept(this, data);
    	rightHand.jjtAccept(this, data);
    	TypeSpec type = leftHand.getTypeSpec();
    	if(type == Predefined.realType){
    		CodeGenerator.objectFile.println("    fcmpl");
    		CodeGenerator.objectFile.println("    ifne L" + String.format("%03d", ++labelCount));
    		return data;
    	}
    	String typePrefix = (type == Predefined.integerType) ? "i" : "f";
    	CodeGenerator.objectFile.println("    if_" + typePrefix + "cmpne L" + String.format("%03d", ++labelCount));
    	return data;
    }
    
    public Object visit(ASTBlock node, Object data){
    	int size = node.jjtGetNumChildren();
    	for(int i = 0; i < size; i++){
    		SimpleNode sNode = (SimpleNode) node.jjtGetChild(i);
    		sNode.jjtAccept(this, data);
    	}
    	return data;
    }
    
    public Object visit(ASTReturnStatement node, Object data){
		SimpleNode retNode = (SimpleNode) node.jjtGetChild(0);
		
		retNode.jjtAccept(this, data);
		TypeSpec retType = retNode.getTypeSpec();
		String typeCode;
		if(retType == Predefined.integerType){
			typeCode = "i";
		}
		else if(retType == Predefined.realType){
			typeCode = "f";
		}
		else if(retType == Predefined.stringType){
			typeCode = "a";
		}
		else if(retType == Predefined.booleanType){
			typeCode = "i";
		}
		else if(retType.getForm() == TypeFormImpl.RECORD){
			typeCode = "a";
		}
		//void
		else
			typeCode = "";
		CodeGenerator.objectFile.println("    " + typeCode + "return\n\n");
		CodeGenerator.objectFile.flush();
		
		return data;
    }
}
