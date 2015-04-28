package com.mizore.sql.qmaker.query;

public class OuterJoin extends Join {

    private static final long serialVersionUID = -983660373154312777L;

    /**
     * Construct a Outer-join clause.
     * 
     * @param table
     *            the table on which right join references.
     * @param fromClause
     *            from src clause.
     */
    public OuterJoin(String table, From fromClause) {
        super(table, fromClause);
    }

    @Override
    public JoinType getType() {
        return JoinType.OUTER;
    }

}
