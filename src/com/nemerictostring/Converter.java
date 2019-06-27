package com.nemerictostring;

import java.text.DecimalFormat;

import com.nemerictostring.IConverter;

public class Converter implements IConverter {

	/** 
	 *  Converts number into String
	 */
	public String convert(long number) throws Exception {
		
		String result = null;
		try{
	    if (number == 0) { return "Zero"; }

	    String snumber = Long.toString(number);

	    // pad with "0"
	    String mask = "000000000000";
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(number);

	    int billions = Integer.parseInt(snumber.substring(0,3));
	    int millions  = Integer.parseInt(snumber.substring(3,6));
	    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
	    int thousands = Integer.parseInt(snumber.substring(9,12));

	    String tradBillions;
	    switch (billions) {
	    case 0:
	      tradBillions = "";
	      break;
	    case 1 :
	      tradBillions = convertLessThanOneThousand(billions)
	      + " Billion ";
	      break;
	    default :
	      tradBillions = convertLessThanOneThousand(billions)
	      + " Billion ";
	    }
	    result =  tradBillions;

	    String tradMillions;
	    switch (millions) {
	    case 0:
	      tradMillions = "";
	      break;
	    case 1 :
	      tradMillions = convertLessThanOneThousand(millions)
	         + " Million ";
	      break;
	    default :
	      tradMillions = convertLessThanOneThousand(millions)
	         + " Million ";
	    }
	    result =  result + tradMillions;
	    String tradHundredThousands;
	   
	    switch (hundredThousands) {
	    case 0:
	      tradHundredThousands = "";
	      break;
	    case 1 :
	      tradHundredThousands = "one Thousand ";
	      break;
	    default :
	      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
	         + " Thousand ";
	    }
	    result =  result + tradHundredThousands;
	    String tradThousand;

	    tradThousand = convertLessThanOneThousand(thousands);
	    result =  result + tradThousand;

		}catch(Exception e){
			e.printStackTrace();
		}
		return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	  }
	
	/**
	 * Converts number into string if the number is less than thousand
	 * @param number
	 * @return
	 */
	 private static String convertLessThanOneThousand(int number) {
		    String resultString;

		    if (number % 100 < 20){
		    	resultString = Util.numStringsLessThanTwenty[number % 100];
		      number /= 100;
		    }
		    else {
		    	resultString = Util.numStringsLessThanTwenty[number % 10];
		      number /= 10;

		      resultString = Util.tensString[number % 10] + resultString;
		      number /= 10;
		    }
		    if (number == 0) return resultString;
		    return Util.numStringsLessThanTwenty[number] + " Hundred" + resultString;
		  }
}
