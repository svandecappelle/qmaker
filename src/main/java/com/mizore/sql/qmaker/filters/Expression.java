package com.mizore.sql.qmaker.filters;

import com.mizore.sql.qmaker.query.Join;
import com.mizore.sql.qmaker.utils.SeparatorType;

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
    private String sqlExpression;

    /**
     * Construct expression.
     * 
     * @param type
     *            type of expression.
     * @param expression
     *            expression string filter.
     */
    public Expression(ExpressionType type, String sqlExpression) {
        this.expressionType = type;
        this.sqlExpression = sqlExpression;
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
    public String getSqlExpression() {
        return sqlExpression;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getExpressionType().toSql());
        builder.append(SeparatorType.EMPTY);
        builder.append(getSqlExpression());
        return builder.toString();
    }
}
