package qmaker;

import org.junit.Test;

import com.mizore.sql.qmaker.query.Delete;
import com.mizore.sql.qmaker.query.Insert;
import com.mizore.sql.qmaker.query.Merge;
import com.mizore.sql.qmaker.query.StringSqlValueRenderer;
import com.mizore.sql.qmaker.query.Merge.Match;
import com.mizore.sql.qmaker.query.Update;

import junit.framework.Assert;

public class MergeTest {

    @Test
    public void simpleMerge() {

        Match checkExistClause = new Match(true);
        checkExistClause.select("1").as("ID_1");
        checkExistClause.select("2").as("ID_2");
        checkExistClause.from("DUAL");

        Update update = new Update();
        update.set("VALUE_EDIT", "VALUE_EDIT + 1", new StringSqlValueRenderer());

        Insert insert = new Insert();
        insert.set("VALUE_EDIT", 1);

        Merge merge = new Merge("OUTPUT_TABLE", checkExistClause, update, insert);

        Assert.assertEquals(
                "MERGE INTO OUTPUT_TABLE USING (SELECT 1 AS ID_1, 2 AS ID_2 FROM DUAL) MERGING ON (OUTPUT_TABLE.ID_1 = MERGING.ID_1 AND OUTPUT_TABLE.ID_2 = MERGING.ID_2) WHEN MATCHED THEN UPDATE SET VALUE_EDIT = VALUE_EDIT + 1 WHEN NOT MATCHED THEN INSERT (VALUE_EDIT, OUTPUT_TABLE.ID_1, OUTPUT_TABLE.ID_2) VALUES (1, MERGING.ID_1, MERGING.ID_2)",
                merge.toString());
    }

    @Test
    public void deleteMerge() {
        Match checkExistClause = new Match(true);
        checkExistClause.select("1").as("ID_1");
        checkExistClause.select("2").as("ID_2");
        checkExistClause.from("DUAL");

        Update update = new Update();
        update.set("VALUE_EDIT", "VALUE_EDIT - 1", new StringSqlValueRenderer());

        Delete insert = new Delete();
        insert.where("VALUE_EDIT").equalsTo(0);

        Merge merge = new Merge("OUTPUT_TABLE", checkExistClause, update, insert);

        Assert.assertEquals(
                "MERGE INTO OUTPUT_TABLE USING (SELECT 1 AS ID_1, 2 AS ID_2 FROM DUAL) MERGING ON (OUTPUT_TABLE.ID_1 = MERGING.ID_1 AND OUTPUT_TABLE.ID_2 = MERGING.ID_2) WHEN MATCHED THEN UPDATE SET VALUE_EDIT = VALUE_EDIT - 1 DELETE WHERE VALUE_EDIT = 0",
                merge.toString());

    }
}
