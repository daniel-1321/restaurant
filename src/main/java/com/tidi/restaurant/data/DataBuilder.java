package com.tidi.restaurant.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import com.tidi.restaurant.domain.Food;
import com.tidi.restaurant.domain.OrderItem;
import com.tidi.restaurant.domain.Ordered;
import com.tidi.restaurant.domain.Table;

/**
 * @author HO_TRONG_DAI
 * @date Nov 1, 2019
 * @tag 
 */
public class DataBuilder {
	//Build random food list
	public static List<Food> buildRandomFoods(){
		final List<Food> foods = new ArrayList<Food>();
		for (int i = 0; i < 30; i++) {
			final Food food = new Food(
					i+1,
					RandomStringUtils.randomAlphanumeric(5),
					RandomUtils.nextDouble(0, 500));
			foods.add(food);
		}
		return foods;	
	}
	
	//Build random table list
	public static List<Table> buildRandomTables(){
		final List<Table> tables = new ArrayList<Table>();
		for (int i = 0; i < 50; i++) {
			final Table table = new Table(
					i+1,
					RandomStringUtils.randomAlphanumeric(1),
					RandomStringUtils.randomAlphanumeric(2));
			tables.add(table);
		}
		return tables;	
	}
	
	//Build Random order item list
		public static List<OrderItem> builRandomItems(List<Food> food){
			final List<OrderItem> items = new ArrayList<>();
			for (int i = 0; i < 10000; i++) {
				int random = RandomUtils.nextInt(1,10);
				int randomFood = RandomUtils.nextInt(0,9);
				final OrderItem item = new OrderItem(
						food.get(randomFood).getFood_name(),
						food.get(randomFood).getFood_price(),
						random,
						food.get(randomFood).getFood_price()*random);
				items.add(item);
			}
			return items;
		}
		
	//Build random order list
	static LocalDate date = LocalDate.now();
	static DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static List<Ordered> buildRandomOrders(List<OrderItem> item){
		final List<Ordered> orders = new ArrayList<Ordered>();
		for (int i = 0; i < 2000; i++) {
			final Ordered order = new Ordered(
					i+1,
					RandomUtils.nextInt(1,15),
					date.format(currentDate),
					RandomUtils.nextInt(8, 21),
					buildAmountItem(item));
			orders.add(order);
		}
		return orders;	
	}
	//Build random amount of item in order
	public static List<OrderItem> buildAmountItem(List<OrderItem> item){
		final List<OrderItem> itemList = new ArrayList<>();
		int randomLoop = RandomUtils.nextInt(1,5);
		for (int i = 0; i < randomLoop; i++) {
			int randomItem = RandomUtils.nextInt(0,9999);
			itemList.add(item.get(randomItem));
		}
		return itemList;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
