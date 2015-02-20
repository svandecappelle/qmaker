package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.utils.SqlStringConstants;

public class Field {

    private Table table;
    private String fieldName;
    private As as;

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    public Field(Table table, String fieldName) {
        this.setTable(table, fieldName);
    }

    public As as(String alias) {
        if (as == null) {
            this.as = new As(alias);
        }
        return this.as;
    }

    public void setTable(Table table, String field) {
        this.table = table;
        this.fieldName = field;
    }

    public String getName() {
        return this.fieldName;
    }

    public Table getTable() {
        return table;
    }

    public As getAlias() {
        return as;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (table != null) {
            builder.append(table.toString());
            builder.append(SqlStringConstants.DOT_SEPARATOR);
        }

        builder.append(getName());

        if (getAlias() != null) {
            builder.append(SqlStringConstants.EMPTY_SEPARATOR);
            builder.append(SqlStringConstants.AS);
            builder.append(SqlStringConstants.EMPTY_SEPARATOR);
            builder.append(getAlias().getName());
        }

        return builder.toString();
    }
}
