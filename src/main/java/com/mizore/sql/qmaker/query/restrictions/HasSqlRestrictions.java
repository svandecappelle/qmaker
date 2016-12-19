package com.mizore.sql.qmaker.query.restrictions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mizore.sql.qmaker.query.Field;
import com.mizore.sql.qmaker.query.IsClause;
import com.mizore.sql.qmaker.query.Table;

public abstract class HasSqlRestrictions<T extends IsClause> implements Serializable {

    private static final long serialVersionUID = -3619291759010785491L;

    private final List<SqlRestriction<T>> restrictions;

    public HasSqlRestrictions() {
        this.restrictions = new ArrayList<SqlRestriction<T>>();
    }

    protected abstract T getClause();

    /**
     * Add an sql Where restrition clause defined by embedded object to the query.
     * 
     * @param expression
     *            Expression filter.
     * @return the sql restriction injected clause.
     */
    public SqlRestriction<T> where() {
        SqlRestriction<T> restriction = new SqlRestriction<T>(null, getClause());
        this.getRestrictions().add(restriction);
        return restriction;
    }

    /**
     * Add an sql Where restrition clause to the query.
     * 
     * @param expression
     *            Expression filter.
     * @return the sql restriction injected clause.
     */
    public SqlRestriction<T> where(String expression) {
        SqlRestriction<T> restriction = new SqlRestriction<T>(new Field(expression), getClause());
        this.getRestrictions().add(restriction);
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
    public SqlRestriction<T> where(String table, String field) {
        SqlRestriction<T> restriction = new SqlRestriction<T>(new Field(new Table(table), field), getClause());
        this.getRestrictions().add(restriction);
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
    public SqlRestriction<T> where(String schema, String table, String field) {
        SqlRestriction<T> restriction = new SqlRestriction<T>(new Field(new Table(schema, table), field), getClause());
        this.getRestrictions().add(restriction);
        return restriction;
    }

    /**
     * Add an sql Where restrition clause to the query.
     * 
     * @param field
     *            fieldname.
     * @return the sql restriction injected clause.
     */
    public SqlRestriction<T> and(String expression) {
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
    public SqlRestriction<T> and(String table, String field) {
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
    public SqlRestriction<T> and(String schema, String table, String field) {
        return this.where(schema, table, field);
    }

    protected List<SqlRestriction<T>> getRestrictions() {
        return restrictions;
    }
}
