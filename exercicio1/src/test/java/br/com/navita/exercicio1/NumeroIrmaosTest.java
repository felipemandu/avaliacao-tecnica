package br.com.navita.exercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumeroIrmaosTest {

	private NumeroIrmaos ni;

	@BeforeEach
	public void init() {
		ni = new NumeroIrmaos();
	}

	@Test
	public void mustThrowExcepctionIfValueNegative() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			ni.getTheBiggestBrother(-1);
		});

		String expectedMessage = "O valor deve ser um inteiro positivo.";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void mustBeMinusOneCaseBiggestGreaterThanSuperiorLimit() {
		int actual = ni.getTheBiggestBrother(123_456_789);
		int expected = -1;
		assertEquals(expected, actual);
	}

	@Test
	public void mustBeCorrectValue() {
		assertEquals(4321, ni.getTheBiggestBrother(1234));
		assertEquals(321, ni.getTheBiggestBrother(123));
		assertEquals(321, ni.getTheBiggestBrother(213));
		assertEquals(553, ni.getTheBiggestBrother(355));
		assertEquals(553, ni.getTheBiggestBrother(553));
	}

}
