package com.mizore.sql.qmaker.joins;

import com.mizore.sql.qmaker.query.Join;

public class RightJoin extends Join {

    public RightJoin(String table) {
        super(table);
    }

    @Override
    public JoinType getType() {
        return JoinType.RIGHT;
    }

}
