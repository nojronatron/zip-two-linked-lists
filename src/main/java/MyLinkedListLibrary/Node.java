package MyLinkedListLibrary;

public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> previous;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        String previousRef = "";
        String nextRef = "";
        if (this.previous != null) {
            previousRef = "<-";
        }
//        if (this.next != null) {
//            nextRef = "->";
//        }
        return String.format("%s[%s]%s->", previousRef, this.value, nextRef);
    }
}
