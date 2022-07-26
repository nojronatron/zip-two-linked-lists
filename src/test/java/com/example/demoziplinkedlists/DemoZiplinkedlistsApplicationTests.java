package com.example.demoziplinkedlists;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoZiplinkedlistsApplicationTests {

	@Test
	void test_sameSizedLinkedLists_ZipsWithoutError() {
		int expectedSize = 6;

		int expectedHead = 1;
		int expectedTwo = 2;
		int expectedThree = 3;
		int expectedFour = 4;
		int expectedFive = 5;
		int expectedSix = 6;

		LinkedList<Integer> ll1 = new LinkedList<>();
		ll1.addFirst(expectedHead);
		ll1.addLast(expectedThree);
		ll1.addLast(expectedFive);

		LinkedList<Integer> ll2 = new LinkedList<>();
		ll2.addFirst(expectedTwo);
		ll2.addLast(expectedFour);
		ll2.addLast(expectedSix);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(ll1, ll2);

		assertNotNull(actualResult);
		assertEquals(expectedSize, actualResult.size());
	}

	@Test
	void test_firstLLLongerThanSecondLL_ZipsWithoutError() {

	}

	@Test
	void test_secondLLLongerThanFirstLL_ZipsWithoutError() {

	}

	@Test
	void test_secondLLNullFirstHasNodes_ReturnsFirstWithoutError() {

	}

	@Test
	void test_firstLLNullSecondHasNodes_ReturnSecondWithoutError() {

	}

	@Test
	void test_bothLLNull_ReturnNullWithoutError() {

	}

}
