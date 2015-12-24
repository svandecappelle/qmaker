package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Query;

public class JoinTest {

    @Test
    public void simpleJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").innerJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 INNER JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID", q.toString());
    }

    @Test
    public void simpleMultipleOnJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").innerJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID").on("TABLE_1.ID2").equalsTo("TABLE_2.TABLE_2_ID2");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 INNER JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID AND TABLE_1.ID2 = TABLE_2.TABLE_2_ID2", q.toString());
    }

    @Test
    public void multipleJoinWithAlias() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").as("JOIN_ALIAS_1").innerJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID").innerJoin("TABLE_3").on("TABLE_1.ID").equalsTo("TABLE_3.TABLE_3_ID");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM (TABLE_1) JOIN_ALIAS_1 INNER JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID INNER JOIN TABLE_3 ON TABLE_1.ID = TABLE_3.TABLE_3_ID", q.toString());
    }

    @Test
    public void multipleJoinWithMultiplesAlias() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").as("JOIN_ALIAS_1").innerJoin("TABLE_2").as("JOIN_ALIAS_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID").innerJoin("TABLE_3").on("TABLE_1.ID").equalsTo("TABLE_3.TABLE_3_ID");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM (TABLE_1) JOIN_ALIAS_1 INNER JOIN (TABLE_2) JOIN_ALIAS_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID INNER JOIN TABLE_3 ON TABLE_1.ID = TABLE_3.TABLE_3_ID", q.toString());
    }

    @Test
    public void multipleJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").innerJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID").innerJoin("TABLE_3").on("TABLE_1.ID").equalsTo("TABLE_3.TABLE_3_ID");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 INNER JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID INNER JOIN TABLE_3 ON TABLE_1.ID = TABLE_3.TABLE_3_ID", q.toString());
    }

    @Test
    public void multipleJoinSeparated() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").innerJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID");
        q.innerJoin("TABLE_3").on("TABLE_1.ID").equalsTo("TABLE_3.TABLE_3_ID");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 INNER JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID INNER JOIN TABLE_3 ON TABLE_1.ID = TABLE_3.TABLE_3_ID", q.toString());
    }

    @Test
    public void simpleLeftJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").leftJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 LEFT JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID", q.toString());
    }

    @Test
    public void simpleRightJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").rightJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 RIGHT JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID", q.toString());
    }

    @Test
    public void simpleInnerJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").innerJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 INNER JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID", q.toString());
    }
}
