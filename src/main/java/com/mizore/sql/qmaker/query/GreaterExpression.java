package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;

public class GreaterExpression extends Expression {

    private static final long serialVersionUID = -3337753224713712840L;

    /**
     * Create a greater expression filter.
     * 
     * @param expression
     *            greater expression filter on value.
     */
    public GreaterExpression(String expression) {
        super(ExpressionType.GREATER, expression);
    }

    /**
     * Create a greater expression filter.
     * 
     * @param field
     *            greater expression filter on value.
     */
    public GreaterExpression(Field field) {
        super(ExpressionType.GREATER, field.toString());
    }

}
