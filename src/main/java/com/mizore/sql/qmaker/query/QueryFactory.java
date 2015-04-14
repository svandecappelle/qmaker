package com.mizore.sql.qmaker.query;

import java.io.Serializable;
import java.util.Collection;

import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;
import com.mizore.sql.qmaker.utils.string.S;
import com.mizore.sql.qmaker.utils.string.Template;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Query string factory builder.
 */
public final class QueryFactory implements Serializable{

    private static final long serialVersionUID = 1443169121477505644L;

    /**
     * Private constructor to disable instanciation.
     */
    private QueryFactory() {
    }

    /**
     * Build Select clause from fields.
     * 
     * @param fields
     *            fields to select.
     * @return the SQL String representation of select clause.
     */
    public static String buildSelect(Collection<Field> fields) {

        StringBuilder buffer = new StringBuilder();
        buffer.append(SqlClauses.SELECT);
        int dataFieldsCount = fields.size();
        for (Field field : fields) {
            buffer.append(SeparatorType.EMPTY);
            buffer.append(field);

            dataFieldsCount -= 1;
            if (dataFieldsCount > 0) {
                buffer.append(SeparatorType.FIELD);
            }
        }

        buffer.append(SeparatorType.EMPTY);
        return buffer.toString();
    }

    /**
     * Build from clause.
     * 
     * @param fromClause
     *            the from clause.
     * @return the SQL String representation of From clause.
     */
    public static String buildFrom(From fromClause) {
        StringBuilder buffer = new StringBuilder();

        buffer.append(SqlClauses.FROM);
        buffer.append(SeparatorType.EMPTY);
        buffer.append(fromClause);

        return buffer.toString();
    }

    /**
     * Build where SQL restrictions clauses.
     * 
     * @param whereClauses
     *            the restrictions to builds.
     * @return the SQL String representation of Where restrictions clauses.
     */
    public static <T extends IsClause> String buildWhere(Collection<SqlRestriction<T>> whereClauses) {
        StringBuilder buffer = new StringBuilder();

        if (!whereClauses.isEmpty()) {
            buffer.append(SeparatorType.EMPTY);
            buffer.append(SqlClauses.WHERE);
            buffer.append(SeparatorType.EMPTY);
        }

        int restrictionsCount = whereClauses.size();
        for (SqlRestriction<T> restriction : whereClauses) {
            buffer.append(restriction);

            restrictionsCount -= 1;
            if (restrictionsCount > 0) {
                buffer.append(SeparatorType.EMPTY);
                buffer.append(SeparatorType.AND);
                buffer.append(SeparatorType.EMPTY);
            }
        }

        return buffer.toString();
    }

    /**
     * Build group-by restrictions clauses.
     * 
     * @param from
     *            from clause
     * @return the SQL representation of Group By statement.
     */
    public static String buildGroupBy(From from) {
        if (from.hasGroupBy()) {
            return new S(" {{groupBy}}").template(new Template().c("groupBy", from.getGroupBy())).toString();
        }
        return "";
    }

    /**
     * Build order by SQL clause.
     * 
     * @param orderBy
     *            order by clause.
     * @return the SQL representation of order by clause object.
     */
    public static String buildOrder(ListOrderBy orderBy) {
        StringBuilder buffer = new StringBuilder();

        buffer.append(SeparatorType.EMPTY);
        buffer.append(orderBy);

        return buffer.toString();
    }
}
