package com.mizore.sql.qmaker.query;

import java.util.ArrayList;
import java.util.List;

import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Make a query.
 */
/**
 * @author svandecappelle
 *
 */
/**
 * @author svandecappelle
 *
 */
public class Query {

    // fields on select.
    private List<Field> fields;

    // From clause.
    private From from;

    // Query alias.
    private String alias;

    /**
     * Create a query object.
     */
    public Query() {
        fields = new ArrayList<Field>();
    }

    /**
     * Insert select clause.
     * 
     * @param table
     *            table on select field.
     * @param field
     *            field name.
     * @return the field clause associated to the select entered.
     */
    public Field select(String table, String field) {
        Field fieldOutput = new Field(new Table(table), field);
        fields.add(fieldOutput);
        return fieldOutput;
    }

    /**
     * Insert from clause.
     * 
     * @param table
     *            starting table clause.
     * @return the from clause.
     */
    public From from(String table) {
        this.from = new From(table);
        return from;
    }

    /**
     * Add an inner join to query.
     * 
     * @return inner join SQL clause added to query.
     */
    public InnerJoin innerJoin(String table) {
        if (from != null) {
            return from.innerJoin(table);
        } else {
            throw new IllegalQueryFormedException("SQl Join can only be added to and existing from clause. Check you've added from SQL clause on Query.");
        }
    }

    /**
     * Convert to sql string.
     * 
     * @return sql representation of query.
     */
    public String asString() {
        StringBuilder buffer = new StringBuilder();

        if (alias != null) {
            buffer.append(SeparatorType.LEFT_PARENTHESIS);
        }

        buffer.append(SqlClauses.SELECT);
        int dataFieldsCount = fields.size();
        for (Field field : fields) {
            buffer.append(SeparatorType.EMPTY);
            buffer.append(field.toString());

            dataFieldsCount -= 1;
            if (dataFieldsCount > 0) {
                buffer.append(SeparatorType.FIELD);
            }
        }

        buffer.append(SeparatorType.EMPTY);
        buffer.append(SqlClauses.FROM);
        buffer.append(SeparatorType.EMPTY);
        buffer.append(from.toString());

        if (alias != null) {
            buffer.append(SeparatorType.RIGHT_PARENTHESIS);
            buffer.append(SeparatorType.EMPTY);
            buffer.append(SqlClauses.AS);
            buffer.append(SeparatorType.EMPTY);
            buffer.append(alias);
        }

        return buffer.toString();
    }

    @Override
    public String toString() {
        return asString();
    }

    /**
     * Add alias on query.
     * 
     * @param alias
     *            alias name.
     */
    public void as(String alias) {
        this.alias = alias;
    }
}
