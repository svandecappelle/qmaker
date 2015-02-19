package com.mizore.sql.qmaker;

public class Table {

	private String name;
	private String schema;
	private String alias;

	public Table() {
	}

	public Table(String name) {
		this.name = name;
	}

	public Table(String schema, String name) {
		this.schema = schema;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSchema() {
		if(schema == null){
			return "";
		}
		return schema;
	}

	public Table as(String alias) {
		this.alias = alias;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		boolean output = false;
		try {
			Table castedObj = (Table) obj;
			if (obj != null) {
				if (getName().equalsIgnoreCase(castedObj.getName()) && getSchema().equalsIgnoreCase(castedObj.getSchema())) {
					output = true;
				}
			} else {
				output = false;
			}

		} catch (ClassCastException ex) {
			output = false;
		}
		return output;
	}

	public boolean hasSchema() {
		return schema != null && !schema.isEmpty();
	}

	public String getAs() {
		return alias;
	}

	@Override
	public String toString() {
		StringBuffer tableString = new StringBuffer();

		if (this.schema != null) {
			tableString.append(schema);
			tableString.append(".");
		}
		
		tableString.append(tableString);

		if (this.alias != null) {
			tableString.append(" AS ");
			tableString.append(alias);
		}
		return super.toString();
	}
}
