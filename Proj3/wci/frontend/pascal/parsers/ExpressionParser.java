package wci.frontend.pascal.parsers;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import wci.frontend.*;
import wci.frontend.pascal.*;
import wci.intermediate.*;
import wci.intermediate.icodeimpl.*;

import static wci.frontend.pascal.PascalTokenType.*;
import static wci.frontend.pascal.PascalErrorCode.*;
import static wci.intermediate.icodeimpl.ICodeNodeTypeImpl.*;
import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;

/**
 * <h1>ExpressionParser</h1>
 *
 * <p>Parse a Pascal expression.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class ExpressionParser extends StatementParser
{
    /**
     * Constructor.
     * @param parent the parent parser.
     */
    public ExpressionParser(PascalParserTD parent)
    {
        super(parent);
    }

    // Synchronization set for starting an expression.
    static final EnumSet<PascalTokenType> EXPR_START_SET =
        EnumSet.of(PLUS, MINUS, IDENTIFIER, INTEGER, REAL, STRING,
                   PascalTokenType.NOT, LEFT_PAREN, LEFT_BRACKET);

    /**
     * Parse an expression.
     * @param token the initial token.
     * @return the root node of the generated parse tree.
     * @throws Exception if an error occurred.
     */
    public ICodeNode parse(Token token)
        throws Exception
    {
        return parseExpression(token);
    }

    // Set of relational operators.
    private static final EnumSet<PascalTokenType> REL_OPS =
        EnumSet.of(EQUALS, NOT_EQUALS, LESS_THAN, LESS_EQUALS,
                   GREATER_THAN, GREATER_EQUALS, IN); // added IN for set

    // Map relational operator tokens to node types.
    private static final HashMap<PascalTokenType, ICodeNodeType>
        REL_OPS_MAP = new HashMap<PascalTokenType, ICodeNodeType>();
    static {
        REL_OPS_MAP.put(EQUALS, EQ);
        REL_OPS_MAP.put(NOT_EQUALS, NE);
        REL_OPS_MAP.put(LESS_THAN, LT);
        REL_OPS_MAP.put(LESS_EQUALS, LE);
        REL_OPS_MAP.put(GREATER_THAN, GT);
        REL_OPS_MAP.put(GREATER_EQUALS, GE);
        REL_OPS_MAP.put(IN, IN_SET); //added for set
    };

    /**
     * Parse an expression.
     * @param token the initial token.
     * @return the root of the generated parse subtree.
     * @throws Exception if an error occurred.
     */
    private ICodeNode parseExpression(Token token)
        throws Exception
    {
        // Parse a simple expression and make the root of its tree
        // the root node.
        ICodeNode rootNode = parseSimpleExpression(token);

        token = currentToken();
        TokenType tokenType = token.getType();

        // Look for a relational operator.
        if (REL_OPS.contains(tokenType)) {
        	Token operatorToken = token;  //added for set

            // Create a new operator node and adopt the current tree
            // as its first child.
            ICodeNodeType nodeType = REL_OPS_MAP.get(tokenType);
            ICodeNode opNode = ICodeFactory.createICodeNode(nodeType);
            opNode.addChild(rootNode);

            token = nextToken();  // consume the operator

            // Parse the second simple expression.  The operator node adopts
            // the simple expression's tree as its second child.
			opNode.addChild(parseSimpleExpression(token));

			// type checking added for set
			if (checkBinaryOperatorType(opNode) == false) {
				errorHandler.flag(operatorToken, INVALID_OPERATOR, this);
			}

			// The operator node becomes the new root node.
			rootNode = opNode;
        }

        return rootNode;
    }

    // Set of additive operators.
    private static final EnumSet<PascalTokenType> ADD_OPS =
        EnumSet.of(PLUS, MINUS, PascalTokenType.OR);

    // Map additive operator tokens to node types.
    private static final HashMap<PascalTokenType, ICodeNodeTypeImpl>
        ADD_OPS_OPS_MAP = new HashMap<PascalTokenType, ICodeNodeTypeImpl>();
    static {
        ADD_OPS_OPS_MAP.put(PLUS, ADD);
        ADD_OPS_OPS_MAP.put(MINUS, SUBTRACT);
        ADD_OPS_OPS_MAP.put(PascalTokenType.OR, ICodeNodeTypeImpl.OR);
    };

    /**
     * Parse a simple expression.
     * @param token the initial token.
     * @return the root of the generated parse subtree.
     * @throws Exception if an error occurred.
     */
    private ICodeNode parseSimpleExpression(Token token)
        throws Exception
    {
        TokenType signType = null;  // type of leading sign (if any)

        // Look for a leading + or - sign.
        TokenType tokenType = token.getType();
        if ((tokenType == PLUS) || (tokenType == MINUS)) {
            signType = tokenType;
            token = nextToken();  // consume the + or -
        }

        // Parse a term and make the root of its tree the root node.
        ICodeNode rootNode = parseTerm(token);

        // Was there a leading - sign?
        if (signType == MINUS) {

            // Create a NEGATE node and adopt the current tree
            // as its child. The NEGATE node becomes the new root node.
            ICodeNode negateNode = ICodeFactory.createICodeNode(NEGATE);
            negateNode.addChild(rootNode);
            rootNode = negateNode;
        }

        token = currentToken();
        tokenType = token.getType();

        // Loop over additive operators.
        while (ADD_OPS.contains(tokenType)) {
        	Token operatorToken = token; //added for set
            // Create a new operator node and adopt the current tree
            // as its first child.
            ICodeNodeType nodeType = ADD_OPS_OPS_MAP.get(tokenType);
            ICodeNode opNode = ICodeFactory.createICodeNode(nodeType);
            opNode.addChild(rootNode);

            token = nextToken();  // consume the operator

            // Parse another term.  The operator node adopts
            // the term's tree as its second child.
			opNode.addChild(parseTerm(token));

			// type checking added for set
			if (checkBinaryOperatorType(opNode) == false) {
				errorHandler.flag(operatorToken, INVALID_OPERATOR, this);
			}

			// The operator node becomes the new root node.
			rootNode = opNode;

            token = currentToken();
            tokenType = token.getType();
        }

        return rootNode;
    }

    // Set of multiplicative operators.
    private static final EnumSet<PascalTokenType> MULT_OPS =
        EnumSet.of(STAR, SLASH, DIV, PascalTokenType.MOD, PascalTokenType.AND);

    // Map multiplicative operator tokens to node types.
    private static final HashMap<PascalTokenType, ICodeNodeType>
        MULT_OPS_OPS_MAP = new HashMap<PascalTokenType, ICodeNodeType>();
    static {
        MULT_OPS_OPS_MAP.put(STAR, MULTIPLY);
        MULT_OPS_OPS_MAP.put(SLASH, FLOAT_DIVIDE);
        MULT_OPS_OPS_MAP.put(DIV, INTEGER_DIVIDE);
        MULT_OPS_OPS_MAP.put(PascalTokenType.MOD, ICodeNodeTypeImpl.MOD);
        MULT_OPS_OPS_MAP.put(PascalTokenType.AND, ICodeNodeTypeImpl.AND);
    };

    /**
     * Parse a term.
     * @param token the initial token.
     * @return the root of the generated parse subtree.
     * @throws Exception if an error occurred.
     */
    private ICodeNode parseTerm(Token token)
        throws Exception
    {
        // Parse a factor and make its node the root node.
        ICodeNode rootNode = parseFactor(token);

        token = currentToken();
        TokenType tokenType = token.getType();

        // Loop over multiplicative operators.
        while (MULT_OPS.contains(tokenType)) {
        	Token operatorToken = token;
            // Create a new operator node and adopt the current tree
            // as its first child.
            ICodeNodeType nodeType = MULT_OPS_OPS_MAP.get(tokenType);
            ICodeNode opNode = ICodeFactory.createICodeNode(nodeType);
            opNode.addChild(rootNode);

            token = nextToken();  // consume the operator

            // Parse another factor.  The operator node adopts
            // the term's tree as its second child.
			opNode.addChild(parseFactor(token));

			// type checking added for set
			if (checkBinaryOperatorType(opNode) == false) {
				errorHandler.flag(operatorToken, INVALID_OPERATOR, this);
			}

			// The operator node becomes the new root node.
			rootNode = opNode;

            token = currentToken();
            tokenType = token.getType();
        }

        return rootNode;
    }

    /**
     * Parse a factor.
     * @param token the initial token.
     * @return the root of the generated parse subtree.
     * @throws Exception if an error occurred.
     */
    private ICodeNode parseFactor(Token token)
        throws Exception
    {
        TokenType tokenType = token.getType();
        ICodeNode rootNode = null;

        switch ((PascalTokenType) tokenType) {

            case IDENTIFIER: {
                // Look up the identifier in the symbol table stack.
                // Flag the identifier as undefined if it's not found.
                String name = token.getText().toLowerCase();
                SymTabEntry id = symTabStack.lookup(name);
                if (id == null) {
                    errorHandler.flag(token, IDENTIFIER_UNDEFINED, this);
                    id = symTabStack.enterLocal(name);
                }

                rootNode = ICodeFactory.createICodeNode(VARIABLE);
                rootNode.setAttribute(ID, id);
                id.appendLineNumber(token.getLineNumber());

                token = nextToken();  // consume the identifier
                break;
            }

            case INTEGER: {
                // Create an INTEGER_CONSTANT node as the root node.
                rootNode = ICodeFactory.createICodeNode(INTEGER_CONSTANT);
                rootNode.setAttribute(VALUE, token.getValue());

                token = nextToken();  // consume the number
                break;
            }

            case REAL: {
                // Create an REAL_CONSTANT node as the root node.
                rootNode = ICodeFactory.createICodeNode(REAL_CONSTANT);
                rootNode.setAttribute(VALUE, token.getValue());

                token = nextToken();  // consume the number
                break;
            }

            case STRING: {
                String value = (String) token.getValue();

                // Create a STRING_CONSTANT node as the root node.
                rootNode = ICodeFactory.createICodeNode(STRING_CONSTANT);
                rootNode.setAttribute(VALUE, value);

                token = nextToken();  // consume the string
                break;
            }

            case NOT: {
                token = nextToken();  // consume the NOT

                // Create a NOT node as the root node.
                rootNode = ICodeFactory.createICodeNode(ICodeNodeTypeImpl.NOT);

                // Parse the factor.  The NOT node adopts the
                // factor node as its child.
                rootNode.addChild(parseFactor(token));

                break;
            }

            case LEFT_PAREN: {
                token = nextToken();      // consume the (

                // Parse an expression and make its node the root node.
                rootNode = parseExpression(token);

                // Look for the matching ) token.
                token = currentToken();
                if (token.getType() == RIGHT_PAREN) {
                    token = nextToken();  // consume the )
                }
                else {
                    errorHandler.flag(token, MISSING_RIGHT_PAREN, this);
                }

                break;
            }
            
          //added for set
            case LEFT_BRACKET: { 
            	token = nextToken();      // consume the [
 
            	// Create a SET node as the root node.
                rootNode = ICodeFactory.createICodeNode(ICodeNodeTypeImpl.SET);
                Set<Integer> existingIntegerValues = new HashSet<Integer>();

            	while (token.getType() != RIGHT_BRACKET) {
                    // error handling
            		while (token.getType() == COMMA){
                		errorHandler.flag(token, EXTRA_COMMAS, this);
                		token = nextToken(); // consume the ,
                	}               		
            		
					Integer lowerBound = null;
					Integer upperBound = null;

            		ICodeNode node = null;
            		// Parse an expression
            		node = parseExpression(token);
            		
            		if (node.getType() == ICodeNodeTypeImpl.INTEGER_CONSTANT) {
            			lowerBound = (Integer)node.getAttribute(VALUE);
            			if (existingIntegerValues.add(lowerBound) == false) {
            				errorHandler.flag(token, NON_UNIQUE_MEMBERS, this);
            			}
            		}
            		
                    token = currentToken();
                    if (token.getType() == DOT_DOT) {                    	                   	
                    	ICodeNode rangeNode = ICodeFactory.createICodeNode(ICodeNodeTypeImpl.RANGE);
                    	rangeNode.addChild(node);
                    	token = nextToken(); // consume the ..
                        // error handling
                    	if (token.getType() == COMMA){
                    		errorHandler.flag(token, INVALID_RANGE_OF_VALUES, this);
                    		token = nextToken(); // consume the ,
                    		continue;
                    	}                    	
						ICodeNode tempNode = parseExpression(token);
						if (tempNode.getType() == ICodeNodeTypeImpl.INTEGER_CONSTANT) {
							upperBound = (Integer) tempNode.getAttribute(VALUE);
							if (lowerBound == null) {
								if (existingIntegerValues.add(upperBound) == false) {
		            				errorHandler.flag(token, NON_UNIQUE_MEMBERS, this);
		            			}
							} else { // lowerBound exists
								if (upperBound < lowerBound) {
									errorHandler.flag(token, INVALID_RANGE_OF_VALUES, this);
								} else {
									for (int i = lowerBound + 1; i <= upperBound; i++) {
										if (existingIntegerValues.add(i) == false) {
											errorHandler.flag(token, NON_UNIQUE_MEMBERS, this);
										}
									}
								}
							}
						}

                    	rangeNode.addChild(tempNode);
                    	node = rangeNode;
                    	
                    	token = currentToken();
                    }
                    
                    if ((token.getType() == COMMA) || (token.getType() == RIGHT_BRACKET)) {
                    	rootNode.addChild(node);
                    	if (token.getType() == COMMA) {
                    		Token tempToken = token;
                    		token = nextToken(); // consume the ,
                    		//error handling
                    		if (token.getType() == RIGHT_BRACKET) {
                    			errorHandler.flag(tempToken, EXTRA_COMMAS, this);
                    		}
                    	}
                    } else {
                    	// error handling
                        if (token.getType() == SEMICOLON){
                    		errorHandler.flag(token, MISSING_RIGHT_BRACKET, this);
                    		break;
                    	} else {
                    		errorHandler.flag(token, MISSING_COMMA, this);
                    	}
                    }
            	}
            	
            	if (token.getType() == RIGHT_BRACKET){
            		token = nextToken();  // consume the ]
            	} else { // currentToken is SEMICOLON
            		token = currentToken();
            	}
            	
            	break;
            }
            	

            default: {
                errorHandler.flag(token, UNEXPECTED_TOKEN, this);
                break;
            }
        }

        return rootNode;
    }

  //added for set
	private boolean checkBinaryOperatorType(ICodeNode node) {
		ArrayList<ICodeNode> children = node.getChildren();
		ICodeNodeType type1 = children.get(0).getType();
		ICodeNodeType type2 = children.get(1).getType();

		switch ((ICodeNodeTypeImpl) (node.getType())) {
		case LT:
		case GT:
		case OR:
		case AND:
		case MOD:
		case INTEGER_DIVIDE:
		case FLOAT_DIVIDE:
			if ((type1 == ICodeNodeTypeImpl.SET)
					|| (type2 == ICodeNodeTypeImpl.SET)) {
				return false;
			}
			break;
		case IN_SET:
			if ((type1 == ICodeNodeTypeImpl.SET)
					|| (type2 == ICodeNodeTypeImpl.INTEGER_CONSTANT)) {
				return false;
			}
			break;
		}
		return true;
	}
}

