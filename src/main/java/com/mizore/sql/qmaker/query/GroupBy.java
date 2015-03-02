package com.mizore.sql.qmaker.query;

/**
 * @author svandecappelle
 * 
 * @since 0.0.1
 * 
 *        Group by clause interface.
 */
public interface GroupBy {

    /**
     * Add a simple groupBy SQL clause field.
     * 
     * @param fieldName
     *            the field to group by.
     */
    GroupBy and(String fieldName);

    /**
     * Add a group by with table name.
     * 
     * @param tableName
     *            table.
     * @param fieldName
     *            field.
     */
    GroupBy and(String tableName, String fieldName);

    /**
     * Add a group by with table and schema.
     * 
     * @param schemaName
     *            schema name.
     * @param tableName
     *            table.
     * @param fieldName
     *            field.
     */
    GroupBy and(String schemaName, String tableName, String fieldName);
}
