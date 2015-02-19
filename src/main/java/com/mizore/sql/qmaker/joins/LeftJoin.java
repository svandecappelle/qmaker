package com.mizore.sql.qmaker.joins;

public class LeftJoin extends Join {

	public LeftJoin(String table) {
		super(table);
	}

	@Override
	public JoinType getType() {
		return JoinType.LEFT;
	}

}
