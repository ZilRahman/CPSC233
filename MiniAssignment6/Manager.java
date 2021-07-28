public class Manager {

    private final int CUT_OFF = 3;

    private Node list;

    /**
     * Manager constructor
     */
    public Manager() {
        this.list = null;
    }

    /**
     * Manager constructor with an element.
     * 
     * @param head
     */
    public Manager(Node head) {
        this.list = head;
    }

    /**
     * Adds an element to the last node of the list. If the list is null, then it
     * will set it as the first element instead.
     * 
     * @param node
     */
    public void addElement(Node node) {
        if (list != null) {
            // Grab first element
            Node head = list;

            do {
                // If next element is
                if (head.getNext() == null) {
                    head.setNext(node);
                } else {
                    head = head.getNext();
                }
            } while (head.getNext() != null);

        } else {
            list = node;
        }
    }

    /**
     * TODO: steps through the list starting with the first node and displays the
     * data for each node (on its own line) up to and including the last node.
     */
    public void display() {

    }

    /**
     * TODO: similar to the previous method. However the data for a node will only
     * be displayed if it exceeds the cutoff which in this case is defined by the
     * named constant "CUT_OFF" in the Manager class.
     */
    public void displayOverCutOff() {

    }
}
