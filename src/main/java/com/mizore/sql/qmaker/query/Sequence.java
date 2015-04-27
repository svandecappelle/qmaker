package com.mizore.sql.qmaker.query;

import java.io.Serializable;

/**
 * An SQL Sequence.
 * 
 * @author svandecappelle
 * @since 2.0.0
 */
public class Sequence implements Serializable {

    private static final long serialVersionUID = 4437135502090333868L;

    private String name;

    public Sequence() {
    }

    public Sequence(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return getName().concat(".nextVal");
    }
}
