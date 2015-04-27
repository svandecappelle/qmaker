package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;

public class LikeExpression extends Expression {

    private static final long serialVersionUID = 8488561053963973660L;

    /**
     * Create a like expression filter.
     * 
     * @param expression
     *            like expression filter on value.
     */
    public LikeExpression(String expression) {
        super(ExpressionType.LIKE, expression);
    }

    /**
     * Create a like expression filter.
     * 
     * @param field
     *            like expression filter on value.
     */
    public LikeExpression(Field field) {
        super(ExpressionType.LIKE, field.toString());
    }

}
