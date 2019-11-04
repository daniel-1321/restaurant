package com.tidi.restaurant;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.tidi.restaurant.data.DataBuilder;
import com.tidi.restaurant.domain.Food;
import com.tidi.restaurant.domain.OrderItem;
import com.tidi.restaurant.domain.Ordered;
import com.tidi.restaurant.domain.Table;
import com.tidi.restaurant.numberFormat.NumberFormat;

/**
 * Hello world!
 *
 */
public class App {
	final static List<Food> foodList;
	final static List<Table> tableList;
	final static List<Ordered> orderList;
	final static List<OrderItem> itemList;
	static {
		foodList = DataBuilder.buildRandomFoods();
		tableList = DataBuilder.buildRandomTables();
		itemList = DataBuilder.builRandomItems(foodList);
		orderList = DataBuilder.buildRandomOrders(itemList);
		
		
	}
	static LocalDate date = LocalDate.now();
	static DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static double sum = 0;
	public static void main(String[] args) {
		showIncomeByHour(orderList);
		getTotalIncome(orderList);
	}
	
	
	//Show total income in day
	public static void getTotalIncome(List<Ordered> orderList) {
		sum = orderList.stream().map(Ordered::getOrd_total).collect(Collectors.summingDouble(i->i));
		System.out.println("Total income (" + date.format(currentDate) + ") : " + NumberFormat.formatNumber(sum));
	}
	

	private static void showFoodQuantityByHour(final List<Ordered> ordered) {
//		Map<Integer, List<OrderItem>> foodListByHour = ordered.stream().collect(Collectors.groupingBy(Ordered::getOrd_time, Collectors.(Ordered::getOrderItem));
	}
	
	
	
	//Show income by hour
	private static void showIncomeByHour(final List<Ordered> ordered) {
		Map<Integer, Double> incomeListByHour = ordered.stream().collect(Collectors.groupingBy(Ordered::getOrd_time, Collectors.summingDouble(Ordered::getOrd_total)));
		incomeListByHour.entrySet().stream().forEach(hour -> System.out.println(hour.getKey() + "h - " + NumberFormat.formatNumber(hour.getValue())));
		Entry<Integer, Double> maxValue = incomeListByHour.entrySet().stream()
		  .max(Map.Entry.comparingByValue()).get();
		
		
		//Show which hour has a max income
		System.out.println("Max income is at " + maxValue.getKey() + "h: " + NumberFormat.formatNumber(maxValue.getValue()));
		
	}
}



//incomeListByHour.entrySet().stream().sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
//.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));