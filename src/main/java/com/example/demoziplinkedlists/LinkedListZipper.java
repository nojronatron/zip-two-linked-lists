package com.example.demoziplinkedlists;

import MyLinkedListLibrary.LinkedList;
import MyLinkedListLibrary.Node;

public class LinkedListZipper<T> {

    public LinkedList<T> zipLinkedLists(LinkedList<T> linkedListLeft, LinkedList<T> linkedListRight) {
        if (linkedListLeft == null && linkedListRight == null) {
            return null;
        }

        if (linkedListLeft == null && linkedListRight != null) {
            if (linkedListRight.getHead() != null) {
                return linkedListRight;
            } else {
                return null;
            }
        }

        if (linkedListLeft != null && linkedListRight == null) {
            if (linkedListLeft.getHead() != null) {
                return linkedListLeft;
            } else {
                return null;
            }
        }

        assert linkedListLeft != null;
        assert linkedListRight != null;
        Node<T> temp1 = linkedListLeft.getHead();
        Node<T> temp2 = linkedListRight.getHead();
        Node<T> temp3 = temp1.getNext();
        Node<T> temp4 = temp2.getNext();

        while (temp1 != null) {
            temp1.setNext(temp2);
            temp2.setNext(temp3);

            // if temp3 is null but temp3 has value point temp2 to temp4 and return leftLinkedList
            if (temp3 == null) {
                temp2.setNext(temp4);
                return linkedListLeft;
            }

            // if temp3 has value and temp4 is null
            if (temp4 == null) {
                return linkedListLeft;
            }

            temp1 = temp3;
            temp2 = temp4;
            temp3 = temp3.getNext();
            temp4 = temp4.getNext();
        }

        return null;
    }
}
