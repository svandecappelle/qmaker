package com.mizore.sql.qmaker.query.functions;

import com.mizore.sql.qmaker.query.AbstractFunctionField;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Min field function clause.
 */
public class Min extends AbstractFunctionField {

    /**
     * Constructor min function selector.
     * 
     * @param fieldName
     *            fieldname.
     */
    public Min(String fieldName) {
        super(fieldName);
    }

    /**
     * Constructor min function selector.
     * 
     * @param table
     *            table.
     * 
     * @param fieldName
     *            fieldname.
     */
    public Min(String table, String fieldName) {
        super(table, fieldName);
    }

    /**
     * Constructor min function selector.
     * 
     * @param schema
     *            SQL schema.
     * @param table
     *            table.
     * @param fieldName
     *            fieldname.
     */
    public Min(String schema, String table, String fieldName) {
        super(schema, table, fieldName);
    }

    @Override
    public SQLFunctionsClause getType() {
        return SQLFunctionsClause.MIN;
    }

}
