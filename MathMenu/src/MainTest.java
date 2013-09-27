import static org.junit.Assert.*;

import org.junit.Test;


public class MainTest {

	@Test
	public void multiplicationTest() {
		assertEquals(25, Main.multiply(5, 5));
		assertEquals(-25, Main.multiply(-5, 5));
		assertEquals(-25, Main.multiply(5, -5));
		assertEquals(25, Main.multiply(-5, -5));
	}
	
	@Test
	public void exponentiationText() {
		assertEquals(25, Main.exponent(5, 2));
		assertEquals(125, Main.exponent(5, 3));
		assertEquals(625, Main.exponent(5, 4));
		assertEquals(-125, Main.exponent(-5, 3));
		assertEquals(1, Main.exponent(123456, 0));
	}

}
