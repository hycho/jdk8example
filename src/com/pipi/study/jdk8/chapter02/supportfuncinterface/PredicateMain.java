package com.pipi.study.jdk8.chapter02.supportfuncinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.pipi.study.jdk8.chapter01.model.Persimmon;

public class PredicateMain {

	public static void main(String[] args) {
		List<Persimmon> inventory = Arrays.asList(
			new Persimmon("orange", 500),
			new Persimmon("green", 120),
			new Persimmon("green", 300),
			new Persimmon("orange", 190),
			new Persimmon("orange", 250),
			new Persimmon("green", 90),
			new Persimmon("green", 350),
			new Persimmon("orange", 200)
		);

	
		List<Persimmon> result = filter(inventory, (Persimmon p) -> p.getWeight() > 200);
		for(Persimmon persimmon : result) {
			System.out.println(persimmon.toString());
		}
	}
	
	public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		
		for(T t: inventory) {
			if(p.test(t)) {
				result.add(t);
			}
		}
		
		return result;
	}
	
}
