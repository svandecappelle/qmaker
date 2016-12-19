package com.mizore.sql.qmaker.query.restrictions;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.query.Field;

public class InExpression extends Expression {

    private static final long serialVersionUID = 8092856738118907554L;

    /**
     * Create a IN expression filter.
     * 
     * @param expression
     *            IN expression filter on value.
     */
    public InExpression(String expression) {
        super(ExpressionType.IN, expression);
    }

    /**
     * Create a IN expression filter.
     * 
     * @param field
     *            IN expression filter on value.
     */
    public InExpression(Field field) {
        super(ExpressionType.IN, field.toString());
    }

}
