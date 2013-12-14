package wci.backend.compiler;

import wci.frontend.*;
import wci.intermediate.*;
import wci.intermediate.symtabimpl.Predefined;
import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;

public class CodeGeneratorVisitor
    extends AlminParserVisitorAdaptor
    implements AlminParserTreeConstants
{
	private int labelCount = 1;
	
    public Object visit(ASTAssignmentStatement node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode variableNode   = (SimpleNode) node.jjtGetChild(0);
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(1);

        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);
        TypeSpec expressionType = expressionNode.getTypeSpec();

        // Get the assignment target type.
        TypeSpec targetType = node.getTypeSpec();

        // Convert an integer value to float if necessary.
        if ((targetType == Predefined.realType) &&
            (expressionType == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        String typeCode = type == Predefined.integerType ? "I" : "F";

        // Emit the appropriate store instruction.
        CodeGenerator.objectFile.println("    putstatic " + programName + "/" + fieldName + " " + typeCode);
        //odeGenerator.objectFile.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
        //CodeGenerator.objectFile.println("    getstatic " + programName + "/" + fieldName + " " + typeCode);
        //CodeGenerator.objectFile.println("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTVariable node, Object data)
    {
    	String programName = (String) data;
        SymTabEntry id = (SymTabEntry) node.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        String typeCode = type == Predefined.integerType ? "I" : "F";

        // Emit the appropriate load instruction.
        CodeGenerator.objectFile.println("    getstatic " + programName +
                "/" + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

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
    	
    	//check type id for each parameters
    	int argCount = node.jjtGetNumChildren();
    	String[] typeCodes = new String[argCount]; //store type codes for each parameter
    	SimpleNode currentChildNode;
    	for(int i = 0; i < argCount; i++){
    		currentChildNode = (SimpleNode) node.jjtGetChild(i);
    		currentChildNode.jjtAccept(this, data);
    		TypeSpec currentChildType = currentChildNode.getTypeSpec();
        	if(currentChildType == Predefined.integerType) typeCodes[i] = "I";
        	if(currentChildType == Predefined.realType) typeCodes[i] = "F";
    	}
    	
    	//generate code to call function
    	String signature = programName + "/" + fieldName + "(";
    	for(int i = 0; i < argCount; i++){
    		signature += typeCodes[i];
    	}
    	signature += ")" + typeCode;
    	CodeGenerator.objectFile.println("    invokestatic " + signature);
    	
    	return data;
    }
    
    public Object visit(ASTIfStatement node, Object data){
    	SimpleNode conditionNode = (SimpleNode) node.jjtGetChild(0);
    	
    	conditionNode.jjtAccept(this, data);
    	//store the label number before being incremented
    	int storedNumber = labelCount;
    	
    	CodeGenerator.objectFile.println("    iconst_0");
    	CodeGenerator.objectFile.println("    goto L" + String.format("%03d", ++labelCount));
    	CodeGenerator.objectFile.println("L" + String.format("%03d", storedNumber) + ":");
    	CodeGenerator.objectFile.println("    iconst_1");
    	CodeGenerator.objectFile.println("L" + String.format("%03d", labelCount) + ":");
    	CodeGenerator.objectFile.println("    ifeq L" + String.format("%03d", ++labelCount));
    	storedNumber = labelCount;
    	
    	// execute if block
    	SimpleNode ifBlockNode = (SimpleNode) node.jjtGetChild(1);
    	ifBlockNode.jjtAccept(this, data);
    	
    	// if else block follows, execute
    	if(node.jjtGetNumChildren() == 3){
    		CodeGenerator.objectFile.println("    goto L" + String.format("%03d", ++labelCount) + ":");
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
    	CodeGenerator.objectFile.println("    iconst_0");
    	CodeGenerator.objectFile.println("    goto L" + String.format("%03d", ++labelCount));
    	CodeGenerator.objectFile.println("L" + String.format("%03d", storedNumber) + ":");
    	CodeGenerator.objectFile.println("    iconst_1");
    	CodeGenerator.objectFile.println("L" + String.format("%03d", labelCount) + ":");
    	CodeGenerator.objectFile.println("    ifne L" + String.format("%03d", ++labelCount));
    	storedNumber = labelCount;
    	
    	SimpleNode blockNode = (SimpleNode) node.jjtGetChild(1);
    	blockNode.jjtAccept(this, data);
    	CodeGenerator.objectFile.println("    goto L" + String.format("%03d", indexToCondition) + ":");
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
    	String typePrefix = (type == Predefined.integerType) ? "i" : "f";
    	CodeGenerator.objectFile.println("    if_" + typePrefix + "cmpgt L" + String.format("%03d", ++labelCount));
    	return data;
    }
    
    public Object visit(ASTLE node, Object data){
    	SimpleNode leftHand = (SimpleNode) node.jjtGetChild(0);
    	SimpleNode rightHand = (SimpleNode) node.jjtGetChild(1);
    	
    	leftHand.jjtAccept(this, data);
    	rightHand.jjtAccept(this, data);
    	TypeSpec type = leftHand.getTypeSpec();
    	String typePrefix = (type == Predefined.integerType) ? "i" : "f";
    	CodeGenerator.objectFile.println("    if_" + typePrefix + "cmpge L" + String.format("%03d", ++labelCount));
    	return data;
    }
    
    public Object visit(ASTEQ node, Object data){
    	SimpleNode leftHand = (SimpleNode) node.jjtGetChild(0);
    	SimpleNode rightHand = (SimpleNode) node.jjtGetChild(1);
    	
    	leftHand.jjtAccept(this, data);
    	rightHand.jjtAccept(this, data);
    	TypeSpec type = leftHand.getTypeSpec();
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
}
