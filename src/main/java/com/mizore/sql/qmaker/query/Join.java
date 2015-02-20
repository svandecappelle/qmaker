package com.mizore.sql.qmaker.query;

import java.util.ArrayList;
import java.util.List;

import com.mizore.sql.qmaker.filters.expressions.EqualsExpression;
import com.mizore.sql.qmaker.filters.expressions.Expression;
import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        SQL Join abstract. Need to make inner/left/outer/right SQL join.
 */
public abstract class Join {

    // Table on which join target.
    private Table table;

    // 'On' field SQL restriction join.
    private Field on;

    // Expression filters.
    private List<Expression> expressionsJoinFilters;

    /**
     * Constructor. Join SQL on a table.
     * 
     * @param tableName
     *            table name.
     */
    public Join(String tableName) {
        this.table = new Table(tableName);
        this.expressionsJoinFilters = new ArrayList<Expression>();
    }

    /**
     * Add join 'On' SQL restriction.
     * 
     * @param fieldName
     *            the field 'on' restriction.
     * @return The join clause.
     */
    public Join on(String fieldName) {
        this.on = new Field(fieldName);
        return this;
    }

    /**
     * Add a Equals to clause.
     * 
     * @param the
     *            expression right side.
     */
    public void equalsTo(String expression) {
        expressionsJoinFilters.add(new EqualsExpression(expression));
    }

    /**
     * Get the SQL Join type.
     * 
     * @return the join type.
     */
    public abstract JoinType getType();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(SeparatorType.EMPTY);
        builder.append(getType().name());
        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.JOIN);
        builder.append(SeparatorType.EMPTY);
        builder.append(table.toString());

        if (on != null) {
            builder.append(SeparatorType.EMPTY);
            builder.append(SqlClauses.ON);
            builder.append(SeparatorType.EMPTY);
            builder.append(on);
        }

        for (Expression expression : expressionsJoinFilters) {
            builder.append(SeparatorType.EMPTY);
            builder.append(expression);
        }

        return builder.toString();
    }

}
