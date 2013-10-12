package wci.frontend.pascal.parsers;

import java.util.ArrayList;
import java.util.EnumSet;

import wci.frontend.Token;
import wci.frontend.TokenType;
import wci.frontend.pascal.PascalParserTD;
import wci.frontend.pascal.PascalTokenType;
import wci.intermediate.SymTabEntry;
import wci.intermediate.TypeFactory;
import wci.intermediate.TypeForm;
import wci.intermediate.TypeSpec;

import static wci.frontend.pascal.PascalTokenType.*;
import static wci.frontend.pascal.PascalErrorCode.*;
import static wci.intermediate.typeimpl.TypeKeyImpl.*;
import static wci.intermediate.typeimpl.TypeFormImpl.ARRAY;
import static wci.intermediate.typeimpl.TypeFormImpl.ENUMERATION;
import static wci.intermediate.typeimpl.TypeFormImpl.SET;
import static wci.intermediate.typeimpl.TypeFormImpl.SUBRANGE;
import static wci.intermediate.typeimpl.TypeKeyImpl.ARRAY_ELEMENT_COUNT;
import static wci.intermediate.typeimpl.TypeKeyImpl.ARRAY_ELEMENT_TYPE;
import static wci.intermediate.typeimpl.TypeKeyImpl.ARRAY_INDEX_TYPE;
import static wci.intermediate.typeimpl.TypeKeyImpl.ENUMERATION_CONSTANTS;
import static wci.intermediate.typeimpl.TypeKeyImpl.SUBRANGE_MAX_VALUE;
import static wci.intermediate.typeimpl.TypeKeyImpl.SUBRANGE_MIN_VALUE;

/**
 * <h1>SetTypeParser</h1>
 * 
 * <p>Parse a Pascal set type specification.</p>
 * 
 * @author naokinakatani
 *
 */
public class SetTypeParser extends TypeSpecificationParser{
	
	/**
	 * Constructor.
	 * @param parent the parent parser.
	 */
	protected SetTypeParser(PascalParserTD parent){
		super(parent);
	}
	
    // Synchronization set for OF.
    private static final EnumSet<PascalTokenType> OF_SET =
        TypeSpecificationParser.TYPE_START_SET.clone();
    static {
        OF_SET.add(OF);
        OF_SET.add(SEMICOLON);
    }
	
    /**
     * Parse a Pascal set type specification.
     * @param token the current token.
     * @return the set type specification
     * @throws Exception if an error occurred.
     */
	public TypeSpec parse(Token token)
		throws Exception{
		TypeSpec setType = TypeFactory.createType(SET);
		token = nextToken(); // consume SET
		
		//OF
		token = synchronize(OF_SET);
		if (token.getType() == OF) {
			token = nextToken(); // consume OF
		}
		else {
			errorHandler.flag(token, MISSING_OF, this);
		}
		
		// Parse the list of index types
		TypeSpec elementType = parseIndexType(token, setType);
		
		//elementType.setAttribute(SET_ELEMENT_TYPE, value)
		
		return setType;
	}
    
    /**
     * Parse an element type specification.
     * @param token the current token.
     * @param setType the current set type specification.
     * @throws Exception if an error occurred.
     */
    private TypeSpec parseIndexType(Token token, TypeSpec setType)
        throws Exception
    {
    	TypeSpec elementType = setType;
    	
        SimpleTypeParser simpleTypeParser = new SimpleTypeParser(this);
        TypeSpec indexType = simpleTypeParser.parse(token);
        elementType.setAttribute(SET_ELEMENT_TYPE, indexType);

        if (indexType == null) {
            return elementType;
        }

        TypeForm form = indexType.getForm();
        int count = 0;

        // Check the index type and set the element count.
        if (form == SUBRANGE) {
            Integer minValue =
                (Integer) indexType.getAttribute(SUBRANGE_MIN_VALUE);
            Integer maxValue =
                (Integer) indexType.getAttribute(SUBRANGE_MAX_VALUE);

            if ((minValue != null) && (maxValue != null)) {
                count = maxValue - minValue + 1;
            }
        }
        else if (form == ENUMERATION) {
            ArrayList<SymTabEntry> constants = (ArrayList<SymTabEntry>)
                indexType.getAttribute(ENUMERATION_CONSTANTS);
            count = constants.size();
        }
        else {
            errorHandler.flag(token, INVALID_INDEX_TYPE, this);
        }
        elementType.setAttribute(SET_ELEMENT_COUNT, count);
        
        return elementType;
    }
}
