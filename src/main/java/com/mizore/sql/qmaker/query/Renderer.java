package com.mizore.sql.qmaker.query;

public interface Renderer<T> {

    String render(T value);

}
