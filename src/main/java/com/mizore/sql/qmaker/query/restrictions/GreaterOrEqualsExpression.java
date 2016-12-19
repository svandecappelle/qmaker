package com.mizore.sql.qmaker.query.restrictions;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.query.Field;

public class GreaterOrEqualsExpression extends Expression {

    private static final long serialVersionUID = 3913744069120416337L;

    /**
     * Create a greater or equals expression filter.
     * 
     * @param expression
     *            lower expression filter on value.
     */
    public GreaterOrEqualsExpression(String expression) {
        super(ExpressionType.GREATER_OR_EQUALS, expression);
    }

    /**
     * Create a greater or equals expression filter.
     * 
     * @param field
     *            lower expression filter on value.
     */
    public GreaterOrEqualsExpression(Field field) {
        super(ExpressionType.GREATER_OR_EQUALS, field.toString());
    }
}
