package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.utils.SqlStringConstants;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Select field SQL.
 */
public class Field {

    // Table from field.
    private Table table;

    // Field name.
    private String fieldName;

    // Field alias.
    private As as;

    /**
     * Constructor.
     * 
     * @param fieldName
     *            the SQL field name.
     */
    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Constructor with table name parameter.
     * 
     * @param table
     *            table name.
     * @param fieldName
     *            field name.
     */
    public Field(Table table, String fieldName) {
        this.table = table;
        this.fieldName = fieldName;
    }

    /**
     * Add alias to field name.
     * 
     * @param alias
     *            the alias to set.
     * @return the alias clause.
     */
    public As as(String alias) {
        if (as == null) {
            this.as = new As(alias);
        }
        return this.as;
    }

    /**
     * Get the field name.
     * 
     * @return the field name.
     */
    public String getName() {
        return this.fieldName;
    }

    /**
     * Get the alias name.
     * 
     * @return the alias name.
     */
    public As getAlias() {
        return as;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (table != null) {
            builder.append(table.toString());
            builder.append(SqlStringConstants.DOT_SEPARATOR);
        }

        builder.append(getName());

        if (getAlias() != null) {
            builder.append(SqlStringConstants.EMPTY_SEPARATOR);
            builder.append(SqlStringConstants.AS);
            builder.append(SqlStringConstants.EMPTY_SEPARATOR);
            builder.append(getAlias().getName());
        }

        return builder.toString();
    }
}
