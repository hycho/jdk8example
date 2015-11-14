package com.pipi.study.jdk8.chapter02.sortapple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.pipi.study.jdk8.chapter01.model.Persimmon;
import com.pipi.study.jdk8.chapter02.model.Apple;

public class Main {

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
		
		List<Persimmon> result = sortPersimmon3(inventory);
		for(Persimmon persimmon : result) {
			System.out.println(persimmon.toString());
		}

	}
	
	public static List<Persimmon> sortPersimmon3(List<Persimmon> inventory) {
//		inventory.sort((o1, o2) -> ((Integer) o1.getWeight()).compareTo((Integer) o2.getWeight()));
//		inventory.sort(Comparator.comparing((Persimmon p) -> p.getWeight()));
		inventory.sort(Comparator.comparing(Persimmon::getWeight));
		
		return inventory;
	}
	
	public static List<Persimmon> sortPersimmon2(List<Persimmon> inventory) {
		inventory.sort(new Comparator<Persimmon>() {
			public int compare(Persimmon o1, Persimmon o2) {
				return ((Integer) o1.getWeight()).compareTo((Integer) o2.getWeight());
			}
		});
		
		return inventory;
	}
	
	public static List<Persimmon> sortPersimmon1(List<Persimmon> inventory) {
		inventory.sort(new AppleComparator());
		return inventory;
	}
	
	public static class AppleComparator implements Comparator<Persimmon> {
		public int compare(Persimmon o1, Persimmon o2) {
			return ((Integer) o1.getWeight()).compareTo((Integer) o2.getWeight());
		}
	}

}
