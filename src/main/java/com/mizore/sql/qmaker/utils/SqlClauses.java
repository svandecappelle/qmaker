package com.mizore.sql.qmaker.utils;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        SQL String values replacement.
 */
public enum SqlClauses {
    SELECT("SELECT"), FROM("FROM"), AS("AS"), ON("ON"), JOIN("JOIN"), WHERE("WHERE"), GROUP_BY("GROUP BY"), ORDER_BY("ORDER BY");

    private String sqlClause;

    /**
     * SQL Clauses constants.
     * 
     * @param sqlClause
     *            SQL replacement clause constant string.
     */
    private SqlClauses(String sqlClause) {
        this.sqlClause = sqlClause;
    }

    @Override
    public String toString() {
        return sqlClause;
    }

}
