package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Query;
import com.mizore.sql.qmaker.query.functions.Avg;
import com.mizore.sql.qmaker.query.functions.Coalesce;

public class GroupByTest {

    @Test
    public void simpleGroupBy() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.select("TABLE_1", "FIELD_2").as("ALIAS_2");

        q.from("TABLE_1").groupBy("ALIAS_1");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1, TABLE_1.FIELD_2 AS ALIAS_2 FROM TABLE_1 GROUP BY ALIAS_1", q.toString());
    }

    @Test
    public void simpleFieldsGroupBy() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.select("TABLE_1", "FIELD_2").as("ALIAS_2");

        q.from("TABLE_1").groupBy("TABLE_1", "ALIAS_1");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1, TABLE_1.FIELD_2 AS ALIAS_2 FROM TABLE_1 GROUP BY TABLE_1.ALIAS_1", q.toString());
    }

    @Test
    public void multiplesGroupBy() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.select("TABLE_1", "FIELD_2").as("ALIAS_2");

        q.from("TABLE_1").groupBy("TABLE_1", "ALIAS_1");
        q.groupBy("TABLE_1", "ALIAS_2");
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1, TABLE_1.FIELD_2 AS ALIAS_2 FROM TABLE_1 GROUP BY TABLE_1.ALIAS_1, TABLE_1.ALIAS_2", q.toString());
    }

    @Test
    public void fieldModifier() {
        Query q = new Query();
        q.select(new Avg("TABLE_1", "FIELD")).as("ALIAS_1");
        q.select("TABLE_1", "FIELD_2").as("ALIAS_2");

        q.from("TABLE_1");
        q.groupBy("TABLE_1", "ALIAS_2");
        Assert.assertEquals("SELECT AVG(TABLE_1.FIELD) AS ALIAS_1, TABLE_1.FIELD_2 AS ALIAS_2 FROM TABLE_1 GROUP BY TABLE_1.ALIAS_2", q.toString());
    }

    @Test
    public void complexModifier() {
        Query q = new Query();
        q.select(new Coalesce(new Avg("TABLE_1", "FIELD"))).as("ALIAS_1");
        q.select("TABLE_1", "FIELD_2").as("ALIAS_2");

        q.from("TABLE_1");
        q.groupBy("TABLE_1", "ALIAS_2");
        Assert.assertEquals("SELECT COALESCE(AVG(TABLE_1.FIELD)) AS ALIAS_1, TABLE_1.FIELD_2 AS ALIAS_2 FROM TABLE_1 GROUP BY TABLE_1.ALIAS_2", q.toString());
    }
}
