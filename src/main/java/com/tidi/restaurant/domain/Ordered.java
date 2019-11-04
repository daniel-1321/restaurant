package com.tidi.restaurant.domain;

import java.util.*;

import com.tidi.restaurant.numberFormat.NumberFormat;

/**
 * @author HO_TRONG_DAI
 * @date Oct 30, 2019
 * @tag 
 */
public class Ordered {
	private int ord_id;
	private int ord_table;
	private String ord_date;
	private int ord_time;
	private double ord_total;
	private List<OrderItem> orderItem;
	public Ordered(int ord_id, int ord_table, String ord_date, int ord_time,List<OrderItem> orderItem) {
		super();
		this.ord_id = ord_id;
		this.ord_table = ord_table;
		this.ord_date = ord_date;
		this.ord_time = ord_time;
		this.ord_total = calculateSum(orderItem);
		this.orderItem = orderItem;
	}
	public Ordered() {
		super();
	}
	
	private double calculateSum(List<OrderItem> orderItem) {
		for (int i = 0; i < orderItem.size(); i++) {
			this.ord_total+= orderItem.get(i).getTotal();
		}
		return this.ord_total;
	}
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public int getOrd_table() {
		return ord_table;
	}
	public void setOrd_table(int ord_table) {
		this.ord_table = ord_table;
	}
	public String getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(String ord_date) {
		this.ord_date = ord_date;
	}
	public int getOrd_time() {
		return ord_time;
	}
	public void setOrd_time(int ord_time) {
		this.ord_time = ord_time;
	}
	public double getOrd_total() {
		return ord_total;
	}
	public void setOrd_total(double ord_total) {
		this.ord_total = ord_total;
	}

	
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	@Override
	public String toString() {
		return "Ordered [ord_id=" + ord_id + ", ord_table=" + ord_table + ", ord_date=" + ord_date + ", ord_time="
				+ ord_time + ", ord_total=" + NumberFormat.formatNumber(ord_total) + ", orderItem=" + orderItem + "]";
	}
	
	
	
	
	
	
}
