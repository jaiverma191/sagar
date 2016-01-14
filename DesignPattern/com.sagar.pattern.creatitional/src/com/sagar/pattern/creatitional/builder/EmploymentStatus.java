package com.sagar.pattern.creatitional.builder;

public enum EmploymentStatus {

	EMPLOYED("Employed"), UNEMPLOYED("Un-Employed");

	private String empStatus;

	private EmploymentStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	@Override
	public String toString() {
		return empStatus;
	}
}
