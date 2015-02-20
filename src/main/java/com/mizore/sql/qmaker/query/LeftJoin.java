package com.mizore.sql.qmaker.query;


public class LeftJoin extends Join {

    public LeftJoin(String table) {
        super(table);
    }

    @Override
    public JoinType getType() {
        return JoinType.LEFT;
    }

}
