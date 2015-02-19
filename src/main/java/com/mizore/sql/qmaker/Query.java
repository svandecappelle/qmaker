package com.mizore.sql.qmaker;

import java.util.ArrayList;
import java.util.List;

public class Query {

	private List<Field> fields;
	private From from;

	public Query() {
		fields = new ArrayList<Field>();
	}

	public Field select(String table, String field) {
		Field fieldOutput = new Field();

		fieldOutput.setTable(table, field);
		fields.add(fieldOutput);

		return fieldOutput;
	}

	public From from(String table) {
		this.from = new From(table);
		return from;
	}

	public String asString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(DataBaseConstants.SELECT);
		int dataFieldsCount = fields.size();
		for (Field field : fields) {
			buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
			buffer.append(field.getTable().getName());
			buffer.append(DataBaseConstants.DOT_SEPARATOR);
			buffer.append(field.getName());

			if (field.getAlias() != null) {
				buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
				buffer.append(DataBaseConstants.AS);
				buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
				buffer.append(field.getAlias().getName());
			}

			dataFieldsCount -= 1;
			if (dataFieldsCount > 0) {
				buffer.append(DataBaseConstants.FIELD_SEPARATOR);
			}
		}

		buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
		buffer.append(DataBaseConstants.FROM);
		buffer.append(DataBaseConstants.EMPTY_SEPARATOR);
		buffer.append(from.toString());

		return buffer.toString();
	}
}
