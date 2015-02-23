package qmaker;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Query;

public class JoinTest {

    private final Logger logger = Logger.getLogger("SimpleJoin");

    @Test
    public void simpleJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").innerJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID");
        logger.info(q.toString());
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 INNER JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID", q);
    }

    @Test
    public void multipleJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").innerJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID").innerJoin("TABLE_3").on("TABLE_1.ID").equalsTo("TABLE_3.TABLE_3_ID");
        logger.info(q.toString());
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 INNER JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID INNER JOIN TABLE_3 ON TABLE_1.ID = TABLE_3.TABLE_3_ID", q);
    }

    @Test
    public void multipleJoinSeparated() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").innerJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID");
        q.innerJoin("TABLE_3").on("TABLE_1.ID").equalsTo("TABLE_3.TABLE_3_ID");
        logger.info(q.toString());
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 INNER JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID INNER JOIN TABLE_3 ON TABLE_1.ID = TABLE_3.TABLE_3_ID", q);
    }

    @Test
    public void simpleLeftJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").leftJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID");
        logger.info(q.toString());
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 LEFT JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID", q);
    }

    @Test
    public void simpleRightJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").rightJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID");
        logger.info(q.toString());
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 RIGHT JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID", q);
    }

    @Test
    public void simpleInnerJoin() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1").innerJoin("TABLE_2").on("TABLE_1.ID").equalsTo("TABLE_2.TABLE_2_ID");
        logger.info(q.toString());
        Assert.assertEquals("SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1 INNER JOIN TABLE_2 ON TABLE_1.ID = TABLE_2.TABLE_2_ID", q);
    }
}
