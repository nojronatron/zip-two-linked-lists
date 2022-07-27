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

		LinkedList<Integer> sutLeft = new LinkedList<>(expectedHead);
		sutLeft.add(expectedThree);
		sutLeft.add(expectedFive);

		LinkedList<Integer> sutRight = new LinkedList<>(expectedTwo);
		sutRight.add(expectedFour);
		sutRight.add(expectedSix);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(sutLeft, sutRight);

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

		LinkedList<Integer> sutLeft = new LinkedList<>(expectedHead);
		sutLeft.add(expectedThree);
		sutLeft.add(expectedFive);
		sutLeft.add(expectedSix);

		LinkedList<Integer> sutRight = new LinkedList<>(expectedTwo);
		sutRight.add(expectedFour);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(sutLeft, sutRight);

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

		LinkedList<Integer> sutLeft = new LinkedList<>(expectedHead);
		sutLeft.add(expectedThree);

		LinkedList<Integer> sutRight = new LinkedList<>(expectedTwo);
		sutRight.add(expectedFour);
		sutRight.add(expectedFive);
		sutRight.add(expectedSix);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(sutLeft, sutRight);

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

		LinkedList<Integer> sutLeft = new LinkedList<>(expectedHead);
		sutLeft.add(expectedTwo);
		sutLeft.add(expectedThree);
		sutLeft.add(expectedFour);
		sutLeft.add(expectedFive);
		sutLeft.add(expectedSix);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(sutLeft, null);

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

		LinkedList<Integer> sutRight = new LinkedList<>(expectedHead);
		sutRight.add(expectedTwo);
		sutRight.add(expectedThree);
		sutRight.add(expectedFour);
		sutRight.add(expectedFive);
		sutRight.add(expectedSix);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(null, sutRight);

		assertNotNull(actualResult);
		assertEquals(expectedSize, actualResult.getSize());
	}

	@Test
	void test_bothLLNull_ReturnNullWithoutError() {
		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(null, null);
		assertNull(actualResult);
	}

	@Test
	void test_linkedList_CanCountItsOwnNodes() {
		int expectedHead = 1;
		int expectedTwo = 2;
		int expectedThree = 3;
		int expectedFour = 4;
		int expectedFive = 5;
		int expectedSix = 6;

		LinkedList<Integer> sut = new LinkedList<>(null);
		assertEquals(0, sut.getSize());

		sut = new LinkedList<>(expectedHead);
		assertEquals(expectedHead, sut.getSize());
		sut.add(expectedTwo);
		assertEquals(expectedTwo, sut.getSize());
		sut.add(expectedThree);
		assertEquals(expectedThree, sut.getSize());
		sut.add(expectedFour);
		assertEquals(expectedFour, sut.getSize());
		sut.add(expectedFive);
		assertEquals(expectedFive, sut.getSize());
		sut.add(expectedSix);
		assertEquals(expectedSix, sut.getSize());
	}

}
