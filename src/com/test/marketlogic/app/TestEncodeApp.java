package com.test.marketlogic.app;

import org.junit.Test;

import com.marketlogic.app.UnicodeConversion;

import org.junit.Assert;

/**
* This program implements Junit test cases
* for String encoding Funcationality
* based on the offset value provided
* @author  Pradeepkumar
* @version 1.0
* @since   2018-02-02 
*/
public class TestEncodeApp {
	
	@Test
	public void testIncrementalOffset() throws Exception {
		//Returns true by comparing the encoded value and the generated value
		Assert.assertTrue(UnicodeConversion.encode("Pradeep", 1).contentEquals("Qsbeffq"));

	}
	
	@Test
	public void testDecrementalOffset() throws Exception {
		//Returns true by comparing the encoded value and the generated value
		Assert.assertTrue(UnicodeConversion.encode("Pradeep", -1).contentEquals("Oqzcddo"));

	}
	@Test
	public void testNumericValue() throws Exception {
		//Returns true by comparing the encoded value and the generated value
		Assert.assertTrue(UnicodeConversion.encode("Pradeep123", 1).contentEquals("Qsbeffq123"));

	}
	@Test
	public void testSpecialCharacter() throws Exception {
		//Returns true by comparing the encoded value and the generated value
		Assert.assertTrue(UnicodeConversion.encode("Pradeep]]]", 1).contentEquals("Qsbeffq]]]"));

	}
	@Test
	public void testWhiteSpaceValue() throws Exception {
		//Returns true by comparing the encoded value and the generated value
		Assert.assertTrue(UnicodeConversion.encode("Pradee p]]]", 1).contentEquals("Qsbeff q]]]"));

	}
	
	@Test
	public void testNullvalue() throws Exception {
		//Returns true by comparing the encoded value and the generated value
		Assert.assertTrue(UnicodeConversion.encode("", 1).contentEquals(""));

	}
	
	
	@Test
	public void testEndValue() throws Exception {
		//Returns true by comparing the encoded value and the generated value
		Assert.assertTrue(UnicodeConversion.encode("zzz", 1).contentEquals("aaa"));

	}
	
	@Test
	public void testStartValue() throws Exception {
		//Returns true by comparing the encoded value and the generated value
		Assert.assertTrue(UnicodeConversion.encode("aaa", -1).contentEquals("zzz"));

	}
	
}
