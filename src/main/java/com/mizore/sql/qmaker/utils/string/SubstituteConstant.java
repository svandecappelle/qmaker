package com.mizore.sql.qmaker.utils.string;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Substitute expression with a constant value.
 */
public class SubstituteConstant implements Subsitute {

    private static final long serialVersionUID = -7083864450604688616L;

    // The key constant replacement value.
    private String constant;

    // The replacement string whom need to replace the key.
    private String value;

    /**
     * Constructor with constant value key to substitute.
     * 
     * @param constant
     *            the key constant to substitute.
     */
    public SubstituteConstant(String constant) {
        this.constant = constant;
    }

    /**
     * The replacement value.
     * 
     * @param value
     *            the replacement String value need to be replaced from the key.
     * @return the substitute constant clause.
     */
    public SubstituteConstant with(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getReplacementPattern() {
        return "{{".concat(constant).concat("}}");
    }

}
