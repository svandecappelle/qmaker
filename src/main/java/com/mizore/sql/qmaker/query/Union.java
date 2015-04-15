package com.mizore.sql.qmaker.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mizore.sql.qmaker.utils.SeparatorType;
import com.mizore.sql.qmaker.utils.SqlClauses;

public class Union implements Serializable {

    private static final long serialVersionUID = -4823866748493050883L;

    private List<Query> queriesList;
    private Map<Integer, Boolean> queriesUnionType;

    public Union(Query leftSide, Query rigthSide) {
        this(leftSide, rigthSide, false);
    }

    public Union(Query leftSide, Query rigthSide, boolean allowDuplicateValues) {
        this.queriesUnionType = new HashMap<Integer, Boolean>();
        this.queriesList = new ArrayList<Query>();
        this.addUnion(leftSide, allowDuplicateValues);
        this.addUnion(rigthSide, allowDuplicateValues);
    }

    public void union(Query unionQuery) {
        this.addUnion(unionQuery, false);
    }

    public void unionAll(Query unionQuery) {
        this.addUnion(unionQuery, true);
    }

    private void addUnion(Query query, boolean type) {
        this.queriesList.add(query);
        this.queriesUnionType.put(this.queriesList.lastIndexOf(query), type);
    }

    private boolean isAll(Integer queryId) {
        return this.queriesUnionType.get(queryId);
    }

    @Override
    public String toString() {
        return asString();
    }

    public String asString() {
        StringBuilder builder = new StringBuilder();

        boolean first = true;

        int idQuery = 0;

        for (Query query : queriesList) {

            if (!first) {
                builder.append(SeparatorType.EMPTY);
                if (isAll(idQuery)) {
                    builder.append(SqlClauses.UNION);
                    builder.append(SeparatorType.EMPTY);
                    builder.append(SqlClauses.ALL);
                } else {
                    builder.append(SqlClauses.UNION);
                }
                builder.append(SeparatorType.EMPTY);
            } else {
                first = !first;
            }

            builder.append(query);

            idQuery += 1;
        }

        return builder.toString();
    }
}
