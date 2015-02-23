package qmaker;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Query;

public class QuerySimpleTest {

	private final Logger logger = Logger.getLogger("QuerySimpleTest");

	@Test
	public void simpleFullSelect() {
		Query q = new Query();
		q.select("TABLE_1", "FIELD").as("ALIAS_1");
		q.from("TABLE_1");
		logger.info(q.asString());
		Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1", q.asString());
	}
	
	@Test
    public void simpleFullWithSchemaSelect() {
        Query q = new Query();
        q.select("SCHEMA", "TABLE_1", "FIELD").as("ALIAS_1");
        q.from("SCHEMA", "TABLE_1");
        logger.info(q.asString());
        Assert.assertEquals("SELECT SCHEMA.TABLE_1.FIELD AS ALIAS_1 FROM SCHEMA.TABLE_1", q.asString());
    }

	@Test
	public void simpleSelect() {
		Query q = new Query();
		q.select("TABLE_1", "FIELD");
		q.from("TABLE_1");
		logger.info(q.asString());
		Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1", q.asString());
	}

	@Test
	public void simpleSelectMultipleFields() {
		Query q = new Query();
		q.select("TABLE_1", "FIELD");
		q.select("TABLE_1", "FIELD_2");
		q.from("TABLE_1");
		logger.info(q.asString());
		Assert.assertEquals("SELECT TABLE_1.FIELD, TABLE_1.FIELD_2 FROM TABLE_1", q.asString());
	}

	@Test
	public void simpleSelectMultipleFieldsAlias() {
		Query q = new Query();
		q.select("TABLE_1", "FIELD").as("ALIAS_1");
		q.select("TABLE_1", "FIELD_2").as("ALIAS_2");
		q.from("TABLE_1");
		logger.info(q.asString());
		Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1, TABLE_1.FIELD_2 AS ALIAS_2 FROM TABLE_1", q.asString());
	}

}
