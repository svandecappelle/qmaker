package com.mizore.sql.qmaker.filters.expressions;

import com.mizore.sql.qmaker.joins.Join;
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

    private ExpressionType expressionType;
    private String expression;

    public Expression(ExpressionType type, String expression) {
        this.expressionType = type;
        this.expression = expression;
    }

    public ExpressionType getExpressionType() {
        return expressionType;
    }

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
