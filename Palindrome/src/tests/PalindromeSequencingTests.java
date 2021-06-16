package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeSequencingTests {

	@Test
	void test10() {
		PalindromeSequencing test = new PalindromeSequencing();
		String output = test.palindromeSequencing("10");
		assertEquals("9", output);
	}
	
	@Test
	void test11() {
		PalindromeSequencing test = new PalindromeSequencing();
		String output = test.palindromeSequencing("11");
		assertEquals("9", output);
	}
	
	@Test
	void test123() {
		PalindromeSequencing test = new PalindromeSequencing();
		String output = test.palindromeSequencing("123");
		assertEquals("121", output);
	}

}
