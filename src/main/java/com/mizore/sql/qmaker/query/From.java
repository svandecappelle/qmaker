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

    // sql group by clauses.
    private ListGroupBy groupBy;

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
        this(null, table);
    }

    /**
     * From with table initializer.
     * 
     * @param schema
     *            Schema name.
     * @param table
     *            table name.
     */
    public From(String schema, String table) {
        this.table = new Table(schema, table);
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
        StringBuilder fromClauseGenerated = new StringBuilder();

        // from clause
        if (this.isQuery() || this.alias != null) {
            fromClauseGenerated.append(new S("({{table}})").template(new Template().c("table", this.table)));
        } else {
            fromClauseGenerated.append(new S("{{table}}").template(new Template().c("table", this.table)));
        }

        // alias clause
        if (this.alias != null) {
            fromClauseGenerated.append(new S(" {{alias}}").template(new Template().c("alias", this.alias)));
        }

        // joins clauses
        if (this.joins != null) {
            fromClauseGenerated.append(new S("{{joins}}").template(new Template().c("joins", this.joins)));
        }

        return fromClauseGenerated.toString();
    }

    /**
     * Insert generic Join clause.
     * 
     * @param type
     *            type of join.
     * @param table
     *            the table on wich the join must be done.
     * @return the join clause created.
     */
    public Join join(final JoinType type, String table) {
        Join join = new Join(table, this) {
            @Override
            public JoinType getType() {
                return type;
            }
        };
        this.joins.add(join);
        return join;
    }

    /**
     * Add a simple groupBy SQL clause field.
     * 
     * @param fieldName
     *            the field to group by.
     */
    public GroupBy groupBy(String fieldName) {
        return this.groupBy(null, null, fieldName);
    }

    /**
     * Add a group by with table name.
     * 
     * @param tableName
     *            table.
     * @param fieldName
     *            field.
     */
    public GroupBy groupBy(String tableName, String fieldName) {
        return this.groupBy(null, tableName, fieldName);
    }

    /**
     * Get the group by element.
     * 
     * @return the group by element.
     */
    protected ListGroupBy getGroupBy() {
        return groupBy;
    }

    /**
     * Add a group by with table and schema.
     * 
     * @param schemaName
     *            schema name.
     * @param tableName
     *            table.
     * @param fieldName
     *            field.
     */
    public GroupBy groupBy(String schemaName, String tableName, String fieldName) {
        if (this.groupBy == null) {
            this.groupBy = new ListGroupBy();
        }
        this.groupBy.and(schemaName, tableName, fieldName);

        return this.groupBy;

    }

    public boolean hasGroupBy() {
        return groupBy != null;
    }
}
