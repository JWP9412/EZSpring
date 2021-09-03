package com.solero.calc;

public class Calc {
	private int total = 0;
	
	
	public Calc(int total) {
		this.total = total;
		System.out.println(">>> Calc:total : " + this.total);
	}
	// 오류코드
	public int add1(int val) {
		this.total = val;
		return this.total;
	}
	
	public int add(int val) {
		this.total += val;
		return this.total;
	}
	
	
	
	public int total() {
		return this.total;
	}
	
}
