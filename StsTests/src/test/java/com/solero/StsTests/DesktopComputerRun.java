package com.solero.StsTests;

public class DesktopComputerRun {

	public static void main(String[] args) {
		Product product = new Product();
		product.setComputer(new Desktop());
		product.setmodel("LG-DESKTOP-7000");
		product.addUnit("SSD 512GB");
		product.addUnit("CPU AMD-16 Core 4GH");
		product.printUnits();

	}

}
