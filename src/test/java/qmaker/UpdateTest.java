package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Update;

public class UpdateTest {

    @Test
    public void simpleWhere() {
        Update q = new Update("TABLE_1");
        q.set("FIELD_1").to("1");
        q.where("TABLE_1", "FIELD").equalsTo("1");
        Assert.assertEquals("UPDATE TABLE_1 SET FIELD_1 = 1 WHERE TABLE_1.FIELD = 1", q.asString());
    }

    @Test
    public void multipleUpdate() {
        Update q = new Update("TABLE_1");
        q.set("FIELD_1").to("1").and("FIELD_2").to("'a'");
        q.where("TABLE_1", "FIELD").equalsTo("1");
        Assert.assertEquals("UPDATE TABLE_1 SET FIELD_1 = 1, FIELD_2 = 'a' WHERE TABLE_1.FIELD = 1", q.asString());
    }

    
    @Test
    public void complexeWhere() {
        Update q = new Update("TABLE_1");
        q.set("FIELD_1").to("1");
        q.where("TABLE_1", "FIELD").equalsTo("1").and("TABLE_1", "ID").equalsTo("2");
        Assert.assertEquals("UPDATE TABLE_1 SET FIELD_1 = 1 WHERE TABLE_1.FIELD = 1 AND TABLE_1.ID = 2", q.asString());
    }
}
