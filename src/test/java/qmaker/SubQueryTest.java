package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.From;
import com.mizore.sql.qmaker.query.Query;

public class SubQueryTest {

    @Test
    public void simpleSubQuery() {
        Query q = new Query();
        q.select("ALIAS_1");

        // sub-query
        Query subQuery = new Query();
        subQuery.select("TABLE_1", "FIELD").as("ALIAS_1");
        subQuery.from("TABLE_1");

        From fromClause = q.from(subQuery);
        Assert.assertNotNull(fromClause);

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

        From fromClause = q.from(subQuery);
        Assert.assertNotNull(fromClause);

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

        From fromClause = q.from(subQuery).as("SUB_QUERY");
        Assert.assertNotNull(fromClause);

        Assert.assertEquals("SELECT SUB_QUERY.ALIAS_1 FROM (SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1) SUB_QUERY", q.toString());
    }

    @Test
    public void multiplesSubQueryAliasOnQuery() {
        Query q = new Query();
        q.select("SUB_QUERY", "ALIAS_1");

        // sub-query
        Query subQuery = new Query();
        subQuery.select("SUB_QUERY_2", "FIELD").as("ALIAS_1");

        // sub-query 2
        Query subQueryTwo = new Query();
        subQueryTwo.select("TABLE_1", "FIELD").as("ALIAS_1");
        subQueryTwo.from("TABLE_1");

        subQuery.from(subQueryTwo).as("SUB_QUERY_2");

        q.from(subQuery).as("SUB_QUERY");

        Assert.assertEquals("SELECT SUB_QUERY.ALIAS_1 FROM (SELECT SUB_QUERY_2.FIELD AS ALIAS_1 FROM (SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1) SUB_QUERY_2) SUB_QUERY", q.toString());
    }

    @Test
    public void subQueryWithJoin() {
        Query q = new Query();
        q.select("ALIAS_1");

        // sub-query
        Query subQuery = new Query();
        subQuery.select("TABLE_1", "FIELD").as("ALIAS_1");
        subQuery.from("TABLE_1");

        q.from(subQuery).as("SUB_QUERY").innerJoin("TABLE_2").on("TABLE_2", "FIELD_ID_TABLE_1").equalsTo("SUB_QUERY", "ALIAS_1");

        Assert.assertEquals("SELECT ALIAS_1 FROM (SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1) SUB_QUERY INNER JOIN TABLE_2 ON TABLE_2.FIELD_ID_TABLE_1 = SUB_QUERY.ALIAS_1", q.toString());
    }

    @Test
    public void subQueryWithJoinAndAliasOnQueryClause() {
        Query q = new Query();
        q.select("ALIAS_1");

        // sub-query
        Query subQuery = new Query();
        subQuery.select("TABLE_1", "FIELD").as("ALIAS_1");
        subQuery.from("TABLE_1");
        subQuery.as("SUB_QUERY");

        q.from(subQuery).innerJoin("TABLE_2").on("TABLE_2", "FIELD_ID_TABLE_1").equalsTo("SUB_QUERY", "ALIAS_1");

        Assert.assertEquals("SELECT ALIAS_1 FROM ((SELECT TABLE_1.FIELD AS ALIAS_1 FROM TABLE_1) SUB_QUERY) INNER JOIN TABLE_2 ON TABLE_2.FIELD_ID_TABLE_1 = SUB_QUERY.ALIAS_1", q.toString());
    }
}
