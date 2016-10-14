package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testUnknownAmountOfNumbers() {
		assertEquals(20, Calculator.add("2,8,5,2,3"));
	}

	@Test
	public void testToHandleNewLineBetweenNumbers(){
		assertEquals(10, Calculator.add("2\n2,6"));
	}

	@Test
	public void testAddNegativeException() {
		try {
			Calculator.add("2,-4,3,-5,6,6");
		} 
			catch (IllegalArgumentException exeption) {
				assertEquals("Negatives not allowed: -4,-5", exeption.getMessage());
		}
	}
}