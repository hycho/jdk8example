package com.pipi.study.jdk8.chapter02.model;

public class Fruit {
	private String color;
	private int weight;
	
	public Fruit() {}
	
	public Fruit(String color) {
		this.color = color;
	}
	
	public Fruit(int weight) {
		this.weight = weight;
	}
	
	public Fruit(String color, int weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Furit [color=" + color + ", weight=" + weight + "]";
	}
}
