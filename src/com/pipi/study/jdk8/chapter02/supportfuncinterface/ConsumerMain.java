package com.pipi.study.jdk8.chapter02.supportfuncinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.pipi.study.jdk8.chapter01.model.Persimmon;

public class ConsumerMain {

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
	
		forEach(inventory, (Persimmon p) -> { System.out.println(p); });
	}
	
	public static <T> void forEach(List<T> inventory, Consumer<T> c) {
		for(T t: inventory) {
			c.accept(t);
		}
	}
	
}
