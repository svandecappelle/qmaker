package com.mizore.sql.qmaker.query;

import java.util.Collection;

import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Query string factory builder.
 */
public final class QueryFactory {

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
    public static String buildWhere(Collection<SqlRestriction> whereClauses) {
        StringBuilder buffer = new StringBuilder();

        if (!whereClauses.isEmpty()) {
            buffer.append(SeparatorType.EMPTY);
            buffer.append(SqlClauses.WHERE);
            buffer.append(SeparatorType.EMPTY);
        }

        int restrictionsCount = whereClauses.size();
        for (SqlRestriction restriction : whereClauses) {
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
}
