package teamAlumni.frontend;

import teamAlumni.frontend.SimpleNode;
import wci.intermediate.TypeSpec;
import wci.intermediate.symtabimpl.Predefined;

public class TypeSetterVisitor extends Assignment7VisitorAdaptor{

    private void setType(SimpleNode node)
    {
        int count = node.jjtGetNumChildren();
        TypeSpec type = Predefined.integerType;
        
        for (int i = 0; (i < count) && (type == Predefined.integerType); ++i) {
            SimpleNode child = (SimpleNode) node.jjtGetChild(i);
            TypeSpec childType = child.getTypeSpec();
            
            if (childType == Predefined.realType) {
                type = Predefined.realType;
            }
        }
        
        node.setTypeSpec(type);
    }	
	
    /*
	@Override
	public Object visit(SimpleNode node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTCompilationUnit node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTConstant node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTNewType node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTNewTypeDefinition node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTFunctionList node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTFunctionDeclaration node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTFuncVariableDeclaration node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}
	
	*/

	@Override
	public Object visit(ASTType node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTFunctionDefinition node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTFunction node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTVariableDeclaration node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTLiteral node, Object data) {
		// TODO Auto-generated method stub
        return data;
	}

	@Override
	public Object visit(ASTBooleanLiteral node, Object data) {
		// TODO Auto-generated method stub
        return data;
	}

	@Override
	public Object visit(ASTName node, Object data) {
		// TODO Auto-generated method stub
        return data;
	}

	@Override
	public Object visit(ASTAssignmentStatement node, Object data) {
		// TODO Auto-generated method stub
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	@Override
	public Object visit(ASTmultiply node, Object data) {
		// TODO Auto-generated method stub
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	@Override
	public Object visit(ASTdivide node, Object data) {
		// TODO Auto-generated method stub
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	@Override
	public Object visit(ASTplus node, Object data) {
		// TODO Auto-generated method stub
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	@Override
	public Object visit(ASTminus node, Object data) {
		// TODO Auto-generated method stub
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}	
}
