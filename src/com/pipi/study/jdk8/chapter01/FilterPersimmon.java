package com.pipi.study.jdk8.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pipi.study.jdk8.chapter01.formatter.PrintFommater;
import com.pipi.study.jdk8.chapter01.model.Persimmon;
import com.pipi.study.jdk8.chapter01.predicate.PersimmonPredicate;

public class FilterPersimmon {

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
		
		/*List<Persimmon> result = filterOrangePersimmon(inventory);
		for(Persimmon persimmon : result) {
			System.out.println("Persimmon color is " + persimmon.getColor());
		}*/
		
		/*List<Persimmon> result = filterPersimmonByColor(inventory, "green");
		for(Persimmon persimmon : result) {
			System.out.println(persimmon);
		}*/
		
		/*List<Persimmon> result = filterPersimmonByWeight(inventory, 200);
		for(Persimmon persimmon : result) {
			System.out.println(persimmon.toString());
		}*/
		
		/*List<Persimmon> result = filterPersimmons(inventory, "", 200, false);
		for(Persimmon persimmon : result) {
			System.out.println(persimmon.toString());
		}*/
		
		/*List<Persimmon> result = filterPersimmons(inventory, new PersimmonHeavyWeightPredicate());
		for(Persimmon persimmon : result) {
			System.out.println(persimmon.toString());
		}*/
		
		// 구현 클래스 파라미터화
		//prettyPrintPersimmons(inventory, new PersimmonFancyPrintFommater());
		
		//익명 클래스 사용
		/*filterPersimmons(inventory, new PersimmonPredicate() {	// 익명클래스를 사용해서 기능(동작)을 파라메터화 했다.
			@Override
			public boolean test(Persimmon persimmon) {
				return "green".equals(persimmon.getColor());
			}
		});*/
		
		//람다 표현식 사용
		List<Persimmon> result = filterPersimmons(inventory, (Persimmon p) -> "green".equals(p.getColor()));
		for(Persimmon persimmon : result) {
			System.out.println(persimmon.toString());
		}
		
		//System.out.println("Orange Persimmon length " + result.size());
	}
	
	public static List<Persimmon> prettyPrintPersimmons(List<Persimmon> inventory, PrintFommater p) {
		List<Persimmon> result = new ArrayList<>();
		for(Persimmon persimmon : inventory) {
			String output = p.getFormat(persimmon);
			System.out.println(output);
		}

		return result;
	}
	
	public static List<Persimmon> filterPersimmons(List<Persimmon> inventory, PersimmonPredicate p) {
		List<Persimmon> result = new ArrayList<>();
		for(Persimmon persimmon : inventory) {
			if(p.test(persimmon)) {	//predicate 객체로 감 검사 조건을 캡슐화.
				result.add(persimmon);
			}
		}

		return result;
	}
	
	/*public static List<Persimmon> filterPersimmons(List<Persimmon> inventory, String color, int weight, boolean flag) {
		List<Persimmon> result = new ArrayList<>();
		for(Persimmon persimmon : inventory) {
			if((flag && persimmon.getColor().equals(color)) || (!flag && persimmon.getWeight() > weight)) {
				result.add(persimmon);
			}
		}

		return result;
	}*/
	
	public static List<Persimmon> filterPersimmonByColor(List<Persimmon> inventory, String color) {
		List<Persimmon> result = new ArrayList<>();
		for(Persimmon persimmon : inventory) {
			if(color.equals(persimmon.getColor())) { //color 파라메터를 통해서 비교
				result.add(persimmon);
			}
		}

		return result;
	}
	
	public static List<Persimmon> filterPersimmonByWeight(List<Persimmon> inventory, int weight) {
		List<Persimmon> result = new ArrayList<>();
		for(Persimmon persimmon : inventory) {
			if(weight < persimmon.getWeight()) { //color 파라메터를 통해서 비교
				result.add(persimmon);
			}
		}

		return result;
	}
	
	public static List<Persimmon> filterOrangePersimmon(List<Persimmon> inventory) {
		List<Persimmon> result = new ArrayList<>();
		for(Persimmon persimmon : inventory) {
			if("orange".equals(persimmon.getColor())) {
				result.add(persimmon);
			}
		}
		return result;
	}

}
