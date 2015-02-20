package com.mizore.sql.qmaker;

import java.util.ArrayList;
import java.util.List;

import com.mizore.sql.qmaker.query.Field;
import com.mizore.sql.qmaker.query.From;
import com.mizore.sql.qmaker.query.Table;
import com.mizore.sql.qmaker.utils.SqlStringConstants;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Make a query.
 */
public class Query {

    // fields on select.
    private List<Field> fields;

    // From clause.
    private From from;

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
     * Convert to sql string.
     * 
     * @return sql representation of query.
     */
    public String asString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(SqlStringConstants.SELECT);
        int dataFieldsCount = fields.size();
        for (Field field : fields) {
            buffer.append(SqlStringConstants.EMPTY_SEPARATOR);
            buffer.append(field.toString());

            dataFieldsCount -= 1;
            if (dataFieldsCount > 0) {
                buffer.append(SqlStringConstants.FIELD_SEPARATOR);
            }
        }

        buffer.append(SqlStringConstants.EMPTY_SEPARATOR);
        buffer.append(SqlStringConstants.FROM);
        buffer.append(SqlStringConstants.EMPTY_SEPARATOR);
        buffer.append(from.toString());

        return buffer.toString();
    }

    @Override
    public String toString() {
        return asString();
    }
}
