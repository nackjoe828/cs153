package wci.intermediate;

import wci.frontend.ASTEQ;
import wci.frontend.ASTFunctionCall;
import wci.frontend.ASTGE;
import wci.frontend.ASTGT;
import wci.frontend.ASTIndex;
import wci.frontend.ASTLE;
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
import wci.frontend.SimpleNode;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.symtabimpl.Predefined;
import wci.intermediate.symtabimpl.SymTabKeyImpl;


public class TypeSetterVisitor extends AlminParserVisitorAdaptor
{
    private void setType(SimpleNode node)
    {
        int count = node.jjtGetNumChildren();
        TypeSpec type = Predefined.integerType;
        
        for (int i = 0; (i < count) && (type == Predefined.integerType); ++i) {
            SimpleNode child = (SimpleNode) node.jjtGetChild(i);
            TypeSpec childType = child.getTypeSpec();
            
            if (childType == Predefined.stringType) {
            	type = Predefined.stringType;
            	break;
            } else if (childType == Predefined.booleanType) {
                type = Predefined.booleanType;
                break;
            }
            else if (childType == Predefined.realType) {
                type = Predefined.realType;
                break;
            }
        }
        node.setTypeSpec(type);
    }

	@Override
	public Object visit(ASTReturnStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTLT node, Object data) {
        Object obj = super.visit(node, data);
        node.setTypeSpec(Predefined.booleanType);
        return obj;
	}

	@Override
	public Object visit(ASTLE node, Object data) {
        Object obj = super.visit(node, data);
        node.setTypeSpec(Predefined.booleanType);
        return obj;
	}

	@Override
	public Object visit(ASTGT node, Object data) {
        Object obj = super.visit(node, data);
        node.setTypeSpec(Predefined.booleanType);
        return obj;
	}

	@Override
	public Object visit(ASTGE node, Object data) {
        Object obj = super.visit(node, data);
        node.setTypeSpec(Predefined.booleanType);
        return obj;
	}

	@Override
	public Object visit(ASTEQ node, Object data) {
        Object obj = super.visit(node, data);
        node.setTypeSpec(Predefined.booleanType);
        return obj;
	}

	@Override
	public Object visit(ASTNE node, Object data) {
        Object obj = super.visit(node, data);
        node.setTypeSpec(Predefined.booleanType);
        return obj;
	}

	@Override
	public Object visit(ASTadd node, Object data) {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	@Override
	public Object visit(ASTsub node, Object data) {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	@Override
	public Object visit(ASTor node, Object data) {
        Object obj = super.visit(node, data);
        node.setTypeSpec(Predefined.booleanType);
        return obj;
	}

	@Override
	public Object visit(ASTmult node, Object data) {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	@Override
	public Object visit(ASTdiv node, Object data) {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	@Override
	public Object visit(ASTand node, Object data) {
        Object obj = super.visit(node, data);
        node.setTypeSpec(Predefined.booleanType);
        return obj;
	}

	@Override
	public Object visit(ASTLiteral node, Object data) {
		return data;
	}

	@Override
	public Object visit(ASTVariable node, Object data) {
        Object obj = super.visit(node, data);
        return obj;
	}
	
	@Override
	public Object visit(ASTStringLiteral node, Object data) {
		return data;
	}
	
}
