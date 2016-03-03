package topic1EJ3;

import junit.framework.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class UnitTest {
	
	@Test
	public void testPrintGetTesting() {

		Assert.assertEquals(Application.getTesting(), "Testing Maven");

	}
}
