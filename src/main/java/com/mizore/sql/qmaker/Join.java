package com.mizore.sql.qmaker;

public class Join {

	private String table;

	public Join(String table) {
		this.table = table;
	}

	@Override
	public String toString() {
		return table;
	}
}
