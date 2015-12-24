package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Query;

public class OrderByTest {

    @Test
    public void simpleOrderBy() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.orderBy("TABLE_1", "FIELD").asc();
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 ORDER BY TABLE_1.FIELD ASC", q.asString());
    }
    
    @Test
    public void simpleFieldsTablesOrderBy() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.orderBy("FIELD").asc();
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 ORDER BY FIELD ASC", q.asString());
    }

    @Test
    public void multipleOrderBy() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.select("TABLE_1", "FIELD2");
        q.from("TABLE_1");
        q.orderBy("FIELD").asc();
        q.orderBy("FIELD2").desc();
        Assert.assertEquals("SELECT TABLE_1.FIELD, TABLE_1.FIELD2 FROM TABLE_1 ORDER BY FIELD ASC, FIELD2 DESC", q.asString());
    }
}
