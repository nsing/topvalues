package com.exercise;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 * This test class for FindTopValuesImpl
 */
public class FindTopValuesTest {

FindTopValues findTopValues;

	@Before
	public void setUp() throws Exception {
		findTopValues = new FindTopValuesImpl();
	}

	@Test
	public void findTopValuesTest() {
		int[] arr = { 1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
		              11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
			      21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
			      31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
			      41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
		int[] topValuesActual = findTopValues.findTopNValues(arr, 5);
		int[] topValuesExpected = {50, 49, 48, 47, 46};
		assertArrayEquals(topValuesExpected, topValuesActual);
	}

	@Test
	public void findMaxValueTest() {
		int[] arr = { 1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
		              11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
			      21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
			      31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
			      41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
		int maxValueActual = findTopValues.findMaxValue(arr);
		int maxValueExpected = 50;
		assertEquals(maxValueExpected, maxValueActual);
	}


}
