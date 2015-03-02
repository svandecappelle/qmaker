package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.utils.SeparatorType;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Order clause field.
 */
public class OrderField extends Field {

    /**
     * @author svandecappelle
     *
     * @since 0.0.1
     *
     *        Order possible values.
     */
    public enum OrderClauses {
        ASC, DESC;
    }

    private boolean ascending = true;

    /**
     * Constructor.
     * 
     * @param fieldName
     *            the SQL field name.
     */
    public OrderField(String fieldName) {
        super(fieldName);
    }

    /**
     * Constructor with table name parameter.
     * 
     * @param table
     *            table name.
     * @param fieldName
     *            field name.
     */
    public OrderField(Table table, String fieldName) {
        super(table, fieldName);
    }

    /**
     * Order by ASC.
     */
    public void asc() {
        ascending = true;
    }

    /**
     * Order by DESC.
     */
    public void desc() {
        ascending = false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        builder.append(SeparatorType.EMPTY);
        if (ascending) {
            builder.append(OrderClauses.ASC.name());
        } else {
            builder.append(OrderClauses.DESC.name());
        }

        return builder.toString();
    }
}
