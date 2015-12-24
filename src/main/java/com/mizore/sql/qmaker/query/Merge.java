package com.mizore.sql.qmaker.query;

import java.util.Iterator;

import com.mizore.sql.qmaker.filters.ExpressionType;
import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

public class Merge {

    public final static class Match extends Select {

        private static final long serialVersionUID = 89217678840720016L;
        private boolean autoAddSelectClausesIntoSaveState;

        public Match(boolean autoAddSelectClausesIntoSaveState) {
            this.autoAddSelectClausesIntoSaveState = autoAddSelectClausesIntoSaveState;
        }
    }

    private String mergeTable;
    private Match checkExistClause;
    private Update update;
    private Insert insert;
    private Delete delete;

    public Merge(String mergeTable, Match checkExistClause, Update update, Insert insert) {
        this.mergeTable = mergeTable;
        this.update = update;
        this.insert = insert;
        this.checkExistClause = checkExistClause;
        checkExistClause.as("MERGING");
    }

    public Merge(String mergeTable, Match checkExistClause, Update update, Delete delete, Insert insert) {
        this.mergeTable = mergeTable;
        this.update = update;
        this.insert = insert;
        this.delete = delete;
        this.checkExistClause = checkExistClause;
        checkExistClause.as("MERGING");
    }

    public Merge(String mergeTable, Match checkExistClause, Update update, Delete delete) {
        this.mergeTable = mergeTable;
        this.update = update;
        this.delete = delete;
        this.checkExistClause = checkExistClause;
        checkExistClause.as("MERGING");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(SqlClauses.MERGE);
        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.INTO);
        builder.append(SeparatorType.EMPTY);
        builder.append(mergeTable);

        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.USING);
        builder.append(SeparatorType.EMPTY);
        builder.append(checkExistClause);
        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.ON);
        builder.append(SeparatorType.EMPTY);

        Iterator<Field> it = checkExistClause.getFields().iterator();
        builder.append(SeparatorType.LEFT_PARENTHESIS);
        for (Field fieldsChecking : checkExistClause.getFields()) {
            it.next();

            builder.append(mergeTable);

            String columnName;
            if (fieldsChecking.hasAlias()) {
                columnName = fieldsChecking.getAlias().getName();
            } else {
                columnName = fieldsChecking.getName();
            }

            builder.append(SeparatorType.DOT);
            builder.append(columnName);

            builder.append(SeparatorType.EMPTY);
            builder.append(ExpressionType.EQUALS.toSql());
            builder.append(SeparatorType.EMPTY);

            builder.append("MERGING");
            builder.append(SeparatorType.DOT);
            builder.append(columnName);

            if (it.hasNext()) {
                builder.append(SeparatorType.EMPTY);
                builder.append(SeparatorType.AND);
                builder.append(SeparatorType.EMPTY);
            }

            if (insert != null && checkExistClause.autoAddSelectClausesIntoSaveState) {
                insert.set(new Field(new Table(mergeTable), columnName), new Field(new Table("MERGING"), columnName));
            }

        }
        builder.append(SeparatorType.RIGHT_PARENTHESIS);
        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.WHEN);
        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.MATCHED);
        builder.append(SeparatorType.EMPTY);
        builder.append(SqlClauses.THEN);
        builder.append(SeparatorType.EMPTY);
        // Update
        builder.append(update);

        if (delete != null) {
            builder.append(SeparatorType.EMPTY);
            builder.append(delete);
        }

        // -----------------------------------
        if (insert != null) {
            builder.append(SeparatorType.EMPTY);
            builder.append(SqlClauses.WHEN);
            builder.append(SeparatorType.EMPTY);
            builder.append(SqlClauses.NOT);
            builder.append(SeparatorType.EMPTY);
            builder.append(SqlClauses.MATCHED);
            builder.append(SeparatorType.EMPTY);
            builder.append(SqlClauses.THEN);
            builder.append(SeparatorType.EMPTY);
            builder.append(insert);
        }

        this.checkExistClause.autoAddSelectClausesIntoSaveState = false;

        return builder.toString();

    }
}
