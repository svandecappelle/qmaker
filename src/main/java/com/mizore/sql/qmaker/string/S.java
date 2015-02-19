package com.mizore.sql.qmaker.string;

import java.util.List;

public class S {

	private List<Template> templates;
	private String src;

	public S(String src) {
		this.src = src;
	}

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
