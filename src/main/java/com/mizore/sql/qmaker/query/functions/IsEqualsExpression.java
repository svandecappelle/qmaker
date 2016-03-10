package com.mizore.sql.qmaker.query.functions;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.query.Field;

/**
 * @author svandecappelle
 *
 * @since 0.0.6
 *
 *        An SQL Equals expression. example: X IS Y.
 */
public class IsEqualsExpression extends Expression {

    private static final long serialVersionUID = 7327741741934583296L;

    /**
     * Create an equals expression filter.
     * 
     * @param expression
     *            equals expression filter on value.
     */
    public IsEqualsExpression(String expression) {
        super(ExpressionType.IS, expression);
    }

    /**
     * Create an equals expression filter.
     * 
     * @param field
     *            equals expression filter on value.
     */
    public IsEqualsExpression(Field field) {
        super(ExpressionType.IS, field.toString());
    }

}
