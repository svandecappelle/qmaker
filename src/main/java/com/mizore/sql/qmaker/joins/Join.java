package com.mizore.sql.qmaker.joins;

import java.util.ArrayList;
import java.util.List;

import com.mizore.sql.qmaker.DataBaseConstants;
import com.mizore.sql.qmaker.Field;
import com.mizore.sql.qmaker.Table;
import com.mizore.sql.qmaker.filters.expressions.EqualsExpression;
import com.mizore.sql.qmaker.filters.expressions.Expression;

public abstract class Join {

    private Table table;
    private Field on;
    private List<Expression> expressionsJoinFilters;

    public Join(String tableName) {
        this.table = new Table(tableName);
        this.expressionsJoinFilters = new ArrayList<Expression>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(DataBaseConstants.EMPTY_SEPARATOR);
        builder.append(getType().name());
        builder.append(DataBaseConstants.EMPTY_SEPARATOR);
        builder.append(DataBaseConstants.JOIN);
        builder.append(DataBaseConstants.EMPTY_SEPARATOR);
        builder.append(table.toString());

        if (on != null) {
            builder.append(DataBaseConstants.EMPTY_SEPARATOR);
            builder.append(DataBaseConstants.ON);
            builder.append(DataBaseConstants.EMPTY_SEPARATOR);
            builder.append(on);
        }

        for (Expression expression : expressionsJoinFilters) {
            builder.append(DataBaseConstants.EMPTY_SEPARATOR);
            builder.append(expression);
        }

        return builder.toString();
    }

    public abstract JoinType getType();

    public Join on(String fieldName) {
        this.on = new Field(fieldName);
        return this;
    }

    public void equalsTo(String expression) {
        expressionsJoinFilters.add(new EqualsExpression(expression));
    }
}
