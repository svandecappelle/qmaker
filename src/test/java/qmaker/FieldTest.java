package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Field;
import com.mizore.sql.qmaker.query.Query;

public class FieldTest {

    @Test
    public void simpleWhere() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where("TABLE_1", "FIELD").equalsTo(new Field("1"));
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1", q.asString());
    }

    @Test
    public void simpleWhereExists() {

        Query qExists = new Query();
        qExists.select("1");
        qExists.from("TABLE_E");
        qExists.where("TABLE_E", "FIELD").equalsTo("1");

        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where().exists(qExists);
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE EXISTS (SELECT 1 FROM TABLE_E WHERE TABLE_E.FIELD = 1)", q.asString());
    }

    @Test
    public void simpleWhereNotEquals() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where("TABLE_1", "FIELD").notEqualsTo("1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD <> 1", q.asString());
    }

    @Test
    public void multipleWhere() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where("TABLE_1", "FIELD").equalsTo("1").and("1").equalsTo("2");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD = 1 AND 1 = 2", q.asString());
    }

    @Test
    public void lower() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where("TABLE_1", "FIELD").lower("1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD < 1", q.asString());
    }

    @Test
    public void lowerOrEquals() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where("TABLE_1", "FIELD").lowerOrEquals("1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD <= 1", q.asString());

    }

    @Test
    public void greater() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where("TABLE_1", "FIELD").greater("1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD > 1", q.asString());
    }

    @Test
    public void greaterOrEquals() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where("TABLE_1", "FIELD").greaterOrEquals("1");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD >= 1", q.asString());
    }

    @Test
    public void between() {
        Query q = new Query();
        q.select("TABLE_1", "FIELD");
        q.from("TABLE_1");
        q.where("TABLE_1", "FIELD").beetween("1", "2");
        Assert.assertEquals("SELECT TABLE_1.FIELD FROM TABLE_1 WHERE TABLE_1.FIELD BETWEEN 1 AND 2", q.asString());

    }

}
