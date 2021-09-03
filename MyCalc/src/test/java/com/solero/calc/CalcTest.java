package com.solero.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class CalcTest {
	private static int TOTAL = 10;
	private Calc calc = new Calc(TOTAL);
	private int total = 0;
	
	
	@Test
	@Ignore
	public void addTest() {
		int val = calc.add(9);
		assertEquals(TOTAL + 9, val); // assertEquals(예상값, 실제값)
	}
	
	@Test
	public void addTest1() {
		int x = 7;
		int val = calc.add1(x);
		assertEquals(TOTAL + x, val); // assertEquals(예상값, 실제값)
	}
	
	
}
