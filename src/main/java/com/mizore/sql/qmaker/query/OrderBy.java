package com.mizore.sql.qmaker.query;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Order by clause on field.
 */
public interface OrderBy {

    /**
     * Add a ascending parameter.
     * 
     * @return the order by clause.
     */
    OrderBy asc();

    /**
     * Add a descending parameter.
     * 
     * @return the order by clause.
     */
    OrderBy desc();
}
