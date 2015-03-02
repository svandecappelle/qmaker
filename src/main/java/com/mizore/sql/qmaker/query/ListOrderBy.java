package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.utils.SqlClauses;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        List of order by clauses.
 */
public class ListOrderBy extends SimpleListField<OrderBy> implements OrderBy {

    private static final long serialVersionUID = -7777339847872891579L;

    /**
     * Construct Order by SQL clause group.
     */
    public ListOrderBy() {
    }

    @Override
    public OrderBy getMe() {
        return this;
    }

    @Override
    public OrderBy and(String schemaName, String tableName, String fieldName) {
        if (tableName != null) {
            this.add(new OrderField(new Table(schemaName, tableName), fieldName));
        } else {
            this.add(new OrderField(fieldName));
        }
        return this.getMe();
    }

    @Override
    SqlClauses getType() {
        return SqlClauses.ORDER_BY;
    }

    @Override
    public OrderBy asc() {
        ((OrderField) this.get(this.size() - 1)).asc();
        return this;
    }

    @Override
    public OrderBy desc() {
        ((OrderField) this.get(this.size() - 1)).desc();
        return this;
    }

}
