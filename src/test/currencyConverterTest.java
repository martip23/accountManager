package test;

import static org.junit.Assert.*;
import accountManager.util.*;

import org.junit.Test;

public class currencyConverterTest {

	@Test
	public void testEurToUsd() {
		int testVal = 12658;
		assertEquals(testVal, currencyConverter.eurToUsd(10000));
		testVal = 197;
		assertEquals(testVal, currencyConverter.eurToUsd(156));
		testVal = 1235;
		assertEquals(testVal, currencyConverter.eurToUsd(976));
	}

	@Test
	public void testJpyToUsd() {
		int testVal = 106;
		assertEquals(testVal, currencyConverter.jpyToUsd(10000));
		testVal = 1;
		assertEquals(testVal, currencyConverter.jpyToUsd(156));
		testVal = 10;
		assertEquals(testVal, currencyConverter.jpyToUsd(976));
	}

	@Test
	public void testUsdToEur() {
		int testVal = 7900;
		assertEquals(testVal, currencyConverter.usdToEur(10000));
		testVal = 123;
		assertEquals(testVal, currencyConverter.usdToEur(156));
		testVal = 771;
		assertEquals(testVal, currencyConverter.usdToEur(976));
	}

	@Test
	public void testUsdToJpy() {
		int testVal = 941000;
		assertEquals(testVal, currencyConverter.usdToJpy(10000));
		testVal = 14679;
		assertEquals(testVal, currencyConverter.usdToJpy(156));
		testVal = 91841;
		assertEquals(testVal, currencyConverter.usdToJpy(976));
	}

}
