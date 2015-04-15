package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Delete;

public class DeleteTest {

    @Test
    public void simpleFieldTest() {
        Delete q = new Delete("TABLE_1");
        q.delete("FIELD");
        Assert.assertEquals("DELETE FIELD FROM TABLE_1", q.asString());
    }
    
    @Test
    public void simpleAllDeleteTest() {
        Delete q = new Delete("TABLE_1");
        Assert.assertEquals("DELETE FROM TABLE_1", q.asString());
    }
    
    @Test
    public void simpleAllDeleteWhereTest() {
        Delete q = new Delete("TABLE_1");
        q.where("FIELD_1").equalsTo(1);
        Assert.assertEquals("DELETE FROM TABLE_1 WHERE FIELD_1 = 1", q.asString());
    }
}
