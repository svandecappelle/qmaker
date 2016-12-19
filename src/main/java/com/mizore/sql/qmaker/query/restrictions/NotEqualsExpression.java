package com.mizore.sql.qmaker.query.restrictions;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.query.Field;

/**
 * An SQL Equals expression. example: X = Y.
 * 
 * @author svandecappelle
 * @since 0.0.1
 */
public class NotEqualsExpression extends Expression {

    private static final long serialVersionUID = 8160848547816203656L;

    /**
     * Create an not equals expression filter.
     * 
     * @param expression
     *            not equals expression filter on value.
     */
    public NotEqualsExpression(String expression) {
        super(ExpressionType.DIFFERENT, expression);
    }

    /**
     * Create an not equals expression filter.
     * 
     * @param field
     *            not equals expression filter on value.
     */
    public NotEqualsExpression(Field field) {
        super(ExpressionType.DIFFERENT, field.toString());
    }

}
