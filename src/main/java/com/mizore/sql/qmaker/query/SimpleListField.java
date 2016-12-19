package com.mizore.sql.qmaker.query;

import java.util.ArrayList;
import java.util.Iterator;

import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

/**
 * @author svandecappelle
 * @since 0.0.1
 * 
 *        Simple and abstract list fields. List is representing one or more
 *        field separating by a separator type {@link SeparatorType}#FIELD. And
 *        prefixed by an {@link SqlClauses} type.
 *
 * @param <ME>
 *            the type of group.
 */
public abstract class SimpleListField<T> extends ArrayList<Field> implements SimpleListClause<T> {

    private static final long serialVersionUID = 5532586995371645166L;

    @Override
    public T and(String fieldName) {
        return this.and(null, null, fieldName);
    }

    @Override
    public T and(String tableName, String fieldName) {
        return this.and(null, tableName, fieldName);
    }

    @Override
    public T and(String schemaName, String tableName, String fieldName) {
        if (tableName != null) {
            this.add(new Field(new Table(schemaName, tableName), fieldName));
        } else {
            this.add(new Field(fieldName));
        }
        return this.getMe();
    }

    /**
     * Convert all groupBy into SQL String value clause.
     * 
     * @return
     */
    @Override
    public String toString() {
        StringBuilder groups = new StringBuilder();
        groups.append(getType());
        groups.append(SeparatorType.EMPTY);

        Iterator<Field> groupsIterator = this.iterator();
        for (Field fieldGroupBy : this) {
            groupsIterator.next();

            groups.append(fieldGroupBy.toString());

            if (groupsIterator.hasNext()) {
                groups.append(SeparatorType.FIELD);
                groups.append(SeparatorType.EMPTY);
            }
        }

        return groups.toString();
    }

    protected abstract SqlClauses getType();
}
