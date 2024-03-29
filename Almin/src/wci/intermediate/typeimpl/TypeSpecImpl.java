package wci.intermediate.typeimpl;

import java.util.HashMap;

import wci.intermediate.*;
import wci.intermediate.symtabimpl.Predefined;

import static wci.intermediate.typeimpl.TypeFormImpl.ARRAY;
import static wci.intermediate.typeimpl.TypeFormImpl.SUBRANGE;
import static wci.intermediate.typeimpl.TypeKeyImpl.*;

/**
 * <h1>TypeSpecImpl</h1>
 *
 * <p>A Pascal type specification implementation.</p>
 *
 * <p>Copyright (c) 2008 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class TypeSpecImpl
    extends HashMap<TypeKey, Object>
    implements TypeSpec
{
    private TypeForm form;           // type form
    private SymTabEntry identifier;  // type identifier

    /**
     * Constructor.
     * @param form the type form.
     */
    public TypeSpecImpl(TypeForm form)
    {
        this.form = form;
        this.identifier = null;
    }


    /**
     * Getter
     * @return the type form.
     */
    public TypeForm getForm()
    {
        return form;
    }

    /**
     * Setter.
     * @param identifier the type identifier (symbol table entry).
     */
    public void setIdentifier(SymTabEntry identifier)
    {
        this.identifier = identifier;
    }

    /**
     * Getter.
     * @return the type identifier (symbol table entry).
     */
    public SymTabEntry getIdentifier()
    {
        return identifier;
    }

    /**
     * Set an attribute of the specification.
     * @param key the attribute key.
     * @param value the attribute value.
     */
    public void setAttribute(TypeKey key, Object value)
    {
        this.put(key, value);
    }

    /**
     * Get the value of an attribute of the specification.
     * @param key the attribute key.
     * @return the attribute value.
     */
    public Object getAttribute(TypeKey key)
    {
        return this.get(key);
    }

    /**
     * @return the base type of this type.
     */
    public TypeSpec baseType()
    {
        return form == SUBRANGE ? (TypeSpec) getAttribute(SUBRANGE_BASE_TYPE)
                                : this;
    }
}
