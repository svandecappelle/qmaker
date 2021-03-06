package com.mizore.sql.qmaker.query.functions;


/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Max field function clause.
 */
public class Max extends AbstractFunctionField {

    private static final long serialVersionUID = -3600124746011341967L;

    /**
     * Constructor Max function selector.
     * 
     * @param fieldName
     *            fieldname.
     */
    public Max(String fieldName) {
        super(fieldName);
    }

    /**
     * Constructor Max function selector.
     * 
     * @param table
     *            table.
     * 
     * @param fieldName
     *            fieldname.
     */
    public Max(String table, String fieldName) {
        super(table, fieldName);
    }

    /**
     * Constructor Max function selector.
     * 
     * @param schema
     *            SQL schema.
     * @param table
     *            table.
     * @param fieldName
     *            fieldname.
     */
    public Max(String schema, String table, String fieldName) {
        super(schema, table, fieldName);
    }

    @Override
    public SQLFunctionsClause getType() {
        return SQLFunctionsClause.MAX;
    }

}
