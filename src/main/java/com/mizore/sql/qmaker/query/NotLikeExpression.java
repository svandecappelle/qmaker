package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;

/**
 * @author svandecappelle
 * @version 0.2.2
 * @since 0.2.2
 */
public class NotLikeExpression extends Expression {

    private static final long serialVersionUID = 8488561053963973660L;

    /**
     * Create a not like expression filter.
     * 
     * @param expression
     *            like expression filter on value.
     */
    public NotLikeExpression(String expression) {
        super(ExpressionType.NOT_LIKE, expression);
    }

    /**
     * Create a not like expression filter.
     * 
     * @param field
     *            like expression filter on value.
     */
    public NotLikeExpression(Field field) {
        super(ExpressionType.NOT_LIKE, field.toString());
    }

}