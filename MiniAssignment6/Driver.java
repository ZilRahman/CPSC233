/**
 * Driver class that runs the program. Includes the starting point.
 */
public class Driver {
    public static void main(String[] args) {

        // Create nodes, you can create as many nodes as you like here.
        Node last = new Node(2);
        Node second = new Node(4, last);
        Node first = new Node(5, second);

        // Instantiate the manager
        Manager aManager = new Manager(first);

        // By the end of the program these methods should print to the CLI
        aManager.display();
        aManager.displayOverCutOff();
    }
}
