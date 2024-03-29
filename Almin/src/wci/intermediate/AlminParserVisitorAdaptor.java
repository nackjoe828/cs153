package wci.intermediate;

import wci.frontend.ASTASSIGN;
import wci.frontend.ASTBlock;
import wci.frontend.ASTEQ;
import wci.frontend.ASTField;
import wci.frontend.ASTFunctionCall;
import wci.frontend.ASTGE;
import wci.frontend.ASTGT;
import wci.frontend.ASTIfStatement;
import wci.frontend.ASTIndex;
import wci.frontend.ASTLE;
import wci.frontend.ASTLOOP;
import wci.frontend.ASTLT;
import wci.frontend.ASTLiteral;
import wci.frontend.ASTNE;
import wci.frontend.ASTReturnStatement;
import wci.frontend.ASTStringLiteral;
import wci.frontend.ASTVariable;
import wci.frontend.ASTadd;
import wci.frontend.ASTand;
import wci.frontend.ASTdiv;
import wci.frontend.ASTmult;
import wci.frontend.ASTor;
import wci.frontend.ASTsub;
import wci.frontend.AlminParserVisitor;
import wci.frontend.SimpleNode;

public class AlminParserVisitorAdaptor implements AlminParserVisitor
{

	@Override
	public Object visit(SimpleNode node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTBlock node, Object data) {
		return node.childrenAccept(this, data);
	}

	/*@Override
	public Object visit(ASTStatements node, Object data) {
		return node.childrenAccept(this, data);
	}
*/
	@Override
	public Object visit(ASTASSIGN node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTIfStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTLOOP node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTFunctionCall node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTReturnStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTLT node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTLE node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTGT node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTGE node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTEQ node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTNE node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTadd node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTsub node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTor node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTmult node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTdiv node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTand node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTLiteral node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTVariable node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTStringLiteral node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTField node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTIndex node, Object data) {
		return node.childrenAccept(this, data);
	}

}
