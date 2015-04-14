package com.mizore.sql.qmaker.query;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Sql Inner join.
 */
public class InnerJoin extends Join {

    private static final long serialVersionUID = 3341346686857707382L;

    /**
     * Create a join.
     * 
     * @param table
     *            table on which join is referenced.
     * @param fromClause
     *            source from clause.
     */
    public InnerJoin(String table, From fromClause) {
        super(table, fromClause);
    }

    @Override
    public JoinType getType() {
        return JoinType.INNER;
    }

}
