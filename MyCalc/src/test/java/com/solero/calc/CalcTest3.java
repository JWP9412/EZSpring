package com.solero.calc;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalcTest3 {
	private static int TOTAL = 10;
	static private Calc calc;
	private static int total = 0;
	
	@BeforeClass
	public static void init() {
		System.out.println("CalcTest3 : @BeforeClass -> init()");
		calc = new Calc(TOTAL);
		total = calc.total();
	}
	
	@Test
	public void addTest() {
		System.out.println("CalcTest3 : previous addTest");
		if(calc != null) {
			System.out.println("CalcTest3 : addTest()");
			int val = calc.add(9);
			total += 9;
			assertEquals(TOTAL + 9, val); // assertEquals(예상값, 실제값)
		}
	}
	
	@Test
	public void totalTest() {
		if(calc != null) {
			int tot = calc.total();
			System.out.printf("> CalcTest3 : totalTest -> total(%d), tot(%d) %n", total, tot);
			assertEquals(total,tot);
		}
	}
	
	@Test
	public void addTotalTest() {
		if(calc != null) {
			calc.add(7);
			total += 9;
			int tot = calc.total();
			System.out.printf("> CalcTest3 : addTotalTest -> total(%d), tot(%d) %n", total, tot);
			assertEquals(total,tot);
		}
	}
	
	@AfterClass
	public static void last() {
		System.out.println("CalcTest3 : @AfterClass -> last() \n");
		calc = null;
	}
	
	
}
