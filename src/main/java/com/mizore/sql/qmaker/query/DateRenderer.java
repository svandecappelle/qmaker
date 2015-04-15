package com.mizore.sql.qmaker.query;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRenderer implements Renderer<Date> {

    private String sqlFormat;
    private SimpleDateFormat df;

    public DateRenderer(String sqlFormat, String javaFormat) {
        this.sqlFormat = sqlFormat;
        this.df = new SimpleDateFormat(javaFormat);
    }

    @Override
    public String render(Date value) {
        return "TO_DATE('".concat(sqlFormat).concat("', '").concat(df.format(value)).concat("')");
    }
}