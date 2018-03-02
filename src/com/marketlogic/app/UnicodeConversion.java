package com.marketlogic.app;
/**
* This program implements an application that
* simply encodes the character of a given String
* based on the offset value provided
* @author  Pradeepkumar
* @version 1.0
* @since   2018-02-02 
*/
public class UnicodeConversion {
	 /**
	   * This method is used to Iterate the characters from the given String
	   * @param original This is the first parameter to encode method
	   * @param offSet  This is the second parameter to encode method
	   * @return String This returns Encoded Value
	   */
	public static String encode(String original, int offSet) throws Exception  {
		//Variable declaration based on the parameters received
		String inputData = original;
		char[] originalString = inputData.toCharArray();
		//check if the  input data is null and return no value for processing
				if (null == inputData || inputData.isEmpty()) {
					System.out.println("InputData is Null/Empty");
					return inputData;
				}	
		int inputLength = inputData.length();
		char[] convertedResult = new char[inputLength];
		boolean midCharFlag = inputLength % 2 == 1 ? true : false;
		
		try{
		//Check for the maximum offset value
		if (offSet % Constants.MAXALPHASIZE != 0)
			offSet = offSet % Constants.MAXALPHASIZE;
		//Iterate over the string characters
		for (int iterate = 0; iterate < inputLength / 2; iterate++) {
			
			//Invoke convertCharacter method to manipulate the string charatcers
			convertedResult[iterate] = convertCharacter(originalString[iterate], offSet);
			//Exit if the String has only one character
			if (inputLength == 1)
				break;
			
			convertedResult[inputLength - iterate - 1] = convertCharacter(originalString[inputLength - iterate - 1],
					offSet);

			if ((iterate + 1) == inputLength / 2 && midCharFlag) {
				convertedResult[(inputLength / 2)] = convertCharacter(originalString[(inputLength / 2)], offSet);
			}

		}
		System.out.println(convertedResult);
		}
		
		catch(Exception e){
			throw new Exception("Exception while encoding");
		}

		return String.copyValueOf(convertedResult);

	}
	 /**
	   * This method is used to Manupilate the Iterated String
	   * @param inputChar This is the first parameter to convertCharacter method
	   * @param offSet  This is the second parameter to convertCharacter method
	   * @return char This returns Encoded Character each time
	   */
	private static char convertCharacter(char inputChar, int offSet) {
		//Ignore if the character is a white space or Numeric or Symbols
		if (Character.isWhitespace(inputChar) || Character.isDigit(0) || !Character.isAlphabetic(inputChar))
			return inputChar;
		boolean characterCase = false;
		characterCase = Character.isLowerCase(inputChar);
		if ((characterCase && Constants.LOWERCASEMIN > (int) inputChar + offSet)
				|| (!characterCase && Constants.CAPCASEMIN > (int) inputChar + offSet))
			return Character.toChars((int) inputChar + offSet + 26)[0];
		//Logic for char z and Z with offset -1 or 1 to shift the value to previous and next char
		else if ((characterCase && Constants.LOWERCASEMAX < (int) inputChar + offSet)
				|| (!characterCase && Constants.CAPCASEMAX < (int) inputChar + offSet))
			return Character.toChars((int) inputChar + offSet - 26)[0];
		//Logic for char a to A with offset -1 or 1 to shift the value to previous and next char
		else if ((characterCase && Constants.LOWERCASEMIN <= (int) inputChar + offSet && Constants.LOWERCASEMAX >= (int) inputChar + offSet)
				|| (!characterCase && Constants.CAPCASEMIN <= (int) inputChar + offSet && Constants.CAPCASEMAX >= (int) inputChar + offSet))
			return Character.toChars((int) inputChar + offSet)[0];

		return inputChar;
	}

}