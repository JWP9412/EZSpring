package com.solero.calc;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalcTest2 {
	private static int TOTAL = 10;
	static private Calc calc;
	private int total = 0;
	
	@Before
	public void init() {
		System.out.println("CalcTest2 : init()");
		calc = new Calc(TOTAL);
		this.total = calc.total();
	}
	
	@Test
	public void addTest() {
		System.out.println("CalcTest2 : previous addTest");
		if(calc != null) {
			System.out.println("CalcTest2 : addTest()");
			int val = calc.add(9);
			assertEquals(TOTAL + 9, val); // assertEquals(예상값, 실제값)
		}
	}
	
	@Test
	public void totalTest() {
		if(calc != null) {
			int tot = calc.total();
			System.out.printf("> CalcTest2 : totalTest -> total(%d), tot(%d) %n", total, tot);
			assertEquals(total,tot);
		}
	}
	
	@Test
	public void addTotalTest() {
		if(calc != null) {
			calc.add(9);
			this.total += 9;
			int tot = calc.total();
			System.out.printf("> CalcTest2 : addTotalTest -> total(%d), tot(%d) %n", total, tot);
			assertEquals(total,tot);
		}
	}
	
	@After
	public void last() {
		System.out.println("CalcTest2 : last() \n");
		calc = null;
	}
	
	
}
