package com.mizore.sql.qmaker.utils.string;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Replacement String template.
 */
public class Template implements Serializable {

    private static final long serialVersionUID = 5869197855002571026L;

    // Substitutes.
    private ArrayList<Subsitute> substitutes;

    /**
     * Constructor.
     */
    public Template() {
        substitutes = new ArrayList<Subsitute>();
    }

    /**
     * Template replacement definition.
     * 
     * @param constant
     *            the string constant pattern replacement
     * @param value
     *            the value to replace with.
     * @return the template clause.
     */
    public Template c(String constant, Object value) {
        this.substitutes.add(new SubstituteConstant(constant).with(value.toString()));
        return this;
    }

    /**
     * Get substitutes list.
     * 
     * @return the substitutes.
     */
    public List<Subsitute> getSubstitutes() {
        return substitutes;
    }
}
