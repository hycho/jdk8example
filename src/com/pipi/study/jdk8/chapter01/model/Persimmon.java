package com.pipi.study.jdk8.chapter01.model;

public class Persimmon {
	private String color;
	private int weight;
	
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
