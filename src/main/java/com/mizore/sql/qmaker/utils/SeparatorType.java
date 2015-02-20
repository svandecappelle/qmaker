package com.mizore.sql.qmaker.utils;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        Separator SQL type.
 */
public enum SeparatorType {
    EMPTY(" "), FIELD(","), DOT(".");

    private String sqlSeparator;

    /**
     * Constructor separator type.
     * 
     * @param sqlSeparator
     *            the separator SQL string replacement.
     */
    private SeparatorType(String sqlSeparator) {
        this.sqlSeparator = sqlSeparator;
    }

    @Override
    public String toString() {
        return sqlSeparator;
    }
}
