package com.nemerictostring;

import org.junit.Assert;
import org.junit.Test;


public class NumericToStringTest {

	@Test
	public void test1()  {
		IConverter converter = null;
		
			converter = new Converter();
			String result;
			try {
				result = converter.convert(123);
				Assert.assertEquals("Expected and actual are not equal :","one Hundred twenty three", result);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void test2()  {
		IConverter converter = null;
		
			converter = new Converter();
			String result;
			try {
				result = converter.convert(123456);
				Assert.assertEquals("Expected and actual are not equal :","Hundred twenty three Thousand four Hundred fifty six", result);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
