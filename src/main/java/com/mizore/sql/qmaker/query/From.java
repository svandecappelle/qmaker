package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.utils.string.S;
import com.mizore.sql.qmaker.utils.string.Template;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        From sql query clause.
 */
public class From {

    // table of from clause.
    private Table table;

    // sql join clauses.
    private ListJoin<Join> joins;

    // true if from clause is an sub-query clause.
    private boolean query = false;
    private String alias;

    /**
     * From with table initializer.
     * 
     * @param table
     *            table name.
     */
    public From(String table) {
        this.table = new Table(table);
        this.joins = new ListJoin<Join>();
    }

    /**
     * From with query initializer.
     * 
     * @param query
     *            sub-query.
     */
    public From(Query query) {
        this(query.asString());
        this.query = true;
    }

    /**
     * Return <code>true</code> if from clause is a sub-query.
     * 
     * @return <code>true</code> if from clause is a sub-query
     *         <code>false</code> if it is a table referenced.
     */
    public boolean isQuery() {
        return query;
    }

    /**
     * Make and alias on from clause.
     * 
     * @param alias
     *            alias name.
     * @return the from clause.
     */
    public From as(String alias) {
        this.alias = alias;
        return this;
    }

    /**
     * Insert inner join clause.
     * 
     * @param table
     *            the table on wich the join must be done.
     * @return the join clause created.
     */
    public InnerJoin innerJoin(String table) {
        InnerJoin innerJoin = new InnerJoin(table, this);
        this.joins.add(innerJoin);
        return innerJoin;
    }

    /**
     * Insert left join clause.
     * 
     * @param table
     *            the table on wich the join must be done.
     * @return the join clause created.
     */
    public Join leftJoin(String table) {
        LeftJoin innerJoin = new LeftJoin(table, this);
        this.joins.add(innerJoin);
        return innerJoin;
    }

    /**
     * Insert right join clause.
     * 
     * @param table
     *            the table on wich the join must be done.
     * @return the join clause created.
     */
    public Join rightJoin(String table) {
        RightJoin innerJoin = new RightJoin(table, this);
        this.joins.add(innerJoin);
        return innerJoin;
    }

    @Override
    public String toString() {
        S buildedString = null;
        if (this.isQuery()) {
            if (this.joins != null) {
                buildedString = new S("({{table}}){{alias}}{{joins}}").template(new Template().c("table", this.table).c("alias", this.table.getAs()).c("joins", this.joins));
            } else {
                buildedString = new S("({{table}}){{alias}}").template(new Template().c("table", this.table).c("alias", this.table.getAs()));
            }
        } else {
            if (this.alias != null) {
                if (this.joins != null) {
                    buildedString = new S("({{table}}) AS {{alias}}{{joins}}").template(new Template().c("table", this.table).c("alias", this.alias).c("joins", this.joins));
                } else {
                    buildedString = new S("({{table}}) AS {{alias}}").template(new Template().c("table", this.table).c("alias", this.alias));
                }
            } else {
                if (this.joins != null) {
                    buildedString = new S("{{table}}{{joins}}").template(new Template().c("table", this.table).c("joins", this.joins));
                } else {
                    buildedString = new S("{{table}}").template(new Template().c("table", this.table));
                }
            }
        }
        return buildedString.toString();
    }
}
