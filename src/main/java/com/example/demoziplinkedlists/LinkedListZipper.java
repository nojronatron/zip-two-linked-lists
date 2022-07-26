package com.example.demoziplinkedlists;

import MyLinkedListLibrary.LinkedList;
import MyLinkedListLibrary.Node;

public class LinkedListZipper<T> {

    public LinkedList<T> zipLinkedLists(LinkedList<T> linkedListLeft, LinkedList<T> linkedListRight) {
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
        
        return null;
    }
}
