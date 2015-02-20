package com.mizore.sql.qmaker.filters.expressions;

public class EqualsExpression extends Expression {

	public EqualsExpression(String expression) {
		super(ExpressionType.EQUALS, expression);
	}

}
