package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;

public class ExistsExpression extends Expression {
    private static final long serialVersionUID = -1175879517163641632L;

    /**
     * Create an exists expression filter.
     * 
     * @param expression
     *            exists expression filter on value.
     */
    public ExistsExpression(String expression) {
        super(ExpressionType.EXISTS, expression, true);
    }

    /**
     * Create an exists expression filter.
     * 
     * @param field
     *            exists expression filter on value.
     */
    public ExistsExpression(Field field) {
        super(ExpressionType.EXISTS, field.toString(), true);
    }

}
