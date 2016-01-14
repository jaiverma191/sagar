package com.sagar.pattern.creatitional.builder;

public class City {

	private String cityName;

	public City(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return cityName;
	}
}
