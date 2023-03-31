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
		System.out.printf("Updates Count Correctly LL: %s%n", linkedList);
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
		System.out.printf("Same Sized LL LEFT: %s%n", sutLeft);

		LinkedList<Integer> sutRight = new LinkedList<>(expectedTwo);
		sutRight.add(expectedFour);
		sutRight.add(expectedSix);
		System.out.printf("Same Sized LL RIGHT: %s%n", sutRight);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(sutLeft, sutRight);

		System.out.printf("Same Sized LL Result: %s%n", actualResult);
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
		System.out.printf("First Larger Than Second Left LL: %s%n", sutLeft);

		LinkedList<Integer> sutRight = new LinkedList<>(expectedTwo);
		sutRight.add(expectedFour);
		System.out.printf("First Larger Than Second Right LL: %s%n", sutRight);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(sutLeft, sutRight);

		System.out.printf("First Larger Than Second Result LL: %s%n", actualResult);
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
		System.out.printf("Second Larger Than First Left LL: %s%n", sutLeft);

		LinkedList<Integer> sutRight = new LinkedList<>(expectedTwo);
		sutRight.add(expectedFour);
		sutRight.add(expectedFive);
		sutRight.add(expectedSix);
		System.out.printf("Second Larger Than First Right LL: %s%n", sutRight);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(sutLeft, sutRight);

		System.out.printf("Second Larger Than First Result LL: %s%n", actualResult);
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
		System.out.printf("First Has Nodes Second Is Null Left LL: %s%n", sutLeft);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(sutLeft, null);
		System.out.printf("First Has Nodes Second Is Null Result LL: %s%n", actualResult);

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
		System.out.printf("First Nul Second Has Nodes Right LL: %s%n", sutRight);

		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(null, sutRight);
		System.out.printf("First Nul Second Has Nodes Result LL: %s%n", actualResult);

		assertNotNull(actualResult);
		assertEquals(expectedSize, actualResult.getSize());
	}

	@Test
	void test_bothLLNull_ReturnNullWithoutError() {
		LinkedListZipper<Integer> llz = new LinkedListZipper<>();
		var actualResult = llz.zipLinkedLists(null, null);
		System.out.printf("Returns Null LL without Error: %s%n", actualResult);
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
		System.out.printf("Can Count Own Nodes SUT: %s%n", sut);
		assertEquals(expectedHead, sut.getSize());
		sut.add(expectedTwo);
		System.out.printf("Can Count Own Nodes SUT: %s%n", sut);
		assertEquals(expectedTwo, sut.getSize());
		sut.add(expectedThree);
		System.out.printf("Can Count Own Nodes SUT: %s%n", sut);
		assertEquals(expectedThree, sut.getSize());
		sut.add(expectedFour);
		System.out.printf("Can Count Own Nodes SUT: %s%n", sut);
		assertEquals(expectedFour, sut.getSize());
		sut.add(expectedFive);
		System.out.printf("Can Count Own Nodes SUT: %s%n", sut);
		assertEquals(expectedFive, sut.getSize());
		sut.add(expectedSix);
		System.out.printf("Can Count Own Nodes SUT: %s%n", sut);
		assertEquals(expectedSix, sut.getSize());
	}

}
