package qmaker;

import org.junit.Assert;
import org.junit.Test;

import com.mizore.sql.qmaker.parser.QueryParser;
import com.mizore.sql.qmaker.parser.QueryXmlParser;

public class ParserTest {

    @Test
    public void testSimpleParse() {
        QueryXmlParser parser = new QueryXmlParser("src/test/resources/test-query.xml");
        QueryParser parsedQuery = parser.parseDocument();
        Assert.assertEquals("SELECT 'VALUE1' AS KEY1, 'VALUE2' AS KEY2 FROM DUAL", parsedQuery.getQuery().asString());
    }
}
