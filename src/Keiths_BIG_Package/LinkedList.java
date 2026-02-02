package Keiths_BIG_Package;

public class LinkedList {
    public Node head;

    // Empty Constructor.
    public LinkedList() {}
    // Constructor with base info.
    LinkedList(String contents, float upTime){
        head = new Node(contents, upTime);
        head.next = head;
    }

    // Appends the Keiths_BIG_Package.LinkedList with new info.
    public void append(String contents, float upTime) {
        if (head != null) {
            Node currentNode = head;
            while (currentNode.next != head) {
                currentNode = currentNode.next;
            }
            Node node = new Node(contents, upTime);
            currentNode.next = node;
            node.next = head;
        } else {
            head = new Node(contents, upTime);
            head.next = head;
        }
    }

    // append at a specific position
    public void insert(String contents, int position, float upTime) {
        Node currentNode = head;
        Node lastNode = null;
        int pos = 0;

        while (currentNode.next != null && currentNode.next != head && pos != position) {
            lastNode = currentNode;
            currentNode = currentNode.next;
            pos++;
        }

        Node newNode = new Node(contents, upTime);
        assert lastNode != null;
        lastNode.next = newNode;
        newNode.next = currentNode;
    }

    // connects the end to the beginning
    public void connectEndToHead() {
        Node current = head;
        while (current.next != head && current.next != null) {
            current = current.next;
        }
        current.next = head;
    }


    public int getNodeCount() {
        int value = 0;
        Node currentNode = head;

        while (currentNode.next != null && currentNode.next != head) {
            value += 1;
            currentNode = currentNode.next;
        }

        value += 1;

        return value;
    }

    //Gets last node in the linked list
    public Node getLastNode() {
        Node currentNode = head;

        while (currentNode.next != null && currentNode.next != head) {
            currentNode = currentNode.next;
        }

        return  currentNode;
    }
}

