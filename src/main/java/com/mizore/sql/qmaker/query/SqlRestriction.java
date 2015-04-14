package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.utils.SeparatorType;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        SQl restriction where clause.
 */
public class SqlRestriction<T extends IsClause> {

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
    public T equalsTo(String expression) {
        expressionFilter = new EqualsExpression(expression);
        return query;
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
        expressionFilter = new EqualsExpression(new Field(new Table(table), field));
        return query;
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
        expressionFilter = new EqualsExpression(new Field(new Table(schema, table), field));
        return query;
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

        builder.append(field);
        builder.append(SeparatorType.EMPTY);
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
        expressionFilter = new BetweenExpression(from, to);
        return query;
    }
}
