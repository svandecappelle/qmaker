package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Query;

public class RestrictionTest {

    @Test
    public void simpleWhere() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where("TABLE_1", "FIELD").equalsTo("1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1", q.asString());
    }
    
    @Test
    public void multipleWhere() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where("TABLE_1", "FIELD").equalsTo("1").and("1").equalsTo("2");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1 AND 1 = 2", q.asString());
    }
}
