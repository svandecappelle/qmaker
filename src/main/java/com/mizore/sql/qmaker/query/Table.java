package com.mizore.sql.qmaker.query;

import java.io.Serializable;

import com.mizore.sql.qmaker.utils.SeparatorType;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Table SQL.
 */
public class Table implements Serializable{

    private static final long serialVersionUID = -4617924929919373369L;

    // Table field name.
    private String name;

    // Schema name.
    private String schema;

    // Table alias.
    private String alias;

    /**
     * Table constructor with name.
     * 
     * @param name
     *            table name.
     */
    public Table(String name) {
        this(null, name);
    }

    /**
     * Table constructor with schema name and table name.
     * 
     * @param schema
     *            Schema name.
     * @param name
     *            Table name.
     */
    public Table(String schema, String name) {
        this.schema = schema;
        this.name = name;
    }

    /**
     * Get table name.
     * 
     * @return table name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get schema name.
     * 
     * @return schema name.
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Insert alias to table.
     * 
     * @param alias
     *            alias name.
     * @return the alias name.
     */
    public Table as(String alias) {
        this.alias = alias;
        return this;
    }

    /**
     * Return <code>true</code> if schema name is defined.
     * 
     * @return
     */
    public boolean hasSchema() {
        return schema != null && !schema.isEmpty();
    }

    /**
     * Return alias.
     * 
     * @return the alias of table.
     */
    public String getAs() {
        return alias;
    }

    @Override
    public String toString() {
        StringBuilder tableString = new StringBuilder();

        if (this.hasSchema()) {
            tableString.append(getSchema());
            tableString.append(SeparatorType.DOT);
        }
        if (this.getAs() != null) {
            tableString.append(SeparatorType.LEFT_PARENTHESIS);
        }
        tableString.append(getName());

        if (this.getAs() != null) {
            tableString.append(SeparatorType.RIGHT_PARENTHESIS);
            tableString.append(SeparatorType.EMPTY);
            tableString.append(getAs());
        }

        return tableString.toString();
    }
}
