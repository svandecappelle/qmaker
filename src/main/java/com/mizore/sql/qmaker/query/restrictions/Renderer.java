package com.mizore.sql.qmaker.query.restrictions;

public interface Renderer<T> {

    String render(T value);

}
