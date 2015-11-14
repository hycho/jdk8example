package com.pipi.study.jdk8.chapter02.methodreperence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.pipi.study.jdk8.chapter02.model.Apple;
import com.pipi.study.jdk8.chapter02.model.Fruit;
import com.pipi.study.jdk8.chapter02.model.Orange;
import com.pipi.study.jdk8.chapter02.model.Persimmon;

public class Main {
	public static void main(String[] args) {
		// 인자를 가지지 않는 생성자를 통해 Persimmon 객체를 생성
		Supplier<Persimmon> supPersimmon1 = Persimmon::new;
		Persimmon p1 = supPersimmon1.get();
		
		// 동일한 Persimmon 객체를 생성하는 예제
		Supplier<Persimmon> supPersimmon2 = () -> new Persimmon();
		Persimmon p2 = supPersimmon2.get();
		
		// Integer를 갖는 생성자를 통해 Persimmon을 생성한다.
		Function<Integer, Persimmon> f1 = (i) -> new Persimmon(i);
		Persimmon p3 = f1.apply(50);
		
		// Integer를 갖는 생성자를 통해 Persimmon을 생성한다. 
		Function<Integer, Persimmon> f2 = Persimmon::new;
		Persimmon p4 = f2.apply(100);
		
		// Integer를 인자로 받는 생성자 List를 생성한다.
		List<Persimmon> persimmonList = persimmonGenerator(Arrays.asList(150, 200, 100), Persimmon::new);
		for(Persimmon p : persimmonList) {
			System.out.println(p.toString());
		}
		
		// 2개의 인자를 받는 Persimmon을 생성한다.
		BiFunction<String, Integer, Persimmon> genPersimmon = Persimmon::new;
		Persimmon persimmon1 = genPersimmon.apply("green", 300);
		System.out.println(persimmon1);
		
		Map<String, Function<Integer, Fruit>> fruitFactory = new HashMap<>();
		fruitFactory.put("apple", Apple::new);
		fruitFactory.put("persimmon", Persimmon::new);
		fruitFactory.put("orange", Orange::new);
		
		System.out.println(createFruit("apple", 100, fruitFactory));
	}
	
	public static Fruit createFruit(String name, Integer weight, Map<String, Function<Integer, Fruit>> map) {
		return map.get(name).apply(weight);
	}
		
	/**
	 * list의 값을 인자로 받는 <R> 객체들을 생성한다
	 * @param list
	 * @param f
	 * @return
	 */
	public static <T,R> List<R> persimmonGenerator(List<T> list, Function<T,R> f) {
		List<R> result = new ArrayList<>();
		
		for(T t : list) {
			result.add(f.apply(t));
		}
		
		return result;
	}
	
	
}
