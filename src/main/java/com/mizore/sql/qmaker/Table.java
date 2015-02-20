package com.mizore.sql.qmaker;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Table SQL.
 */
public class Table {

	// Table field name.
	private String name;

	// Schema name.
	private String schema;

	// Table alias.
	private String alias;

	/**
	 * Constructor table.
	 */
	public Table() {
	}

	/**
	 * Table constructor with name.
	 * 
	 * @param name
	 *            table name.
	 */
	public Table(String name) {
		this.name = name;
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
		if (schema == null) {
			return "";
		}
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
		StringBuffer tableString = new StringBuffer();

		if (this.schema != null) {
			tableString.append(schema);
			tableString.append(DataBaseConstants.DOT_SEPARATOR);
		}

		tableString.append(name);

		return tableString.toString();
	}
}
