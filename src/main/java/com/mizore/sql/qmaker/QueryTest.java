package com.mizore.sql.qmaker;

public class QueryTest {

	public static void main(String[] args) {
		System.out.println("Try");
		Query q = new Query();
		q.select("TOTO_TABLE", "TOTO").as().setName("ASFIELD");
		q.select("TUTU_TABLE", "HAHA");
		System.out.println(q.asString());
	}
}
