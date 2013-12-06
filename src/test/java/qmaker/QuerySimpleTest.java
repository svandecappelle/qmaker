package qmaker;

public class QuerySimpleTest {
	public QuerySimpleTest() {

	}

	public static void main(String[] args) {
		Query q = new Query();
		q.select("TOTO_TABLE", "TOTO").as().setName("ASFIELD");
		System.out.println(q.toString());
	}
}
