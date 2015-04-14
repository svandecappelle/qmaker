package com.mizore.sql.qmaker.query;

import java.io.Serializable;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        SQL alias object.
 */
public class As implements Serializable{

    private static final long serialVersionUID = 3162884835394294222L;

    // Alias name.
    private String name;

    /**
     * Constructor alias.
     * 
     * @param name
     *            alias name.
     */
    public As(String name) {
        this.setName(name);
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
