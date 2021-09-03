package com.solero.StsTests;

public class Product {
	private String model;
	private Computer computer;
	
	
	public String getmodel() {
		return model;
	}
	
	public void setmodel(String model) {
		this.model = model;
	}
	
	public Computer getComputer() {
		return computer;
	}
	
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	public void addUnit(String unit) {
		computer.addUnit(unit);
	}
	
	public void printUnits() {
		computer.printUnits(this.model);
	}
}
