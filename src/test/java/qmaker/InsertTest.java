package qmaker;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.query.Insert;
import com.mizore.sql.qmaker.query.Renderer;
import com.mizore.sql.qmaker.query.types.DateRenderer;
import com.mizore.sql.qmaker.query.types.Sequence;

public class InsertTest {

    @Test
    public void simpleTest() {
        Insert q = new Insert("TABLE_1");
        q.set("FIELD", 1);
        Assert.assertEquals("INSERT INTO TABLE_1 (FIELD) VALUES (1)", q.asString());
    }
    
    @Test
    public void insertWithSequenceTest() {
        Insert q = new Insert("TABLE_1");
        q.set("FIELD", new Sequence("SEQ"));
        Assert.assertEquals("INSERT INTO TABLE_1 (FIELD) VALUES (SEQ.nextVal)", q.asString());
    }

    @Test
    public void simpleTestWithFormatter() {
        Insert q = new Insert("TABLE_1");
        q.set("FIELD", 1, new Renderer<Integer>() {
            @Override
            public String render(Integer value) {
                return Integer.toString(value);
            }

        });

        Assert.assertEquals("INSERT INTO TABLE_1 (FIELD) VALUES (1)", q.asString());
    }

    @Test
    public void simpleTestWithType() {
        Insert q = new Insert("TABLE_1");
        GregorianCalendar cal = new GregorianCalendar(2015, GregorianCalendar.JANUARY, 1);
        q.set("FIELD", cal.getTime(), new DateRenderer("YYYY/MM/DD", "yyyy/MM/dd"));
        Assert.assertEquals("INSERT INTO TABLE_1 (FIELD) VALUES (TO_DATE('YYYY/MM/DD', '2015/01/01'))", q.asString());
    }

    @Test
    public void simpleTypeTest() {
        Insert q = new Insert("TABLE_1");
        q.set("FIELD", "1");
        Assert.assertEquals("INSERT INTO TABLE_1 (FIELD) VALUES ('1')", q.asString());
    }
}
