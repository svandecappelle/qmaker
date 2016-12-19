package com.mizore.sql.qmaker.query.joins;

import com.mizore.sql.qmaker.query.From;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Left SQL Join.
 */
public class LeftJoin extends Join {

    private static final long serialVersionUID = -521689995910275963L;

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
