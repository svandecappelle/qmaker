package com.mizore.sql.qmaker.query;

public enum SQLFieldClause {
    MIN("MIN"), MAX("MAX"), AVG("AVG"), COALESCE("COALESCE");

    private String sqlClause;

    /**
     * SQL Clauses constants.
     * 
     * @param sqlClause
     *            SQL replacement clause constant string.
     */
    private SQLFieldClause(String sqlClause) {
        this.sqlClause = sqlClause;
    }

    @Override
    public String toString() {
        return sqlClause;
    }
}