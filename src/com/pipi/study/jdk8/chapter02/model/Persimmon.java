package com.pipi.study.jdk8.chapter02.model;

public class Persimmon extends Fruit {
	private String color;
	private int weight;
	
	public Persimmon() {}
	
	public Persimmon(String color) {
		this.color = color;
	}
	
	public Persimmon(int weight) {
		this.weight = weight;
	}
	
	public Persimmon(String color, int weight) {
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
		return "Persimmon [color=" + color + ", weight=" + weight + "]";
	}
}
