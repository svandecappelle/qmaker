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
public class Query extends HasSqlRestrictions<Query>implements IsClause, IsSelectionQuery {

    private static final long serialVersionUID = 3483079046115811468L;

    // fields on select.
    private final List<Field> fields;

    // From clause.
    private From from;

    // Query alias.
    private String alias;

    // sql order by clauses.
    private ListOrderBy orderBy;

    /**
     * Create a query object.
     */
    public Query() {
        fields = new ArrayList<Field>();
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
    public <T> Field select(String schema, String table, T field) {
        Field fieldOutput = new Field(new Table(schema, table), field);
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
    public Field select(Field field) {
        fields.add(field);
        return field;
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
    public <T> Field select(String table, T field) {
        Field fieldOutput = new Field(new Table(table), field);
        fields.add(fieldOutput);
        return fieldOutput;
    }

    /**
     * Insert select clause.
     * 
     * @param field
     *            field name.
     * @return the field clause associated to the select entered.
     */
    public <T> Field select(T field) {
        Field fieldOutput = new Field(field);
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
     * @param query
     *            sub-query clause from.
     * @return the from clause.
     */
    public From from(IsSelectionQuery query) {
        this.from = new From(SeparatorType.LEFT_PARENTHESIS + query.toString() + SeparatorType.RIGHT_PARENTHESIS);
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
     * Add an left join to query.
     * 
     * @return left join SQL clause added to query.
     */
    public LeftJoin leftJoin(String table) {
        if (from != null) {
            return from.leftJoin(table);
        } else {
            throw new IllegalQueryFormedException("SQl Join can only be added to and existing from clause. Check you've added from SQL clause on Query.");
        }
    }

    /**
     * Add an right join to query.
     * 
     * @return right join SQL clause added to query.
     */
    public RightJoin rightJoin(String table) {
        if (from != null) {
            return from.rightJoin(table);
        } else {
            throw new IllegalQueryFormedException("SQl Join can only be added to and existing from clause. Check you've added from SQL clause on Query.");
        }
    }

    /**
     * Add an outer join to query.
     * 
     * @return outer join SQL clause added to query.
     */
    public OuterJoin outerJoin(String table) {
        if (from != null) {
            return from.outerJoin(table);
        } else {
            throw new IllegalQueryFormedException("SQl Join can only be added to and existing from clause. Check you've added from SQL clause on Query.");
        }
    }

    /**
     * Add an join to query.
     * 
     * @return join SQL clause added to query.
     */
    public Join join(JoinType type, String table) {
        if (from != null) {
            return from.join(type, table);
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
     * Add a simple groupBy SQL clause field.
     * 
     * @param fieldName
     *            the field to group by.
     */
    public void groupBy(String fieldName) {
        this.groupBy(null, null, fieldName);
    }

    /**
     * Add a group by with table name.
     * 
     * @param tableName
     *            table.
     * @param fieldName
     *            field.
     */
    public void groupBy(String tableName, String fieldName) {
        this.groupBy(null, tableName, fieldName);
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
    public void groupBy(String schemaName, String tableName, String fieldName) {
        this.from.groupBy(schemaName, tableName, fieldName);
    }

    /**
     * Add a simple groupBy SQL clause field.
     * 
     * @param fieldName
     *            the field to group by.
     */
    public OrderBy orderBy(String fieldName) {
        return this.orderBy(null, null, fieldName);
    }

    /**
     * Add a group by with table name.
     * 
     * @param tableName
     *            table.
     * @param fieldName
     *            field.
     */
    public OrderBy orderBy(String tableName, String fieldName) {
        return this.orderBy(null, tableName, fieldName);
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
    public OrderBy orderBy(String schemaName, String tableName, String fieldName) {
        return this.orderBy(schemaName, tableName, fieldName, true);
    }

    /**
     * Add a simple groupBy SQL clause field.
     * 
     * @param fieldName
     *            the field to group by.
     * @param isAsc
     *            is sorting ascending.
     */
    public OrderBy orderBy(String fieldName, boolean isAsc) {
        return this.orderBy(null, null, fieldName, isAsc);
    }

    /**
     * Add a group by with table name.
     * 
     * @param tableName
     *            table.
     * @param fieldName
     *            field.
     * @param isAsc
     *            is sorting ascending.
     */
    public OrderBy orderBy(String tableName, String fieldName, boolean isAsc) {
        return this.orderBy(null, tableName, fieldName, isAsc);
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
     * @param isAsc
     *            is sorting ascending.
     */
    public OrderBy orderBy(String schemaName, String tableName, String fieldName, boolean isAsc) {
        if (this.orderBy == null) {
            this.orderBy = new ListOrderBy();
        }
        if (isAsc) {
            return this.orderBy.and(schemaName, tableName, fieldName).asc();
        } else {
            return this.orderBy.and(schemaName, tableName, fieldName).desc();
        }
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        if (alias != null && !from.isQuery()) {
            buffer.append(SeparatorType.LEFT_PARENTHESIS);
        }

        buffer.append(QueryFactory.buildSelect(fields));

        buffer.append(QueryFactory.buildFrom(from));

        buffer.append(QueryFactory.buildWhere(getRestrictions()));

        buffer.append(QueryFactory.buildGroupBy(this.from));

        if (orderBy != null) {
            buffer.append(QueryFactory.buildOrder(orderBy));
        }

        if (alias != null && !from.isQuery()) {
            buffer.append(SeparatorType.RIGHT_PARENTHESIS);
            buffer.append(SeparatorType.EMPTY);
            buffer.append(alias);
        } else if (alias != null) {
            buffer.append(SeparatorType.EMPTY);
            buffer.append(alias);
        }

        return buffer.toString();
    }

    /**
     * Get SQL SELECT Query fields
     * 
     * @return list of all select clauses fields.
     */
    protected List<Field> getFields() {
        return fields;
    }

    @Override
    protected Query getClause() {
        return this;
    }
}
