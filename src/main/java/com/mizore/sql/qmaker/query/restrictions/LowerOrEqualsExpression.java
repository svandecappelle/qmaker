package com.mizore.sql.qmaker.query.restrictions;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.query.Field;

public class LowerOrEqualsExpression extends Expression {

    private static final long serialVersionUID = -6329716691169341710L;

    /**
     * Create a lower expression filter.
     * 
     * @param expression
     *            lower expression filter on value.
     */
    public LowerOrEqualsExpression(String expression) {
        super(ExpressionType.LOWER_OR_EQUALS, expression);
    }

    /**
     * Create a lower expression filter.
     * 
     * @param field
     *            lower expression filter on value.
     */
    public LowerOrEqualsExpression(Field field) {
        super(ExpressionType.LOWER_OR_EQUALS, field.toString());
    }
}
