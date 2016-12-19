package com.mizore.sql.qmaker.filters;

import java.io.Serializable;

import com.mizore.sql.qmaker.query.joins.Join;
import com.mizore.sql.qmaker.utils.SeparatorType;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        SQL expression filter. Used in {@link Join} or {@link Where}
 *        restrictions.
 */
public abstract class Expression implements Serializable {

    private static final long serialVersionUID = 8639220667038005728L;

    // Expression filter type.
    private ExpressionType expressionType;

    // Expression.
    private String sqlExpression;

    private boolean isQueryExpression;

    /**
     * Construct expression.
     * 
     * @param type
     *            type of expression.
     * @param expression
     *            expression string filter.
     */
    public Expression(ExpressionType type, String sqlExpressionOne, String sqlExpressionTwo) {
        this.expressionType = type;
        StringBuilder expressionAnd = new StringBuilder();
        expressionAnd.append(sqlExpressionOne);
        expressionAnd.append(SeparatorType.EMPTY);
        expressionAnd.append(SeparatorType.AND);
        expressionAnd.append(SeparatorType.EMPTY);
        expressionAnd.append(sqlExpressionTwo);
        this.sqlExpression = expressionAnd.toString();
    }

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

    public Expression(ExpressionType type, String expression, boolean isQueryExpression) {
        this(type, expression);
        this.isQueryExpression = isQueryExpression;
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

        if (isQueryExpression) {
            builder.append(SeparatorType.LEFT_PARENTHESIS);
        }
        
        builder.append(getSqlExpression());
        
        if (isQueryExpression) {
            builder.append(SeparatorType.RIGHT_PARENTHESIS);
        }
        return builder.toString();
    }
}
