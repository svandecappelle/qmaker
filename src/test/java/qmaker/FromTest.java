package qmaker;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Query;

public class FromTest {

    private final Logger logger = Logger.getLogger("From");

    @Test
    public void aliasTest() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD").as("ALIAS_1");
        q.from("TABLE_1");
        q.as("ALIAS_QUERY");
        logger.info(q.asString());
        Assert.assertEquals("(SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1) ALIAS_QUERY", q.asString());
    }
}
