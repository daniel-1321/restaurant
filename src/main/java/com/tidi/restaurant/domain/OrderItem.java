package com.tidi.restaurant.domain;

import com.tidi.restaurant.numberFormat.NumberFormat;

/**
 * @author HO_TRONG_DAI
 * @date Nov 1, 2019
 * @tag 
 */
public class OrderItem {
	private String foodName;
	private double foodPrice;
	private int quantity;
	private double total;
	public OrderItem(String foodName, double foodPrice, int quantity, double total) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.quantity = quantity;
		this.total = total;
	}
	public OrderItem() {
		super();
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "OrderItem [foodName=" + foodName + ", foodPrice=" + NumberFormat.formatNumber(foodPrice) + ", quantity=" + quantity + ", total="
				+ NumberFormat.formatNumber(total) + "]";
	}

}
