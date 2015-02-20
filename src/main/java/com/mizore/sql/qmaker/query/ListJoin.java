package com.mizore.sql.qmaker.query;

import java.util.ArrayList;

/**
 * @author svandecappelle
 *
 * @param <T>
 *            join SQL on making the list of joins.
 * 
 */
public class ListJoin<T extends Join> extends ArrayList<T> {

    private static final long serialVersionUID = 6827422563337254770L;

    /**
     * Constructor list joins.
     */
    public ListJoin() {
    }

    /**
     * Convert all join into SQL String value clause.
     * 
     * @param string
     * @return
     */
    @Override
    public String toString() {
        StringBuilder joins = new StringBuilder();
        for (Join joinElement : this) {
            joins.append(joinElement.toString());
        }

        return joins.toString();
    }

}
