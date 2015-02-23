package com.mizore.sql.qmaker.utils;

import java.util.Collection;

import com.mizore.sql.qmaker.query.Field;
import com.mizore.sql.qmaker.query.From;
import com.mizore.sql.qmaker.query.SqlRestriction;

public final class QueryFactory {

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

    public static String buildFrom(From fromClause) {
        StringBuilder buffer = new StringBuilder();

        buffer.append(SqlClauses.FROM);
        buffer.append(SeparatorType.EMPTY);
        buffer.append(fromClause);

        return buffer.toString();
    }

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
