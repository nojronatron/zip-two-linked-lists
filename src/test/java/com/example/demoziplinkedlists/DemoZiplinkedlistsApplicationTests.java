package com.example.demoziplinkedlists;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import MyLinkedListLibrary.LinkedList;
import MyLinkedListLibrary.Node;
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

		LinkedList<Integer> ll1 = new LinkedList<>(expectedHead);
		ll1.add(expectedThree);
		ll1.add(expectedFive);

		LinkedList<Integer> ll2 = new LinkedList<>(expectedTwo);
		ll2.add(expectedFour);
		ll2.add(expectedSix);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(ll1, ll2);

		assertNotNull(actualResult);
		assertEquals(expectedSize, actualResult.getSize());
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
