package qmaker;

public class Field {

	private Table dataBaseTable;
	private String name;

	private As as;

	public As as() {
		if (as == null) {
			this.as = new As(name);
		}
		return this.as;
	}

	public void setTable(String table, String field) {
		dataBaseTable = new Table(table);
		this.name = field;
	}

	public String getName() {
		return this.name;
	}

	public Table getTable() {
		return dataBaseTable;
	}
}
