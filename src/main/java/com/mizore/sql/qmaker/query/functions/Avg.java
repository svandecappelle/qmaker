package com.mizore.sql.qmaker.query.functions;

import com.mizore.sql.qmaker.query.AbstractFunctionField;
import com.mizore.sql.qmaker.query.SQLFieldClause;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Avg field function clause.
 */
public class Avg extends AbstractFunctionField {

    /**
     * Constructor Avg function selector.
     * 
     * @param fieldName
     *            fieldname.
     */
    public Avg(String fieldName) {
        super(fieldName);
    }

    /**
     * Constructor Avg function selector.
     * 
     * @param table
     *            table.
     * 
     * @param fieldName
     *            fieldname.
     */
    public Avg(String table, String fieldName) {
        super(table, fieldName);
    }

    /**
     * Constructor Avg function selector.
     * 
     * @param schema
     *            SQL schema.
     * @param table
     *            table.
     * @param fieldName
     *            fieldname.
     */
    public Avg(String schema, String table, String fieldName) {
        super(schema, table, fieldName);
    }

    @Override
    public SQLFieldClause getType() {
        return SQLFieldClause.AVG;
    }

}
