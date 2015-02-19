package com.mizore.sql.qmaker;

public class SubstituteConstant implements Subsitute {

	private String constant;
	private String value;

	public SubstituteConstant(String constant) {
		this.constant = constant;
	}

	public SubstituteConstant with(String value) {
		this.value = value;
		return this;
	}

	public String getValue() {
		return value;
	}

	public String getReplacementPattern() {
		return constant;
	}

}
