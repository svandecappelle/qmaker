package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.utils.SqlClauses;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        List of all group by fields.
 */
public class ListGroupBy extends SimpleListField<GroupBy> implements GroupBy {

    private static final long serialVersionUID = -7777339847872891579L;

    /**
     * Construct groupBy SQL clause group.
     */
    public ListGroupBy() {
    }

    @Override
    public GroupBy getMe() {
        return this;
    }

    @Override
    SqlClauses getType() {
        return SqlClauses.GROUP_BY;
    }

}
