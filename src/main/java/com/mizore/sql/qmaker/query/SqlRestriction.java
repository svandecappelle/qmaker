package com.mizore.sql.qmaker.query;

import java.io.Serializable;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.utils.SeparatorType;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        SQl restriction where clause.
 */
public class SqlRestriction<T extends IsClause> implements Serializable {

    private static final long serialVersionUID = 7493388191128046830L;

    private Field field;

    private Expression expressionFilter;

    private T query;

    /**
     * Create an sql restriction where clause.
     * 
     * @param field
     *            field on which restriction is about.
     * @param query
     *            the original query which restriction is injected.
     */
    public SqlRestriction(Field field, T query) {
        this.field = field;
        this.query = query;
    }

    /**
     * Set equals SQL restriction value.
     * 
     * @param expression
     *            the expression to filter
     * @return the expression tested on SQL.
     */
    public <O> T equalsTo(O expression) {
        return this.setExpression(ExpressionType.EQUALS, expression);
    }

    /**
     * Set equals SQL restriction value.
     * 
     * @param table
     *            table name.
     * @param field
     *            field name.
     * @return the expression tested on SQL.
     */
    public T equalsTo(String table, String field) {
        return this.setExpression(ExpressionType.EQUALS, table, field);
    }

    /**
     * Set equals SQL restriction value.
     * 
     * @param schema
     *            schema name.
     * @param table
     *            table name.
     * @param field
     *            fieldname.
     * @return the expression tested on SQL.
     */
    public T equalsTo(String schema, String table, String field) {
        return this.setExpression(ExpressionType.EQUALS, schema, table, field);
    }

    // not
    /**
     * Set not equals SQL restriction value.
     * 
     * @param expression
     *            the expression to filter
     * @return the expression tested on SQL.
     */
    public <O> T notEqualsTo(O expression) {
        return this.setExpression(ExpressionType.DIFFERENT, expression);
    }

    /**
     * Set not equals SQL restriction value.
     * 
     * @param table
     *            table name.
     * @param field
     *            field name.
     * @return the expression tested on SQL.
     */
    public T notEqualsTo(String table, String field) {
        return this.setExpression(ExpressionType.DIFFERENT, table, field);
    }

    /**
     * Set not equals SQL restriction value.
     * 
     * @param schema
     *            schema name.
     * @param table
     *            table name.
     * @param field
     *            fieldname.
     * @return the expression tested on SQL.
     */
    public T notEqualsTo(String schema, String table, String field) {
        return this.setExpression(ExpressionType.DIFFERENT, schema, table, field);
    }

    // Exists
    /**
     * Set exists SQL restriction value.
     * 
     * @param expression
     *            the expression to filter
     * @return the expression tested on SQL.
     */
    public <O> T exists(O expression) {
        return this.setExpression(ExpressionType.EXISTS, expression);
    }

    /**
     * Set exists SQL restriction value.
     * 
     * @param table
     *            table name.
     * @param field
     *            field name.
     * @return the expression tested on SQL.
     */
    public T exists(String table, String field) {
        return this.setExpression(ExpressionType.EXISTS, table, field);
    }

    /**
     * Set exists SQL restriction value.
     * 
     * @param schema
     *            schema name.
     * @param table
     *            table name.
     * @param field
     *            fieldname.
     * @return the expression tested on SQL.
     */
    public T exists(String schema, String table, String field) {
        return this.setExpression(ExpressionType.EXISTS, schema, table, field);
    }

    // IN

    /**
     * Set in SQL restriction value.
     * 
     * @param expression
     *            the expression to filter
     * @return the expression tested on SQL.
     */
    public <O> T in(O expression) {
        return this.setExpression(ExpressionType.IN, expression);
    }

    /**
     * Set in SQL restriction value.
     * 
     * @param table
     *            table name.
     * @param field
     *            field name.
     * @return the expression tested on SQL.
     */
    public T in(String table, String field) {
        return this.setExpression(ExpressionType.IN, table, field);
    }

    /**
     * Set in SQL restriction value.
     * 
     * @param schema
     *            schema name.
     * @param table
     *            table name.
     * @param field
     *            fieldname.
     * @return the expression tested on SQL.
     */
    public T in(String schema, String table, String field) {
        return this.setExpression(ExpressionType.IN, schema, table, field);
    }

    // NOT IN

    /**
     * Set notIn SQL restriction value.
     * 
     * @param expression
     *            the expression to filter
     * @return the expression tested on SQL.
     */
    public <O> T notIn(O expression) {
        return this.setExpression(ExpressionType.NOT_IN, expression);
    }

    /**
     * Set notIn SQL restriction value.
     * 
     * @param table
     *            table name.
     * @param field
     *            field name.
     * @return the expression tested on SQL.
     */
    public T notIn(String table, String field) {
        return this.setExpression(ExpressionType.NOT_IN, table, field);
    }

    /**
     * Set notIn SQL restriction value.
     * 
     * @param schema
     *            schema name.
     * @param table
     *            table name.
     * @param field
     *            fieldname.
     * @return the expression tested on SQL.
     */
    public T notIn(String schema, String table, String field) {
        return this.setExpression(ExpressionType.NOT_IN, schema, table, field);
    }

    // Not exists

    /**
     * Set not exists SQL restriction value.
     * 
     * @param expression
     *            the expression to filter
     * @return the expression tested on SQL.
     */
    public <O> T notExists(O expression) {
        return this.setExpression(ExpressionType.NOT_EXISTS, expression);
    }

    /**
     * Set not exists SQL restriction value.
     * 
     * @param table
     *            table name.
     * @param field
     *            field name.
     * @return the expression tested on SQL.
     */
    public T notExists(String table, String field) {
        return this.setExpression(ExpressionType.NOT_EXISTS, table, field);
    }

    /**
     * Set not exists SQL restriction value.
     * 
     * @param schema
     *            schema name.
     * @param table
     *            table name.
     * @param field
     *            fieldname.
     * @return the expression tested on SQL.
     */
    public T notExists(String schema, String table, String field) {
        return this.setExpression(ExpressionType.NOT_EXISTS, schema, table, field);
    }

    /**
     * Set not equals SQL restriction value.
     * 
     * @param expression
     *            the expression to filter
     * @return the expression tested on SQL.
     */
    public <O> T setExpression(ExpressionType type, O expression) {
        expressionFilter = getExpression(type, expression);
        return query;
    }

    /**
     * Get the typed expression.
     * 
     * @param type
     *            type of expression.
     * @param expression
     *            the expression SQL.
     * @return the Expression Query.
     */
    private <O> Expression getExpression(ExpressionType type, O expression) {
        Expression exp = null;

        switch (type) {
        case EQUALS:
            exp = new EqualsExpression(expression.toString());
            break;
        case DIFFERENT:
            exp = new NotEqualsExpression(expression.toString());
            break;
        case LOWER:
            exp = new LowerExpression(expression.toString());
            break;
        case EXISTS:
            exp = new ExistsExpression(expression.toString());
            break;
        case NOT_EXISTS:
            exp = new NotExistsExpression(expression.toString());
            break;
        case LIKE:
            exp = new LikeExpression(expression.toString());
            break;
        case GREATER:
            exp = new GreaterExpression(expression.toString());
            break;
        case IN:
            exp = new InExpression(expression.toString());
            break;
        case NOT_IN:
            exp = new NotInExpression(expression.toString());
            break;
        default:
            new RuntimeException("get expression with single value doesn't allow type of between");
            break;
        }

        return exp;
    }

    /**
     * Get the typed expression.
     * 
     * @param type
     *            type of expression.
     * @param expression
     *            the expression SQL.
     * @return the Expression Query.
     */
    private <O> Expression getExpression(ExpressionType type, O[] expression) {
        Expression exp = null;
        switch (type) {
        case BETWEEN:
            exp = new BetweenExpression(expression[0].toString(), expression[1].toString());
            break;
        default:
            new RuntimeException("get expression with multiples values doesn't allow other fields type that between");
            break;
        }
        return exp;
    }

    /**
     * Set parametrized SQL restriction value.
     * 
     * @param table
     *            table name.
     * @param field
     *            field name.
     * @return the expression tested on SQL.
     */
    public T setExpression(ExpressionType type, String table, String field) {
        return this.setExpression(type, new Field(new Table(table), field));
    }

    /**
     * Set parametrized SQL restriction value.
     * 
     * @param schema
     *            schema name.
     * @param table
     *            table name.
     * @param field
     *            fieldname.
     * @return the expression tested on SQL.
     */
    public T setExpression(ExpressionType type, String schema, String table, String field) {
        return this.setExpression(type, new Field(new Table(schema, table), field));
    }

    /**
     * @return
     */
    public Field getField() {
        return field;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (field != null) {
            builder.append(field);
            builder.append(SeparatorType.EMPTY);
        }

        builder.append(expressionFilter);

        return builder.toString();

    }

    /**
     * Add a between clause restriction
     * 
     * @param from
     * @param to
     */
    public T beetween(String from, String to) {
        String[] fromTo = new String[2];
        fromTo[0] = from;
        fromTo[1] = to;
        expressionFilter = this.getExpression(ExpressionType.BETWEEN, fromTo);
        return this.query;
    }
}
