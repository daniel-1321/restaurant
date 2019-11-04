package com.tidi.restaurant.domain;
/**
 * @author HO_TRONG_DAI
 * @date Oct 30, 2019
 * @tag 
 */
public class Table {
	private int table_id;
	private String table_name;
	private String table_type;
	public Table(int table_id, String table_name, String table_type) {
		super();
		this.table_id = table_id;
		this.table_name = table_name;
		this.table_type = table_type;
	}
	public Table() {
		super();
	}
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getTable_type() {
		return table_type;
	}
	public void setTable_type(String table_type) {
		this.table_type = table_type;
	}
	@Override
	public String toString() {
		return "Table [table_id=" + table_id + ", table_name=" + table_name + ", table_type=" + table_type + "]";
	}
	
	
}
