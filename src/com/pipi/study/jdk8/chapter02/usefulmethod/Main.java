package com.pipi.study.jdk8.chapter02.usefulmethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.pipi.study.jdk8.chapter01.model.Persimmon;

public class Main {

	public static void main(String[] args) {
		List<Persimmon> inventory = Arrays.asList(
			new Persimmon("orange", 500),
			new Persimmon("green", 120),
			new Persimmon("green", 200),
			new Persimmon("orange", 190),
			new Persimmon("orange", 250),
			new Persimmon("green", 90),
			new Persimmon("green", 350),
			new Persimmon("orange", 200)
		);
		
//		List<Persimmon> result = sortPersimmon(inventory);
//		for(Persimmon persimmon : result) {
//			System.out.println(persimmon.toString());
//		}
		
//		Predicate<Persimmon> p = (persimmon) -> persimmon.getColor().equals("green");
//		List<Persimmon> result = filterPersimmon(inventory, p.and(persimmon -> persimmon.getWeight() > 200)
//													 .or(persimmon -> persimmon.getColor().equals("orange")));	
//		showPersimmons(result);
		
Function<Integer, Integer> f1 = x -> x + 1;		// 숫자를 1 증가 시킨다.
Function<Integer, Integer> f2 = x -> x * 2; 	// 숫자에 2를 곱한다.
Function<Integer, Integer> f3 = f1.andThen(f2);	// 숫자에 1을 증가시키고 그리고 2를 곱한다.
Function<Integer, Integer> f4 = f1.compose(f2); // 숫자에 2를 곱하고 1을 더한다.
int result = f3.apply(3);	// (3 + 1) * 2 = 8
int result1 = f4.apply(3);	// (3 * 2) + 1 = 7
System.out.println(result1);


	}
	
	public static void showPersimmons(List<Persimmon> result) {
		for(Persimmon p : result) {
			System.out.println(p.toString());
		}
	}
	
	public static List<Persimmon> sortPersimmon(List<Persimmon> inventory) {
		inventory.sort(Comparator.comparing(Persimmon::getWeight)
				 .reversed()
				 .thenComparing(Persimmon::getColor));
		
		return inventory;
	}
	
	public static <T> List<T> filterPersimmon(List<T> inventory, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for(T t : inventory) {
			if(p.test(t)) {
				result.add(t);
			}
		}
		
		return result;
	}
	
}
