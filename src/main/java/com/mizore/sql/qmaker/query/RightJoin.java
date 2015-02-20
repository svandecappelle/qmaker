package com.mizore.sql.qmaker.query;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Right SQL Join.
 */
public class RightJoin extends Join {

    /**
     * Construct a Right-join clause.
     * 
     * @param table
     *            the table on which right join references.
     */
    public RightJoin(String table) {
        super(table);
    }

    @Override
    public JoinType getType() {
        return JoinType.RIGHT;
    }

}
