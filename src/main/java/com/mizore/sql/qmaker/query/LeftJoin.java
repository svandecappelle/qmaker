package com.mizore.sql.qmaker.query;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Left SQL Join.
 */
public class LeftJoin extends Join {

    /**
     * Construct a Left-join clause.
     * 
     * @param table
     *            the table on which left join references.
     * @param fromClause
     *            from src clause.
     */
    public LeftJoin(String table, From fromClause) {
        super(table, fromClause);
    }

    @Override
    public JoinType getType() {
        return JoinType.LEFT;
    }

}
