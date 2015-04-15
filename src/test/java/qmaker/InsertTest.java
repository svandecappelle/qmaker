package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Insert;

public class InsertTest {

    @Test
    public void simpleTest() {
        Insert q = new Insert("TABLE_1");
        q.set("FIELD", 1);
        Assert.assertEquals("INSERT INTO TABLE_1 (FIELD) VALUES (1)", q.asString());
    }
    
    @Test
    public void simpleTypeTest() {
        Insert q = new Insert("TABLE_1");
        q.set("FIELD", "1");
        Assert.assertEquals("INSERT INTO TABLE_1 (FIELD) VALUES ('1')", q.asString());
    }
}
