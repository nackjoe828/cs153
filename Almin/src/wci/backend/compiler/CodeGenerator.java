package wci.backend.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.io.*;

import wci.frontend.*;
import wci.intermediate.*;
import wci.intermediate.symtabimpl.Predefined;
import wci.backend.*;
import static wci.intermediate.symtabimpl.SymTabKeyImpl.*;
import static wci.intermediate.symtabimpl.DefinitionImpl.*;

/**
 * <p>The code generator for a compiler back end.</p>
 *
 * <p>Copyright (c) 2008 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class CodeGenerator extends Backend
{
    private static final int STACK_LIMIT = 16;
        
    static ICode iCode;
    static SymTabStack symTabStack;
    static PrintWriter objectFile;
    
    static ArrayList<SymTabEntry> paramIndexAndEntry;

    /**
     * Process the intermediate code and the symbol table generated by the
     * parser to generate machine-language instructions.
     * @param iCode the intermediate code.
     * @param symTabStack the symbol table stack.
     * @param objectFile the object file path for the generated code.
     * @throws Exception if an error occurred.
     */
    public void process(ICode iCode, SymTabStack symTabStack,
                        String objectFilePath)
        throws Exception
    {
        CodeGenerator.iCode       = iCode;
        CodeGenerator.symTabStack = symTabStack;
        CodeGenerator.objectFile  = new PrintWriter(objectFilePath);

        // Make the program and method names.
        int start = objectFilePath.lastIndexOf("/") + 1;
        String programName = objectFilePath.substring(start);
        int end = programName.indexOf(".");
        if (end > -1) {
            programName = programName.substring(0, end);
        }
        programName = programName.substring(0, 1).toUpperCase() +
                      programName.substring(1);
        
        SymTabEntry programId = symTabStack.getProgramId();
        //int localsCount = (Integer) programId.getAttribute(ROUTINE_LOCALS_COUNT);
        SymTab routineSymTab = 
                (SymTab) programId.getAttribute(ROUTINE_SYMTAB);
        ArrayList<SymTabEntry> locals = routineSymTab.sortedEntries();

        // Generate the program header.
        objectFile.println(".class public " + programName);
        objectFile.println(".super java/lang/Object");
        objectFile.println();
        
        // Generate code for the timer and standard input fields.
        objectFile.println(".field private static _runTimer LRunTimer;");
        objectFile.println(".field private static _standardIn LPascalTextIn;");
        objectFile.println();

        objectFile.println();
        
        // Generate the class constructor.
        objectFile.println(".method public <init>()V");
        objectFile.println();
        objectFile.println("	aload_0");
        objectFile.println("	invokenonvirtual	java/lang/Object/<init>()V");
        objectFile.println("	return");
        objectFile.println();
        objectFile.println(".limit locals 1");
        objectFile.println(".limit stack 1");
        objectFile.println(".end method");
        objectFile.println();
        
        // generate code for method declaration
        String methodName, strBuf;
        ArrayList<SymTabEntry> funcList = (ArrayList<SymTabEntry>)programId.getAttribute(ROUTINE_ROUTINES);
        ArrayList<SymTabEntry> paramList;
        for (SymTabEntry currentEntry : funcList){
        	paramIndexAndEntry = new ArrayList<SymTabEntry>();
        	strBuf = ".method public static " + currentEntry.getName() + "(";
        	paramList = (ArrayList<SymTabEntry>)currentEntry.getAttribute(ROUTINE_PARMS);
        	for(SymTabEntry param : paramList){
        		//store parameter to the list, attached with slot number
        		paramIndexAndEntry.add(param);
        		TypeSpec type = param.getTypeSpec();
        		String typeCode="";
        		if(type == Predefined.integerType){
        			typeCode = "I";
        		}
        		else if(type == Predefined.realType){
        			typeCode = "F";
        		}
        		else if(type == Predefined.charType){
        			typeCode = "C";
        		}
        		else if(type == Predefined.stringType){
        			typeCode = "Ljava/lang/String;";
        		}
        		else if(type == Predefined.booleanType){
        			typeCode = "Z";
        		}
        		strBuf += typeCode;
        	}
        	
        	
        	
        	//add local variable to the treemap, attached with slot number
        	SymTab currentFuncSymTab = (SymTab) currentEntry.getAttribute(ROUTINE_SYMTAB); 
        	ArrayList<SymTabEntry> tabEntries = currentFuncSymTab.sortedEntries();
        	for(SymTabEntry currentTabEntry : tabEntries){
        		if(!paramList.contains(currentTabEntry)){
        			paramIndexAndEntry.add(currentTabEntry);
        		}
        	}
        	
        	strBuf += ")";
        	TypeSpec retType = currentEntry.getTypeSpec();
    		String typeCode="";
    		if(retType == Predefined.integerType){
    			typeCode = "I";
    		}
    		else if(retType == Predefined.realType){
    			typeCode = "F";
    		}
    		else if(retType == Predefined.charType){
    			typeCode = "C";
    		}
    		else if(retType == Predefined.stringType){
    			typeCode = "Ljava/lang/String;";
    		}
    		else if(retType == Predefined.booleanType){
    			typeCode = "Z";
    		}
    		strBuf += typeCode;
    		objectFile.println(strBuf);
    		
    		//generate code inside method
    		CodeGeneratorVisitor codeVisitor = new CodeGeneratorVisitor();
    		ICode funcTree = (ICode)currentEntry.getAttribute(ROUTINE_ICODE);
    		Node rootFunc = funcTree.getRoot();
    		rootFunc.jjtAccept(codeVisitor, programName);
    		
    		SymTab funcTable = (SymTab) currentEntry.getAttribute(ROUTINE_SYMTAB);
    		int localCount = funcTable.sortedEntries().size();
    		
    		
    		
    		objectFile.println(".limit locals " + localCount);
    		objectFile.println(".limit stack  " + STACK_LIMIT);
    		objectFile.println(".end method\n");
        }
        
        // Generate the main method header.
        objectFile.println(".method public static main([Ljava/lang/String;)V");
        objectFile.println();
        
        // Generate the main method prologue.
        objectFile.println("    new	 RunTimer");
        objectFile.println("    dup");
        objectFile.println("    invokenonvirtual	RunTimer/<init>()V");
        objectFile.println("    putstatic	" + programName +
        		           "/_runTimer LRunTimer;");
        objectFile.println("    new	 PascalTextIn");
        objectFile.println("    dup");
        objectFile.println("    invokenonvirtual	PascalTextIn/<init>()V");
        objectFile.println("    putstatic	" + programName +
        		           "/_standardIn LPascalTextIn;");
        objectFile.println();
        objectFile.flush();
        
        //variable for main
        paramIndexAndEntry = new ArrayList<SymTabEntry>();
        SymTab programTab = (SymTab) programId.getAttribute(ROUTINE_SYMTAB);
        SymTab mainTab = (SymTab) programTab.lookup("main").getAttribute(ROUTINE_SYMTAB);
    	ArrayList<SymTabEntry> tabEntries = mainTab.sortedEntries();
    	for(SymTabEntry currentTabEntry : tabEntries){
			paramIndexAndEntry.add(currentTabEntry);
    	}

        // Visit the parse tree nodes to generate code 
        // for the main method's compound statement.
        CodeGeneratorVisitor codeVisitor = new CodeGeneratorVisitor();
        Node rootNode = iCode.getRoot();
        rootNode.jjtAccept(codeVisitor, programName);
        objectFile.println();

        // Generate the main method epilogue.
        objectFile.println("    getstatic	" + programName + "/_runTimer LRunTimer;");
        objectFile.println("    invokevirtual	RunTimer.printElapsedTime()V");
        objectFile.println();
        objectFile.println("    return");
        objectFile.println();
        objectFile.println(".limit locals " + 4);
        objectFile.println(".limit stack  " + STACK_LIMIT);
        objectFile.println(".end method");
        objectFile.flush();

        CodeGenerator.objectFile.close();
    }
}
