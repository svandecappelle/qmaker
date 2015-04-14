package com.mizore.sql.qmaker.query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

public class Update extends HasSqlRestrictions<Update> implements IsClause {

    private Table table;

    private List<Set> sets;

    public Update(String table) {
        this.table = new Table(table);
    }

    public Update(String schema, String table) {
        this.table = new Table(schema, table);
    }

    public Set set(String field) {
        return this.set(new Field(field));
    }

    public Set set(Field field) {
        if (this.sets == null) {
            this.sets = new ArrayList<Set>();
        }
        Set set = new Set(this, field);
        this.sets.add(set);
        return set;
    }

    @Override
    protected Update getClause() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(SqlClauses.UPDATE);
        builder.append(SeparatorType.EMPTY);
        builder.append(this.table);
        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.SET);
        builder.append(SeparatorType.EMPTY);
        Iterator<Set> it = this.sets.iterator();
        for (Set set : this.sets) {
            it.next();
            builder.append(set);

            if (it.hasNext()) {
                builder.append(SeparatorType.FIELD);
                builder.append(SeparatorType.EMPTY);
            }
        }

        builder.append(QueryFactory.buildWhere(getRestrictions()));

        return builder.toString();
    }

    public String asString() {
        return toString();
    }

}
