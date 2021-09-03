package com.solero.StsTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DesktopComputerTest {
	static String model = "LG";
	static Computer notebook = new NoteBook();
	static Computer computer = new Desktop();
	
	public DesktopComputerTest(){
		System.out.println("@@@ DesktopComputerTest.Constructor Called");
	}
	
	//@Before
	public void start(){
		System.out.println("$$$ DesktopComputerTest.start()");
	}
	
	//@After
	public void end() {
		System.out.println("$$$ DesktopComputerTest.end()");
	}
	
	@Test
	
	public void testProductModel() {
		Product product = getProduct();
		System.out.print("[DesktopComputerTest] testProductModel : ");
		product.printUnits();
		
		assertEquals(model, product.getmodel()); // 값을 비교
	}
	
	@Test
	@Ignore
	public void testProductComputer() {
		Product product = getProduct();
		System.out.print("[DesktopComputerTest] testProductComputer : ");
		product.printUnits();
		
		assertSame(computer, product.getComputer()); // 객체 비교
//		assertEquals(model, product.getmodel());
	}
	
	@Test
	public void testProductComputer2() {
		Product product = getProduct2();
		System.out.print("[DesktopComputerTest] testProductComputer2 : ");
		product.printUnits();
		
		assertSame(computer, product.getComputer()); // 객체 비교
//		assertEquals(model, product.getmodel());
	}
	
	
	static Product getProduct() {
		Product product = new Product();
		product.setComputer(new Desktop());
		product.setmodel("LG");
		product.addUnit("SSD");
		
		return product;
	}
	
	static Product getProduct2() {
		Product product = new Product();
		product.setComputer(computer);
		product.setmodel("SAMSUNG");
		product.addUnit("HDD");
		
		return product;
	}
}
