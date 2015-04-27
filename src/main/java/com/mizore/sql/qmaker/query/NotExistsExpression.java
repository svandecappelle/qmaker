package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;

public class NotExistsExpression extends Expression {
    private static final long serialVersionUID = 2861357395829898800L;

    /**
     * Create a not exists expression filter.
     * 
     * @param expression
     *            not exists expression filter on value.
     */
    public NotExistsExpression(String expression) {
        super(ExpressionType.NOT_EXISTS, expression);
    }

    /**
     * Create a not exists expression filter.
     * 
     * @param field
     *            not exists expression filter on value.
     */
    public NotExistsExpression(Field field) {
        super(ExpressionType.NOT_EXISTS, field.toString());
    }
}
