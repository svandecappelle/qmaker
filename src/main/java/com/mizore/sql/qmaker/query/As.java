package com.mizore.sql.qmaker.query;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        SQL alias object.
 */
public class As {

    // Alias name.
    private String name;

    /**
     * Constructor alias.
     * 
     * @param name
     *            alias name.
     */
    public As(String name) {
        this.name = name;
    }

    /**
     * Get alias name.
     * 
     * @return the alias name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the alias name.
     * 
     * @param name
     *            the alias name.
     */
    public void setName(String name) {
        this.name = name;
    }

}
