package com.mizore.sql.qmaker.joins;

public class InnerJoin extends Join {

    public InnerJoin(String table) {
        super(table);
    }

    @Override
    public JoinType getType() {
        return JoinType.INNER;
    }

}
