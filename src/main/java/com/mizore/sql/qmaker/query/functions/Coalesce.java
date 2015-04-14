package com.mizore.sql.qmaker.query.functions;

import com.mizore.sql.qmaker.query.Field;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Coalesce field function clause.
 */
public class Coalesce extends AbstractFunctionField {

    private static final long serialVersionUID = 4373089601696548391L;

    /**
     * Constructor Coalesce function selector.
     * 
     * @param field
     *            fieldObject.
     */
    public Coalesce(Field fieldObject) {
        super(fieldObject);
    }

    /**
     * Constructor Coalesce function selector.
     * 
     * @param fieldName
     *            fieldname.
     */
    public Coalesce(String fieldName) {
        super(fieldName);
    }

    /**
     * Constructor Coalesce function selector.
     * 
     * @param table
     *            table.
     * 
     * @param fieldName
     *            fieldname.
     */
    public Coalesce(String table, String fieldName) {
        super(table, fieldName);
    }

    /**
     * Constructor Coalesce function selector.
     * 
     * @param schema
     *            SQL schema.
     * @param table
     *            table.
     * @param fieldName
     *            fieldname.
     */
    public Coalesce(String schema, String table, String fieldName) {
        super(schema, table, fieldName);
    }

    @Override
    public SQLFunctionsClause getType() {
        return SQLFunctionsClause.COALESCE;
    }

}
