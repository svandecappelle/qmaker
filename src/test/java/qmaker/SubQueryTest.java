package qmaker;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.From;
import com.mizore.sql.qmaker.query.Query;

public class SubQueryTest {

    private final Logger logger = Logger.getLogger("SubQueryTest");

    @Test
    public void simpleSubQuery() {
        Query q = new Query();
        q.select("ALIAS_1");

        // sub-query
        Query subQuery = new Query();
        subQuery.select("TABLE_1", "FIELD").as("ALIAS_1");
        subQuery.from("TABLE_1");
        logger.info(subQuery.asString());

        From fromClause = q.from(subQuery);
        Assert.assertNotNull(fromClause);

        logger.info(q.asString());
        Assert.assertEquals("SELECT ALIAS_1 FROM (SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1)", q.toString());
    }

    @Test
    public void aliasSubQuery() {
        Query q = new Query();
        q.select("SUB_QUERY", "ALIAS_1");

        // sub-query
        Query subQuery = new Query();
        subQuery.select("TABLE_1", "FIELD").as("ALIAS_1");
        subQuery.from("TABLE_1");
        subQuery.as("SUB_QUERY");
        logger.info(subQuery.asString());

        From fromClause = q.from(subQuery);
        Assert.assertNotNull(fromClause);

        logger.info(q.asString());
        Assert.assertEquals("SELECT SUB_QUERY.ALIAS_1 FROM ((SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1) SUB_QUERY)", q.toString());
    }

    @Test
    public void subQueryAliasOnQuery() {
        Query q = new Query();
        q.select("SUB_QUERY", "ALIAS_1");

        // sub-query
        Query subQuery = new Query();
        subQuery.select("TABLE_1", "FIELD").as("ALIAS_1");
        subQuery.from("TABLE_1");
        logger.info(subQuery.asString());

        From fromClause = q.from(subQuery).as("SUB_QUERY");
        Assert.assertNotNull(fromClause);

        logger.info(q.asString());
        Assert.assertEquals("SELECT SUB_QUERY.ALIAS_1 FROM (SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1) SUB_QUERY", q.toString());
    }
}
