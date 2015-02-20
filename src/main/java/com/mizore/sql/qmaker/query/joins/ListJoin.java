package com.mizore.sql.qmaker.query.joins;

import java.util.ArrayList;

import com.mizore.sql.qmaker.query.Join;

public class ListJoin<T extends Join> extends ArrayList<T> {

    /**
	 * 
	 */
    private static final long serialVersionUID = 6827422563337254770L;

    public ListJoin() {
    }

    public String join(String string) {
        StringBuffer joins = new StringBuffer();
        for (Join joinElement : this) {
            joins.append(joinElement.toString());
        }

        return joins.toString();
    }

}
