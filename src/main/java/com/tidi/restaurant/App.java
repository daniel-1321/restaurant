package com.tidi.restaurant;

import java.security.Key;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	static Map<String, Integer> ordItemListMap = new HashMap<String, Integer>();

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
		System.out.println("============================");
		showIncomeByHour(orderList);
		System.out.println("============================");
		getTotalIncome(orderList);
		System.out.println("============================");
		showFoodQuantityByHour(orderList);
	}

	// Show total income in day
	public static void getTotalIncome(List<Ordered> orderList) {
		sum = orderList.stream().map(Ordered::getOrd_total).collect(Collectors.summingDouble(i -> i));
		System.out.println("Total income (" + date.format(currentDate) + ") : " + NumberFormat.formatNumber(sum));
	}

	// Show the most ordered food each hour
	private static void showFoodQuantityByHour(final List<Ordered> ordered) {
		Map<Integer, List<Ordered>> foodListByHour = ordered.stream()
				.collect(Collectors.groupingBy(Ordered::getOrd_time, LinkedHashMap::new, Collectors.toList()));
		System.out.println("The most ordered food during a day");
		foodListByHour.entrySet().stream().forEach(action -> {
			int timeStamp = action.getKey();
			System.out.println(timeStamp+"h: ");

			action.getValue().forEach(a -> {
				ordItemListMap = a.getOrderItem().stream().collect(
						Collectors.groupingBy(OrderItem::getFoodName, Collectors.summingInt(OrderItem::getQuantity)));

			});
			int maxValueInMap = (Collections.max(ordItemListMap.values()));
			for (Entry<String, Integer> entry : ordItemListMap.entrySet()) {
				if (entry.getValue() == maxValueInMap) {
					System.out.println("Name: " + entry.getKey() + " - " + entry.getValue() + " times");
				}
			}
		});

	}

	// Show income by hour
	private static void showIncomeByHour(final List<Ordered> ordered) {
		Map<Integer, Double> incomeListByHour = ordered.stream()
				.collect(Collectors.groupingBy(Ordered::getOrd_time, Collectors.summingDouble(Ordered::getOrd_total)));
		incomeListByHour.entrySet().stream().forEach(
				hour -> System.out.println(hour.getKey() + "h - " + NumberFormat.formatNumber(hour.getValue())));
		Entry<Integer, Double> maxValue = incomeListByHour.entrySet().stream().max(Map.Entry.comparingByValue()).get();

		// Show which hour has a max income
		System.out.println("============================");
		System.out.println(
				"Max income is at " + maxValue.getKey() + "h: " + NumberFormat.formatNumber(maxValue.getValue()));

	}
}

//incomeListByHour.entrySet().stream().sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
//.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
