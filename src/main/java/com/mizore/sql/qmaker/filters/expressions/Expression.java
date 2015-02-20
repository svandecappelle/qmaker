package com.mizore.sql.qmaker.filters.expressions;

import com.mizore.sql.qmaker.query.Join;
import com.mizore.sql.qmaker.utils.SqlStringConstants;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        SQL expression filter. Used in {@link Join} or {@link Where}
 *        restrictions.
 */
public abstract class Expression {

    // Expression filter type.
    private ExpressionType expressionType;

    // Expression.
    private String expression;

    /**
     * Construct expression.
     * 
     * @param type
     *            type of expression.
     * @param expression
     *            expression string filter.
     */
    public Expression(ExpressionType type, String expression) {
        this.expressionType = type;
        this.expression = expression;
    }

    /**
     * Get the expression type.
     * 
     * @return the expression type.
     */
    public ExpressionType getExpressionType() {
        return expressionType;
    }

    /**
     * Get the expression filter.
     * 
     * @return the expression filter.
     */
    public String getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getExpressionType().toSql());
        builder.append(SqlStringConstants.EMPTY_SEPARATOR);
        builder.append(getExpression());
        return builder.toString();
    }
}
