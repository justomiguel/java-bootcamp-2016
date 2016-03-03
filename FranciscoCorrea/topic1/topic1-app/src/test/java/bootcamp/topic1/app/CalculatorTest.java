
package bootcamp.topic1.app;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
	protected Calculator calculator;
	
	protected void setUp() {
		calculator = new Calculator();
	}
	
	public void testAdition() {
		int result = calculator.adition(2, 3);
		assertEquals(5, result);	
	}
	
	public void testMultiply() {
		int result = calculator.multiply(2, 3);
		assertEquals(6, result);
	}
	
	
}
