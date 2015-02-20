package com.mizore.sql.qmaker.filters.expressions;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        An SQL Equals expression. example: X = Y.
 */
public class EqualsExpression extends Expression {

    /**
     * Create an equals expression filter.
     * 
     * @param expression
     *            equals expression filter on value.
     */
    public EqualsExpression(String expression) {
        super(ExpressionType.EQUALS, expression);
    }

}
