package com.mizore.sql.qmaker.query;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

// Suppress warning for renderer.
@SuppressWarnings("rawtypes")
public class Insert {

    private Table table;

    private final Map<Field, Object> values;
    private final Map<Field, Renderer> renderers;

    public Insert(Table table) {
        this.table = table;
        this.values = new LinkedHashMap<Field, Object>();
        this.renderers = new HashMap<Field, Renderer>();
    }

    public Insert(String table) {
        this(new Table(table));
    }

    public Insert(String schema, String table) {
        this(new Table(schema, table));
    }

    public <T> void set(String field, T object, Renderer<T> renderer) {
        Field fieldObject = new Field(field);
        this.set(fieldObject, object, renderer);
    }

    public <T> void set(Field field, T object, Renderer<T> renderer) {
        this.values.put(field, object);
        this.setRenderer(field, renderer);
    }

    private <T> void setRenderer(Field field, Renderer<T> renderer) {
        this.renderers.put(field, renderer);
    }

    public <T> void set(Field field, T value) {
        if (value instanceof String) {
            StringBuilder valueString = new StringBuilder();
            valueString.append(SeparatorType.QUOTE);
            valueString.append(value);
            valueString.append(SeparatorType.QUOTE);
            this.values.put(field, valueString);
        } else {
            this.values.put(field, value);
        }
    }

    public <T> void set(String field, T value) {
        this.set(new Field(field), value);
    }

    @Override
    public String toString() {
        return this.asString();
    }

    @SuppressWarnings("unchecked")
    public String asString() {
        StringBuilder builder = new StringBuilder();
        builder.append(SqlClauses.INSERT);
        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.INTO);
        builder.append(SeparatorType.EMPTY);
        builder.append(table);
        builder.append(SeparatorType.EMPTY);

        builder.append(SeparatorType.LEFT_PARENTHESIS);
        Iterator<Entry<Field, Object>> it = this.values.entrySet().iterator();
        for (Entry<Field, Object> value : this.values.entrySet()) {
            it.next();

            builder.append(value.getKey());

            if (it.hasNext()) {
                builder.append(SeparatorType.FIELD);
                builder.append(SeparatorType.EMPTY);
            } else {

            }

        }
        builder.append(SeparatorType.RIGHT_PARENTHESIS);

        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.VALUES);
        builder.append(SeparatorType.EMPTY);

        builder.append(SeparatorType.LEFT_PARENTHESIS);
        it = this.values.entrySet().iterator();
        for (Entry<Field, Object> value : this.values.entrySet()) {
            it.next();
            if (this.renderers.containsKey(value.getKey())) {
                builder.append(this.renderers.get(value.getKey()).render(value.getValue()));
            } else {
                builder.append(value.getValue());
            }

            if (it.hasNext()) {
                builder.append(SeparatorType.FIELD);
                builder.append(SeparatorType.EMPTY);
            }

        }
        builder.append(SeparatorType.RIGHT_PARENTHESIS);
        return builder.toString();
    }
}
