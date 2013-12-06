package qmaker;

import java.util.ArrayList;
import java.util.List;

public class Query {

	private List<Field> fields;

	public Query() {
		fields = new ArrayList<Field>();
	}

	public Field select(String table, String field) {
		Field fieldOutput = new Field();

		fieldOutput.setTable(table, field);
		fields.add(fieldOutput);

		return fieldOutput;
	}

	public String asString() {
		StringBuffer buffer = new StringBuffer();

		List<Table> tableToJoin = new ArrayList<Table>();

		buffer.append(DataBaseConstants.SELECT);
		int dataFieldsCount = fields.size();
		for (Field field : fields) {
			buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
			buffer.append(field.getTable().getName());

			buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
			buffer.append(field.getName());
			buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
			buffer.append(DataBaseConstants.AS);
			buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
			buffer.append(field.as().getName());

			if (!tableToJoin.contains(field.getTable())) {
				tableToJoin.add(field.getTable());
			}

			dataFieldsCount -= 1;
			if (dataFieldsCount > 0) {
				buffer.append(DataBaseConstants.FIELD_SEPARATOR);
			}
		}

		buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
		buffer.append(DataBaseConstants.FROM);
		int tablesCount = tableToJoin.size();

		for (Table tables : tableToJoin) {
			buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
			if (tables.hasSchema()) {
				buffer.append(tables.getSchema());
				buffer.append(DataBaseConstants.DOT_SEPARATOR);
			}
			buffer.append(tables.getName());

			tablesCount -= 1;
			if (tablesCount > 0) {
				buffer.append(DataBaseConstants.FIELD_SEPARATOR);
			}

		}

		return buffer.toString();
	}
}
