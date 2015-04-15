package com.mizore.sql.qmaker.query;

import java.io.Serializable;

import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.utils.SeparatorType;

/**
 * @author svandecappelle
 * @since 2.0.0
 */
public class Set implements Serializable {

    private static final long serialVersionUID = 6128065599244403572L;

    private Update update;
    private Field field;
    private Field fieldTo;

    public Set(Update update, Field field) {
        this.update = update;
        this.field = field;
    }

    public <T> Set to(T fieldTo) {
        StringBuilder valueString = new StringBuilder();
        if (fieldTo instanceof String) {
            valueString.append(SeparatorType.QUOTE);
            valueString.append(fieldTo);
            valueString.append(SeparatorType.QUOTE);
        } else {
            valueString.append(fieldTo);
        }
        return this.to(new Field(valueString.toString()));
    }

    public <T> Set to(Field fieldTo) {
        this.fieldTo = fieldTo;
        return this;
    }

    public Set and(String field) {
        return this.update.set(field);
    }

    public Set and(Field field) {
        return this.update.set(field);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.field);
        builder.append(SeparatorType.EMPTY);
        builder.append(ExpressionType.EQUALS.toSql());
        builder.append(SeparatorType.EMPTY);
        builder.append(this.fieldTo);
        return builder.toString();
    }
}
