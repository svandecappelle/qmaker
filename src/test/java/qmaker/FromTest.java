package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Query;

public class FromTest {

    @Test
    public void simpleTest() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1", q.asString());
    }

    @Test
    public void aliasTest() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1");
        q.as("ALIAS_QUERY");
        Assert.assertEquals("(SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1) ALIAS_QUERY", q.asString());
    }

    @Test
    public void aliasFromTest() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").as("ALIAS_QUERY");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM (TABLE_1) ALIAS_QUERY", q.asString());
    }
}
