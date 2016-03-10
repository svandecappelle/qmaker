package com.mizore.sql.qmaker.filters;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        SQL filter expression type enumerate.
 */
public enum ExpressionType {
    EQUALS("="),
    GREATER(">"),
    LOWER("<"),
    DIFFERENT("<>"),
    LIKE("LIKE"),
    BETWEEN("BETWEEN"),
    EXISTS("EXISTS"),
    NOT_EXISTS("NOT EXISTS"),
    IN("IN"),
    NOT_IN("NOT IN"),
    IS("IS");

    private String sql;

    /**
     * Constructor enumeration sql.
     * 
     * @param sql
     *            SQL replacement.
     */
    private ExpressionType(String sql) {
        this.sql = sql;
    }

    /**
     * Get the sql replacement of expression type.
     * 
     * @return the SQL value.
     */
    public String toSql() {
        return sql;
    }
}
