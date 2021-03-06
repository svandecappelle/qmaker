package com.mizore.sql.qmaker.query.restrictions;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.query.Field;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        An SQL Equals expression. example: X = Y.
 */
public class EqualsExpression extends Expression {

    private static final long serialVersionUID = 8160848547816203656L;

    /**
     * Create an equals expression filter.
     * 
     * @param expression
     *            equals expression filter on value.
     */
    public EqualsExpression(String expression) {
        super(ExpressionType.EQUALS, expression);
    }

    /**
     * Create an equals expression filter.
     * 
     * @param field
     *            equals expression filter on value.
     */
    public EqualsExpression(Field field) {
        super(ExpressionType.EQUALS, field.toString());
    }

}
