package Queue;

public class Queue {
    public Node head;

    public Queue() {
        head = null;
    }

    public Queue(Node head) {
        this.head = head;
    }

    //append class
    public void append(Node node) {
        // System.out.println("Adding " + node.toString());
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                // System.out.println(currentNode.toString());
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }

    public Node popHead() {
        Node head = this.head;
        this.head = this.head.next;
        return head;
    }

    //overrides & makes info to string
    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        Node currentNode = head;
        while (currentNode != null) {
            returnString.append(currentNode.toString() + " -> ");
            currentNode = currentNode.next;
        }
        return returnString.toString();
    }
}

