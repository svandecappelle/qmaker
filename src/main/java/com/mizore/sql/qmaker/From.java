package com.mizore.sql.qmaker;

import java.util.ArrayList;
import java.util.List;

public class From {
	private Table table;
	private ListJoin<Join> joins;

	private boolean query = false;
	private String alias;
	
	public From(String table){
		this.table = new Table(table);
		this.joins = new ListJoin<Join>();
	}
	
	public From(Query query){
		this(query.asString());
		this.query = true;
	}
	
	public boolean isQuery() {
		return query;
	}

	public From as(String alias){
		this.alias = alias;
		return this;
	}

	public Join innerJoin(String table){
		InnerJoin innerJoin = new InnerJoin(table);
		this.joins.add(innerJoin);
		return innerJoin;
	}

	public Join leftJoin(String table){
		LeftJoin innerJoin = new LeftJoin(table);
		this.joins.add(innerJoin);
		return innerJoin;
	}

	public Join rightJoin(String table){
		RightJoin innerJoin = new RightJoin(table);
		this.joins.add(innerJoin);
		return innerJoin;
	}


	public String toString(){
		S buildedString = null;
		if (this.isQuery()){
			if (this.joins != null){
				buildedString = new S(" FROM ({{table}}) {{alias}} {{joins}}").template(new Template().c("table", this.table).c("alias", this.table.getAs()).c("joins", this.joins.join("")));
			}else{
				buildedString = new S(" FROM ({{table}}) {{alias}}").template(new Template().c("table", this.table).c("alias", this.table.getAs()));
			}
		}else{
			if(this.alias != null){
				if (this.joins != null){
					buildedString = new S(" FROM ({{table}}) {{alias}} {{joins}}").template(new Template().c("table", this.table).c("alias", this.alias).c("joins", this.joins.join("")));
				}else{
					buildedString = new S(" FROM ({{table}}) {{alias}} ").template(new Template().c("table", this.table).c("alias", this.alias));
				}
			}else{
				if (this.joins != null){
					buildedString = new S(" FROM {{table}} {{joins}}").template(new Template().c("table", this.table).c("joins", this.joins.join("")));
				}else{
					buildedString = new S(" FROM {{table}} ").template(new Template().c("table", this.table));
				}
			}
		}
		return buildedString.toString();
	}
}
