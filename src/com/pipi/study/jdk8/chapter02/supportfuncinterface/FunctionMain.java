package com.pipi.study.jdk8.chapter02.supportfuncinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.pipi.study.jdk8.chapter01.model.Persimmon;

public class FunctionMain {

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
	
		List<Integer> result = map(inventory, (Persimmon p) -> p.getWeight());
		for(Integer weight : result) {
			System.out.println(weight);
		}
	}
	
	public static <T, R> List<R> map(List<T> inventory, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		
		for(T t: inventory) {
			result.add(f.apply(t));
		}
		
		return result;
	}
	
}
