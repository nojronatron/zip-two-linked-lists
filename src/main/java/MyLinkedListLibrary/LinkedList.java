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
        this.nodeCount = 0;

        if (this.head == null || this.head.getValue() == null) {
            return this.nodeCount;
        }

        Node<T> current = head;

        while (current != null) {
            this.nodeCount++;
            current = current.getNext();
        }

        return this.nodeCount;
    }

    public boolean add(T value) {
        Node<T> newNode = new Node<>(value);

        if (this.head == null) {
            this.head = newNode;
            this.nodeCount++;
            return true;
        }

        Node<T> currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            } else {
                currentNode.setNext(newNode);
                this.nodeCount++;
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString(){
        if (this.nodeCount < 1) {
            return "";
        }
        StringBuilder nodes = new StringBuilder("(head)-");
        Node<T> currentNode = this.head;
        while (currentNode != null){
            nodes.append(currentNode);
            currentNode = currentNode.getNext();
        }
        nodes.append("NULL");
        return nodes.toString();
    }
}
