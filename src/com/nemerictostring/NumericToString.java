package com.nemerictostring;

public class NumericToString {
	
	public static void mian(String args[])
	{
		IConverter converter = null;
		converter = new Converter();
		try {
			System.out.println(converter.convert(123456));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
