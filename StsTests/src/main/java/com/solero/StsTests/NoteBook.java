package com.solero.StsTests;

public class NoteBook implements Computer {
	private StringBuffer units = new StringBuffer();
	
	@Override
	public void addUnit(String spec) {
		if (units.length() > 0) {
			units.append(",");
		}
		units.append(spec);

	}


	@Override
	public void printUnits(String model) {
		System.out.printf("[NoteBook] model=%s, units=%s \n",model, units.toString());

	}

}
