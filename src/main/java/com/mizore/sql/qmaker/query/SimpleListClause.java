package com.mizore.sql.qmaker.query;

import java.io.Serializable;

/**
 * @author svandecappelle
 * 
 * @since 0.0.1
 * 
 *        SimpleList clause interface.
 */
public interface SimpleListClause<T> extends Serializable {

    /**
     * Add a list element SQL clause field.
     * 
     * @param fieldName
     *            the field to group by.
     */
    T and(String fieldName);

    /**
     * Add a list element with table name.
     * 
     * @param tableName
     *            table.
     * @param fieldName
     *            field.
     */
    T and(String tableName, String fieldName);

    /**
     * Add a list element with table and schema.
     * 
     * @param schemaName
     *            schema name.
     * @param tableName
     *            table.
     * @param fieldName
     *            field.
     */
    T and(String schemaName, String tableName, String fieldName);

    /**
     * Get me clause.
     * 
     * @return me.
     */
    T getMe();
}
