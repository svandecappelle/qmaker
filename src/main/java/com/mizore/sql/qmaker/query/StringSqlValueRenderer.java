package com.mizore.sql.qmaker.query;

public class StringSqlValueRenderer implements Renderer<Object> {

    @Override
    public String render(Object value) {
        return value != null ? value.toString() : "NULL";
    }

}
