package qmaker;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.Query;

public class JoinTest {

	private final Logger logger = Logger.getLogger("SimpleJoin");

	@Test
	public void simpleJoin() {
		Query q = new Query();
		q.select("TABLE_1", "FIELD").as("ALIAS_1");
		q.from("TABLE_1").innerJoin("TABLE_2");
		logger.info(q.asString());
		Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 INNER JOIN TABLE_2", q.asString());
	}
}
