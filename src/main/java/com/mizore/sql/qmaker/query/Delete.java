package com.mizore.sql.qmaker.query;

import java.util.ArrayList;
import java.util.List;

import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

public class Delete extends HasSqlRestrictions<Delete> implements IsClause {

    private static final long serialVersionUID = 2641125597478747761L;

    // fields on select.
    private final List<Field> fields;

    // From clause.
    private From from;

    public Delete(String table) {
        this(new Table(table));
    }

    public Delete(Table table) {
        this.fields = new ArrayList<Field>();
        this.from = new From(table);
    }

    /**
     * Insert select clause.
     * 
     * @param field
     *            field name.
     * @return the field clause associated to the select entered.
     */
    public Field delete(String field) {
        Field fieldOutput = new Field(field);
        fields.add(fieldOutput);
        return fieldOutput;
    }

    /**
     * Insert select clause.
     * 
     * @param field
     *            field object.
     * @return the field clause associated to the select entered.
     */
    public Field delete(Field field) {
        fields.add(field);
        return field;
    }

    /**
     * Insert from clause.
     *
     * @param scema
     *            Schema name.
     * @param table
     *            starting table clause.
     * @return the from clause.
     */
    public From from(String schema, String table) {
        this.from = new From(schema, table);
        return from;
    }

    @Override
    protected Delete getClause() {
        return this;
    }

    @Override
    public String toString() {
        return asString();
    }

    public String asString() {
        StringBuilder buffer = new StringBuilder();

        if (!fields.isEmpty()) {
            buffer.append(QueryFactory.buildDelete(fields));
        } else {
            buffer.append(SqlClauses.DELETE);
            buffer.append(SeparatorType.EMPTY);
        }

        buffer.append(QueryFactory.buildFrom(from));
        buffer.append(QueryFactory.buildWhere(getRestrictions()));

        return buffer.toString();
    }

}
