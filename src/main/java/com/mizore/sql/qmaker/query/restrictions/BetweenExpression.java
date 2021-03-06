package com.mizore.sql.qmaker.query.restrictions;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.query.Field;

/**
 * An SQL Between expression. example: X Between A AND B.
 * 
 * @author svandecappelle
 *
 */
public class BetweenExpression extends Expression {

    private static final long serialVersionUID = 2027642895005368932L;

    /**
     * Create a between expression filter.
     * 
     * @param expressionOne
     *            a between expression filter on first value.
     * @param expressionTwo
     *            a between expression filter on second value.
     */
    public BetweenExpression(String expressionOne, String expressionTwo) {
        super(ExpressionType.BETWEEN, expressionOne, expressionTwo);
    }

    /**
     * Create a between expression filter.
     * 
     * @param fieldOne
     *            a between expression filter on first value.
     * @param fieldTwo
     *            a between expression filter on second value.
     */
    public BetweenExpression(Field fieldOne, Field fieldTwo) {
        super(ExpressionType.BETWEEN, fieldOne.toString(), fieldTwo.toString());
    }

}
