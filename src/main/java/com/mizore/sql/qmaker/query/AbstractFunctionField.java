package com.mizore.sql.qmaker.query;

import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

public abstract class AbstractFunctionField extends Field {

    public AbstractFunctionField(String fieldName) {
        super(fieldName);
    }

    public AbstractFunctionField(String table, String fieldName) {
        super(new Table(table), fieldName);
    }

    public AbstractFunctionField(String schema, String table, String fieldName) {
        super(new Table(schema, table), fieldName);
    }

    public AbstractFunctionField(Field fieldObject) {
        this(fieldObject.toString());
    }

    public abstract SQLFieldClause getType();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(getType());
        builder.append(SeparatorType.LEFT_PARENTHESIS);

        if (getTable() != null) {
            builder.append(getTable().toString());
            builder.append(SeparatorType.DOT);
        }

        builder.append(getName());
        builder.append(SeparatorType.RIGHT_PARENTHESIS);

        if (getAlias() != null) {
            builder.append(SeparatorType.EMPTY);
            builder.append(SqlClauses.AS);
            builder.append(SeparatorType.EMPTY);
            builder.append(getAlias().getName());
        }

        return builder.toString();
    }
}
