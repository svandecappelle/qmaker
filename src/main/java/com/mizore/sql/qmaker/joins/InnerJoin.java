package com.mizore.sql.qmaker.joins;

import com.mizore.sql.qmaker.query.Join;

public class InnerJoin extends Join {

    public InnerJoin(String table) {
        super(table);
    }

    @Override
    public JoinType getType() {
        return JoinType.INNER;
    }

}
