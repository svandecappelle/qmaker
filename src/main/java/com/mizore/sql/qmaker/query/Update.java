package com.mizore.sql.qmaker.query;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

@SuppressWarnings("rawtypes")
public class Update extends HasSqlRestrictions<Update>implements IsClause {

    private static final long serialVersionUID = 5081946217393043093L;

    private Table table;

    private final Map<Field, Object> values;
    private final Map<Field, Renderer> renderers;

    public Update(){
        this.values = new LinkedHashMap<Field, Object>();
        this.renderers = new HashMap<Field, Renderer>();
    }
    
    public Update(Table table) {
        this();
        this.table = table;
    }

    public Update(String table) {
        this(new Table(table));
    }

    public Update(String schema, String table) {
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
    protected Update getClause() {
        return this;
    }

    @SuppressWarnings("unchecked")
    public String asString() {
        StringBuilder builder = new StringBuilder();
        builder.append(SqlClauses.UPDATE);
        builder.append(SeparatorType.EMPTY);
        
        if (table !=null ){
            builder.append(this.table);
            builder.append(SeparatorType.EMPTY);
                
        }
        builder.append(SqlClauses.SET);
        builder.append(SeparatorType.EMPTY);
        
        Iterator<Field> it = this.values.keySet().iterator();
        for (Entry<Field, Object> value : this.values.entrySet()) {
            it.next();

            builder.append(value.getKey());
            builder.append(SeparatorType.EMPTY);
            builder.append(ExpressionType.EQUALS.toSql());
            builder.append(SeparatorType.EMPTY);
            
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

        builder.append(QueryFactory.buildWhere(getRestrictions()));

        return builder.toString();
    }

    @Override
    public String toString() {
        return asString();
    }

}
