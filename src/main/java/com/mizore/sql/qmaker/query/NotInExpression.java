package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;

public class NotInExpression extends Expression {

    private static final long serialVersionUID = -1808612179232412557L;

    /**
     * Create a NOT_IN expression filter.
     * 
     * @param expression
     *            NOT_IN expression filter on value.
     */
    public NotInExpression(String expression) {
        super(ExpressionType.NOT_IN, expression);
    }

    /**
     * Create a IN expression filter.
     * 
     * @param field
     *            NOT_IN expression filter on value.
     */
    public NotInExpression(Field field) {
        super(ExpressionType.NOT_IN, field.toString());
    }
}
