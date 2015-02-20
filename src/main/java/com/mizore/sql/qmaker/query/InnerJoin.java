package com.mizore.sql.qmaker.query;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Sql Inner join.
 */
public class InnerJoin extends Join {

    /**
     * Create a join.
     * 
     * @param table
     */
    public InnerJoin(String table) {
        super(table);
    }

    @Override
    public JoinType getType() {
        return JoinType.INNER;
    }

}
