package com.acorn.day2.di;

public class AcornCalculator implements Calculator{

	@Override
	public int add(int su1, int su2) {
		return su1 + su2;
	}

	@Override
	public int sub(int su1, int su2) {
		return su1 - su2;
	}

}
