package MyLinkedListLibrary;

public class LinkedList<T> {
    private Node<T> head = null;
    private int nodeCount = 0;

    public LinkedList(T value) {
        this.head = new Node<T>(value);
        this.nodeCount++;
    }

    public Node<T> getHead() {
        return head;
    }

    public int getSize() {
        return this.nodeCount;
    }

    public boolean add(T value) {
        Node<T> newNode = new Node<>(value);

        if (this.head == null) {
            this.head = newNode;
            return true;
        }

        Node<T> currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            } else {
                currentNode.setNext(newNode);
                return true;
            }
        }

        return false;
    }
}
