package com.pipi.study.jdk8.chapter02.supportPrimitivetype;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		IntPredicate evenNumbers1 = (int i) -> i % 2 == 0;
		System.out.println(evenNumbers1.test(1000)); //박싱이 이루어지지 않는다.
		
		Predicate<Integer> evenNumbers2 = (Integer i) -> i % 2 == 0;
		System.out.println(evenNumbers2.test(1000)); // int형 1000을 Integer로 박싱을 한다.
	}

}
