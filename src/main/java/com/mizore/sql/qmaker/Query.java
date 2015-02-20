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
		Field fieldOutput = new Field(new Table(table), field);
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
			buffer.append(field.toString());

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
