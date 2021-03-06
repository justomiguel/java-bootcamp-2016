package classtest;

import static org.junit.Assert.*;

import org.junit.Test;

import Example.MyClass;


public class TestExample {

	@Test
	  public void multiplicationOfZero() {

	    // MyClass is tested
	    MyClass tester = new MyClass();

	    // assert statements
	    assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 1));//must fail, but i got skipped the test
	    assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
	    assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
	  }

	} 
