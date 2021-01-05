package br.com.navita.exercicio1;

import java.util.stream.Stream;

public class NumeroIrmaos {
	private static final int SUPERIOR_LIMIT = 100_000_000;

	public int getTheBiggestBrother(int value) {
		verifyIfPositive(value);
		String biggestAsString = getAsString(value);
		int biggestBrother = Integer.parseInt(biggestAsString);

		if (biggestBrother > SUPERIOR_LIMIT) {
			return -1;
		}
		return biggestBrother;
	}

	private String getAsString(int value) {
		String[] valueAsStringArray = String.valueOf(value).split("");
		return Stream.of(valueAsStringArray)
				.sorted((s1, s2) -> s2.compareTo(s1))
				.reduce("", (s1, s2) -> s1 + s2);
	}

	private void verifyIfPositive(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("O valor deve ser um inteiro positivo.");
		}
	}
}
