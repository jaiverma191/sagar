package com.sagar.pattern.creatitional.builder;

public enum HomeownerStatus {

	RENTEE("Rentee"), OWNER("Owner");

	private String hoStatus;

	private HomeownerStatus(String hoStatus) {
		this.hoStatus = hoStatus;
	}

	@Override
	public String toString() {
		return hoStatus;
	}
}