package com.pipi.study.jdk8.chapter02.model;

public class Orange extends Fruit {
	private String color;
	private int weight;
	
	public Orange() {}
	
	public Orange(String color) {
		this.color = color;
	}
	
	public Orange(int weight) {
		this.weight = weight;
	}
	
	public Orange(String color, int weight) {
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
		return "Orange [color=" + color + ", weight=" + weight + "]";
	}
}
