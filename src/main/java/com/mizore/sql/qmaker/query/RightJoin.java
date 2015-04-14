package com.mizore.sql.qmaker.query;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Right SQL Join.
 */
public class RightJoin extends Join {

    private static final long serialVersionUID = -1103180351303103129L;

    /**
     * Construct a Right-join clause.
     * 
     * @param table
     *            the table on which right join references.
     * @param fromClause
     *            from src clause.
     */
    public RightJoin(String table, From fromClause) {
        super(table, fromClause);
    }

    @Override
    public JoinType getType() {
        return JoinType.RIGHT;
    }

}
