package com.mizore.sql.qmaker.filters.expressions;

public enum ExpressionType {
    EQUALS("="), GREATER(">"), LOWER("<"), DIFFERENT("<>"), LIKE("LIKE");

    private String sql;

    private ExpressionType(String sql) {
        this.sql = sql;
    }

    public String toSql() {
        return sql;
    }
}
