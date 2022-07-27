package com.example.demoziplinkedlists;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import MyLinkedListLibrary.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoZiplinkedlistsApplicationTests {

	@Test
	void test_linkedListClass_UpdatesCountCorrectlyWithoutError() {
		LinkedList<Integer> linkedList = new LinkedList<>(1);
		assertEquals(1, linkedList.getSize());
		linkedList.add(2);
		assertEquals(2, linkedList.getSize());
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		assertEquals(5, linkedList.getSize());
	}

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
		ll1.add(expectedSix);

		LinkedList<Integer> ll2 = new LinkedList<>(expectedTwo);
		ll2.add(expectedFour);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(ll1, ll2);

		assertNotNull(actualResult);
		assertEquals(expectedSize, actualResult.getSize());
	}

	@Test
	void test_secondLLLongerThanFirstLL_ZipsWithoutError() {
		int expectedSize = 6;

		int expectedHead = 1;
		int expectedTwo = 2;
		int expectedThree = 3;
		int expectedFour = 4;
		int expectedFive = 5;
		int expectedSix = 6;

		LinkedList<Integer> ll1 = new LinkedList<>(expectedHead);
		ll1.add(expectedThree);

		LinkedList<Integer> ll2 = new LinkedList<>(expectedTwo);
		ll2.add(expectedFour);
		ll2.add(expectedFive);
		ll2.add(expectedSix);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(ll1, ll2);

		assertNotNull(actualResult);
		assertEquals(expectedSize, actualResult.getSize());
	}

	@Test
	void test_secondLLNullFirstHasNodes_ReturnsFirstWithoutError() {
		int expectedSize = 6;

		int expectedHead = 1;
		int expectedTwo = 2;
		int expectedThree = 3;
		int expectedFour = 4;
		int expectedFive = 5;
		int expectedSix = 6;

		LinkedList<Integer> ll1 = new LinkedList<>(expectedHead);
		ll1.add(expectedTwo);
		ll1.add(expectedThree);
		ll1.add(expectedFour);
		ll1.add(expectedFive);
		ll1.add(expectedSix);

		LinkedList<Integer> ll2 = new LinkedList<>(null);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(ll1, ll2);

		assertNotNull(actualResult);
		assertEquals(expectedSize, actualResult.getSize());
	}

	@Test
	void test_firstLLNullSecondHasNodes_ReturnSecondWithoutError() {
		int expectedSize = 6;

		int expectedHead = 1;
		int expectedTwo = 2;
		int expectedThree = 3;
		int expectedFour = 4;
		int expectedFive = 5;
		int expectedSix = 6;

		LinkedList<Integer> ll1 = new LinkedList<>(null);

		LinkedList<Integer> ll2 = new LinkedList<>(expectedHead);
		ll2.add(expectedTwo);
		ll2.add(expectedThree);
		ll2.add(expectedFour);
		ll2.add(expectedFive);
		ll2.add(expectedSix);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(ll1, ll2);

		assertNotNull(actualResult);
		assertEquals(expectedSize, actualResult.getSize());
	}

	@Test
	void test_bothLLNull_ReturnNullWithoutError() {
		int expectedCount = 0;
		LinkedList<Integer> ll1 = new LinkedList<>(null);
		LinkedList<Integer> ll2 = new LinkedList<>(null);
		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
//		var actualResult = llz.zipLinkedLists(ll1, ll2);
		var actualResult = llz.zipLinkedLists(null, null);
		assertEquals(expectedCount, ll1.getSize());
		assertEquals(ll1.getSize(), ll2.getSize());
	}

}
