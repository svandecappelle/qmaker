package com.mizore.sql.qmaker.string;

import java.util.ArrayList;
import java.util.List;

public class Template {

    private List<Subsitute> substitutes;

    public Template() {
        substitutes = new ArrayList<Subsitute>();
    }

    public Template c(String constant, Object value) {
        this.substitutes.add(new SubstituteConstant(constant).with(value.toString()));
        return this;
    }

    public List<Subsitute> getSubstitutes() {
        return substitutes;
    }
}
