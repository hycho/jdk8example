package com.pipi.study.jdk8.chapter02;

public class Main {

	public static void main(String[] args) {
		runTestProcess2();
	}
	
	public static void runTestProcess1() {
		// 1. 람다 표현식 사용.
		Runnable r1 = () -> System.out.println("Run 1");
		
		// 2. 익명 클래스 사용.
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Run 2");
			}
		};
		
		process(r1);
		process(r2);
		process(() -> System.out.println("Run 3")); // 직접 파라메터로 람다 표현식을 전달.
	}
	
	public static void runTestProcess2() {
		process(() -> System.out.println("Lamda :D"));
	}
	
	public static void process(Runnable r) {
		r.run();
	}
	
}
