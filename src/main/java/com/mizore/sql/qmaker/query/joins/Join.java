package com.mizore.sql.qmaker.query.joins;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mizore.sql.qmaker.filters.Expression;
import com.mizore.sql.qmaker.query.Field;
import com.mizore.sql.qmaker.query.From;
import com.mizore.sql.qmaker.query.Table;
import com.mizore.sql.qmaker.query.restrictions.EqualsExpression;
import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        SQL Join abstract. Need to make inner/left/outer/right SQL join.
 */
public abstract class Join implements Serializable {

    private static final long serialVersionUID = 4711711529500657659L;

    // Table on which join target.
    private Table table;

    // 'On' field SQL restriction join.
    private Field lastOn;
    private final List<Field> on;

    // Expression filters.
    private final Map<Field, Expression> expressionsJoinFilters;

    private From fromClause;

    /**
     * Constructor. Join SQL on a table.
     * 
     * @param tableName
     *            table name.
     */
    public Join(String tableName, From fromClause) {
        this.table = new Table(tableName);
        this.fromClause = fromClause;
        this.on = new ArrayList<Field>();
        this.expressionsJoinFilters = new HashMap<Field, Expression>();
    }

    /**
     * Add join 'On' SQL restriction.
     * 
     * @param fieldName
     *            the field 'on' restriction.
     * @return The join clause.
     */
    public Join on(String fieldName) {
        this.lastOn = new Field(fieldName);
        this.on.add(lastOn);
        return this;
    }

    /**
     * Add join 'On' SQL restriction.
     * 
     * @param table
     *            table name.
     * @param fieldName
     *            the field 'on' restriction.
     * @return The join clause.
     */
    public Join on(String table, String fieldName) {
        this.lastOn = new Field(new Table(table), fieldName);
        this.on.add(lastOn);
        return this;
    }

    /**
     * Add join 'On' SQL restriction.
     * 
     * @param schema
     *            schema SQL name.
     * @param table
     *            table name.
     * @param fieldName
     *            the field 'on' restriction.
     * @return The join clause.
     */
    public Join on(String schema, String table, String fieldName) {
        this.lastOn = new Field(new Table(schema, table), fieldName);
        this.on.add(lastOn);
        return this;
    }

    /**
     * Add a Equals to clause.
     * 
     * @param the
     *            expression right side.
     */
    public Join equalsTo(String expression) {
        expressionsJoinFilters.put(this.lastOn, new EqualsExpression(expression));
        return this;
    }

    /**
     * Add a Equals to clause.
     * 
     * @param table
     *            table to name.
     * @param the
     *            expression right side.
     */
    public Join equalsTo(String table, String fieldName) {
        expressionsJoinFilters.put(this.lastOn, new EqualsExpression(new Field(new Table(table), fieldName).toString()));
        return this;
    }

    /**
     * Add a Equals to clause.
     * 
     * @param schema
     *            SQL schema name.
     * @param table
     *            table to name.
     * @param the
     *            expression right side.
     */
    public Join equalsTo(String schema, String table, String fieldName) {
        expressionsJoinFilters.put(this.lastOn, new EqualsExpression(new Field(new Table(schema, table), fieldName).toString()));
        return this;
    }

    /**
     * Set an alias on join.
     * 
     * @param aliasJoinName
     *            alias name.
     */
    public Join as(String aliasJoinName) {
        this.table.as(aliasJoinName);
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
        return this.fromClause.innerJoin(table);
    }

    /**
     * Insert left join clause.
     * 
     * @param table
     *            the table on wich the join must be done.
     * @return the join clause created.
     */
    public Join leftJoin(String table) {
        return this.fromClause.leftJoin(table);
    }

    /**
     * Insert right join clause.
     * 
     * @param table
     *            the table on wich the join must be done.
     * @return the join clause created.
     */
    public Join rightJoin(String table) {
        return this.fromClause.rightJoin(table);
    }

    /**
     * Get the SQL Join type.
     * 
     * @return the join type.
     */
    public abstract JoinType getType();

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
        return this.fromClause.join(type, table);
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
        return this.fromClause.groupBy(schemaName, tableName, fieldName);

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(SeparatorType.EMPTY);
        builder.append(getType().name());
        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.JOIN);
        builder.append(SeparatorType.EMPTY);
        builder.append(table.toString());

        if (on != null) {
            builder.append(SeparatorType.EMPTY);
            builder.append(SqlClauses.ON);
            builder.append(SeparatorType.EMPTY);
        }

        Iterator<Field> it = this.on.iterator();
        for (Field fieldOn : this.on) {
            it.next();

            Expression expression = expressionsJoinFilters.get(fieldOn);
            builder.append(fieldOn);
            builder.append(SeparatorType.EMPTY);
            builder.append(expression);

            if (it.hasNext()) {
                builder.append(SeparatorType.EMPTY);
                builder.append(SeparatorType.AND);
                builder.append(SeparatorType.EMPTY);
            }
        }

        return builder.toString();
    }

}
