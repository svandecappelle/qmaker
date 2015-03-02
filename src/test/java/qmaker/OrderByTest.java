package qmaker;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Query;

public class OrderByTest {

    private final Logger logger = Logger.getLogger("OrderBy");

    @Test
    public void simpleOrderBy() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.orderBy("FIELD").asc();
        logger.info(q.asString());
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
        logger.info(q.asString());
        Assert.assertEquals("SELECT TABLE_1.FIELD, TABLE_1.FIELD2 FROM TABLE_1 ORDER BY FIELD ASC, FIELD2 DESC", q.asString());
    }
}
