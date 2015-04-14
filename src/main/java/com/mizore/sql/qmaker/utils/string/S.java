package com.mizore.sql.qmaker.utils.string;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 * 
 *        String replacement tool using templates.
 */
public class S implements Serializable {

    private static final long serialVersionUID = 3411204568827409780L;

    // Templates replacement.
    private ArrayList<Template> templates;

    // String source to replace templates value.
    private String src;

    /**
     * Define replacement.
     * 
     * @param src
     *            the String source to replace templates value.
     */
    public S(String src) {
        this.src = src;
        this.templates = new ArrayList<Template>();
    }

    /**
     * Define a template to replace with.
     * 
     * @param template
     *            the template to replace.
     * @return the {@link S} clause.
     */
    public S template(Template template) {
        this.templates.add(template);
        return this;
    }

    @Override
    public String toString() {
        String dest = new String(src);
        for (Template template : templates) {
            for (Subsitute substitute : template.getSubstitutes()) {
                dest = dest.replace(substitute.getReplacementPattern(), substitute.getValue());
            }
        }
        return dest;
    }
}
