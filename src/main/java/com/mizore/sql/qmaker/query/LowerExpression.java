package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;

public class LowerExpression extends Expression {
    private static final long serialVersionUID = -2985343137995257968L;

    /**
     * Create a lower expression filter.
     * 
     * @param expression
     *            lower expression filter on value.
     */
    public LowerExpression(String expression) {
        super(ExpressionType.LOWER, expression);
    }

    /**
     * Create a lower expression filter.
     * 
     * @param field
     *            lower expression filter on value.
     */
    public LowerExpression(Field field) {
        super(ExpressionType.LOWER, field.toString());
    }

}
