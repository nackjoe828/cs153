package teamAlumni.frontend;

public class Assignment7VisitorAdaptor implements Assignment7Visitor{

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
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTBooleanLiteral node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTName node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTAssignmentStatement node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTControlStatement node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTIfStatement node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTWhileStatement node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTReturnStatement node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTDeclAndStat node, Object data) {
		// TODO Auto-generated method stub
        return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTmultiply node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTdivide node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTBlockStatement node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTlessThan node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTlessEqual node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTgreaterThan node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTgreaterEqual node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTequal node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTnotEqual node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTplus node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTminus node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTpositive node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTnegative node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTConstantLiteral node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTError node, Object data) {
		// TODO Auto-generated method stub
		return node.childrenAccept(this, data);
	}

}
