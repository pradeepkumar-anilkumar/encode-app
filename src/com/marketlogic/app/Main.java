package com.marketlogic.app;
/**
* This program implements an application that
* simply encodes the character of a given String
* based on the offset value provided
* @author  Pradeepkumar
* @version 1.0
* @since   2018-02-02 
*/
public class Main {
	  /**
	   * This is the main method which makes use of encode method.
	   * @param args Unused.
	   * @return Nothing.
	   * @exception Exception.
	   * @see Exception
	   */
	public static void main(String[] args) throws Exception {
		//Invoke encode method of UnicodeConversion class	
		UnicodeConversion.encode("Pradeep",1).toString();
	}

}
