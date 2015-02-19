package com.mizore.sql.qmaker.joins;

import com.mizore.sql.qmaker.DataBaseConstants;

public abstract class Join {

	private String table;

	private String on;

	public Join(String table) {
		this.table = table;
	}

	@Override
	public String toString() {
		return DataBaseConstants.EMPTY_SEPARATOR.concat(getType().name()).concat(DataBaseConstants.EMPTY_SEPARATOR).concat(DataBaseConstants.JOIN).concat(DataBaseConstants.EMPTY_SEPARATOR).concat(table);
	}

	public abstract JoinType getType();
}
