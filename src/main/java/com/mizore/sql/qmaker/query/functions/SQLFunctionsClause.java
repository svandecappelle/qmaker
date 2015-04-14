package com.mizore.sql.qmaker.query.functions;

/**
 * @author svandecappelle
 *
 * @since SQL functions clauses.
 */
public enum SQLFunctionsClause {
    MIN("MIN"),
    MAX("MAX"),
    AVG("AVG"),
    COALESCE("COALESCE");

    private String sqlClause;

    /**
     * SQL Clauses constants.
     * 
     * @param sqlClause
     *            SQL replacement clause constant string.
     */
    private SQLFunctionsClause(String sqlClause) {
        this.sqlClause = sqlClause;
    }

    @Override
    public String toString() {
        return sqlClause;
    }
}