package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Query;
import com.mizore.sql.qmaker.query.Union;

public class UnionTest {

    @Test
    public void simpleUnion() {

        // Query 1
        Query q1 = new Query();
        q1.select("TABLE_1", "FIELD");
        q1.from("TABLE_1");
        q1.where("TABLE_1", "FIELD").equalsTo("1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1", q1.asString());

        // Query 2
        Query q2 = new Query();
        q2.select("TABLE_1", "FIELD");
        q2.from("TABLE_1");
        q2.where("TABLE_1", "FIELD").equalsTo("1").and("1").equalsTo("2");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1 AND 1 = 2", q2.asString());

        // The union of Query 1 and Query 2
        Union union = new Union(q1, q2);

        Assert.assertEquals(union.toString(), q1 + " UNION " + q2);
    }
    
    @Test
    public void multiplesUnion() {

        // Query 1
        Query q1 = new Query();
        q1.select("TABLE_1", "FIELD");
        q1.from("TABLE_1");
        q1.where("TABLE_1", "FIELD").equalsTo("1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1", q1.asString());

        // Query 2
        Query q2 = new Query();
        q2.select("TABLE_1", "FIELD");
        q2.from("TABLE_1");
        q2.where("TABLE_1", "FIELD").equalsTo("1").and("1").equalsTo("2");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1 AND 1 = 2", q2.asString());

        // The union of Query 1 and Query 2
        Union union = new Union(q1, q2);
        union.union(q1);

        Assert.assertEquals(union.toString(), q1 + " UNION " + q2 + " UNION " + q1);
    }
    
    @Test
    public void multiplesUnionAll() {

        // Query 1
        Query q1 = new Query();
        q1.select("TABLE_1", "FIELD");
        q1.from("TABLE_1");
        q1.where("TABLE_1", "FIELD").equalsTo("1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1", q1.asString());

        // Query 2
        Query q2 = new Query();
        q2.select("TABLE_1", "FIELD");
        q2.from("TABLE_1");
        q2.where("TABLE_1", "FIELD").equalsTo("1").and("1").equalsTo("2");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1 AND 1 = 2", q2.asString());

        // The union of Query 1 and Query 2
        Union union = new Union(q1, q2, true);
        union.unionAll(q1);

        Assert.assertEquals(union.toString(), q1 + " UNION ALL " + q2 + " UNION ALL " + q1);
    }
    
    @Test
    public void multiplesUnionMixedAll() {

        // Query 1
        Query q1 = new Query();
        q1.select("TABLE_1", "FIELD");
        q1.from("TABLE_1");
        q1.where("TABLE_1", "FIELD").equalsTo("1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1", q1.asString());

        // Query 2
        Query q2 = new Query();
        q2.select("TABLE_1", "FIELD");
        q2.from("TABLE_1");
        q2.where("TABLE_1", "FIELD").equalsTo("1").and("1").equalsTo("2");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1 AND 1 = 2", q2.asString());

        // The union of Query 1 and Query 2
        Union union = new Union(q1, q2);
        union.unionAll(q1);

        Assert.assertEquals(union.toString(), q1 + " UNION " + q2 + " UNION ALL " + q1);
    }
}
