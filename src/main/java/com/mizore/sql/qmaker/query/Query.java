package com.mizore.sql.qmaker.query;

import java.util.ArrayList;
import java.util.List;

import com.mizore.sql.qmaker.utils.SeparatorType;

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

    // Query alias.
    private String alias;

    private List<SqlRestriction> restrictions;

    /**
     * Create a query object.
     */
    public Query() {
        fields = new ArrayList<Field>();
        restrictions = new ArrayList<SqlRestriction>();
    }

    /**
     * Insert select clause.
     * 
     * @param field
     *            field name.
     * @return the field clause associated to the select entered.
     */
    public Field select(String field) {
        Field fieldOutput = new Field(field);
        fields.add(fieldOutput);
        return fieldOutput;
    }

    /**
     * Insert select clause.
     * 
     * @param schema
     *            schema name.
     * @param table
     *            table on select field.
     * @param field
     *            field name.
     * @return the field clause associated to the select entered.
     */
    public Field select(String schema, String table, String field) {
        Field fieldOutput = new Field(new Table(schema, table), field);
        fields.add(fieldOutput);
        return fieldOutput;
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
     * Insert from clause.
     * 
     * @param query
     *            sub-query clause from.
     * @return the from clause.
     */
    public From from(Query query) {
        this.from = new From(query);
        return from;
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
        return toString();
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

    /**
     * Add an sql Where restrition clause to the query.
     * 
     * @param expression
     *            Expression filter.
     * @return the sql restriction injected clause.
     */
    public SqlRestriction where(String expression) {
        SqlRestriction restriction = new SqlRestriction(new Field(expression), this);
        this.restrictions.add(restriction);
        return restriction;
    }

    /**
     * Add an sql Where restrition clause to the query.
     * 
     * @param table
     *            table on wich clause is about.
     * @param field
     *            fieldname.
     * @return the sql restriction injected clause.
     */
    public SqlRestriction where(String table, String field) {
        SqlRestriction restriction = new SqlRestriction(new Field(new Table(table), field), this);
        this.restrictions.add(restriction);
        return restriction;
    }

    /**
     * Add an sql Where restrition clause to the query.
     * 
     * @param schema
     *            the SQL schema of table.
     * @param table
     *            table on wich clause is about.
     * @param field
     *            fieldname.
     * @return the sql restriction injected clause.
     */
    public SqlRestriction where(String schema, String table, String field) {
        SqlRestriction restriction = new SqlRestriction(new Field(new Table(schema, table), field), this);
        this.restrictions.add(restriction);
        return restriction;
    }

    /**
     * Add an sql Where restrition clause to the query.
     * 
     * @param field
     *            fieldname.
     * @return the sql restriction injected clause.
     */
    public SqlRestriction and(String expression) {
        return this.where(expression);
    }

    /**
     * Add an sql Where restrition clause to the query.
     * 
     * @param table
     *            table on wich clause is about.
     * @param field
     *            fieldname.
     * @return the sql restriction injected clause.
     */
    public SqlRestriction and(String table, String field) {
        return this.where(table, field);
    }

    /**
     * Add an sql Where restrition clause to the query.
     * 
     * @param schema
     *            the SQL schema of table.
     * @param table
     *            table on wich clause is about.
     * @param field
     *            fieldname.
     * @return the sql restriction injected clause.
     */
    public SqlRestriction and(String schema, String table, String field) {
        return this.where(schema, table, field);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        if (alias != null && !from.isQuery()) {
            buffer.append(SeparatorType.LEFT_PARENTHESIS);
        }

        buffer.append(QueryFactory.buildSelect(fields));

        buffer.append(QueryFactory.buildFrom(from));

        if (alias != null && !from.isQuery()) {
            buffer.append(SeparatorType.RIGHT_PARENTHESIS);
            buffer.append(SeparatorType.EMPTY);
            buffer.append(alias);
        } else if (alias != null) {
            buffer.append(SeparatorType.EMPTY);
            buffer.append(alias);
        }

        buffer.append(QueryFactory.buildWhere(restrictions));

        return buffer.toString();
    }
}
