package com.mizore.sql.qmaker.query.functions;

import com.mizore.sql.qmaker.query.Field;
import com.mizore.sql.qmaker.query.Table;
import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Apply abstract SQL function to a field.
 */
public abstract class AbstractFunctionField extends Field {

    /**
     * Add a SQL function on a simple field.
     * 
     * @param fieldName
     *            field.
     */
    public AbstractFunctionField(String fieldName) {
        super(fieldName);
    }

    /**
     * Add a SQL function on a simple table.field.
     * 
     * @param table
     *            table.
     * @param fieldName
     *            field.
     */
    public AbstractFunctionField(String table, String fieldName) {
        super(new Table(table), fieldName);
    }

    /**
     * Add a SQL function on a simple schema.table.field.
     * 
     * @param schema
     *            SQL schema.
     * @param table
     *            table.
     * @param fieldName
     *            field.
     */
    public AbstractFunctionField(String schema, String table, String fieldName) {
        super(new Table(schema, table), fieldName);
    }

    /**
     * Add a SQL function on an existing generated field.
     * 
     * @param fieldObject
     *            field.
     */
    public AbstractFunctionField(Field fieldObject) {
        this(fieldObject.toString());
    }

    /**
     * Get the function type.
     * 
     * @return the field function clause type.
     */
    public abstract SQLFunctionsClause getType();

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
