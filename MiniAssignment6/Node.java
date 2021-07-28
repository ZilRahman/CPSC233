public class Node {
    private Node next;
    private int value;

    /**
     * Constructor
     * 
     * @param value
     */
    public Node(int value) {
        this.next = null;
        this.value = value;
    }

    /**
     * Constructor with a value and next element
     * 
     * @param value
     * @param next
     */
    public Node(int value, Node next) {
        this.next = next;
        this.value = value;
    }

    public void addNext(Node node) {
        this.next = node;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}