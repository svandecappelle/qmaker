package com.mizore.sql.qmaker.query;

import java.util.ArrayList;
import java.util.Iterator;

import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        List of all group by fields.
 */
public class ListGroupBy extends ArrayList<Field> implements GroupBy {

    private static final long serialVersionUID = -7777339847872891579L;

    /**
     * Construct groupBy SQL clause group.
     */
    public ListGroupBy() {
    }

    /**
     * Convert all groupBy into SQL String value clause.
     * 
     * @return
     */
    @Override
    public String toString() {
        StringBuilder groups = new StringBuilder();
        groups.append(SqlClauses.GROUP_BY);
        groups.append(SeparatorType.EMPTY);

        Iterator<Field> groupsIterator = this.iterator();
        for (Field fieldGroupBy : this) {
            groupsIterator.next();

            groups.append(fieldGroupBy.toString());

            if (groupsIterator.hasNext()) {
                groups.append(SeparatorType.FIELD);
                groups.append(SeparatorType.EMPTY);
            }
        }

        return groups.toString();
    }

    @Override
    public GroupBy and(String fieldName) {
        return this.and(null, null, fieldName);
    }

    @Override
    public GroupBy and(String tableName, String fieldName) {
        return this.and(null, tableName, fieldName);
    }

    @Override
    public GroupBy and(String schemaName, String tableName, String fieldName) {
        if (tableName != null) {
            this.add(new Field(new Table(schemaName, tableName), fieldName));
        } else {
            this.add(new Field(fieldName));
        }
        return this;
    }
}