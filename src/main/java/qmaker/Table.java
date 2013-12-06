package qmaker;

public class Table {

	private String name;
	private String schema;

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
		return schema;
	}

	@Override
	public boolean equals(Object obj) {
		boolean output = false;
		try {
			Table castedObj = (Table) obj;
			if (obj != null) {
				if (getName().equalsIgnoreCase(castedObj.getName())
						&& getSchema().equalsIgnoreCase(castedObj.getSchema())) {
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
}
