public class SlideShow {
    int slideNumber;
    LinkedList list;

    SlideShow() {
        slideNumber = 0;
        list = new LinkedList();
    }
    SlideShow(String[] intdata, float uptime) {
        list = new LinkedList();
        for (int i = 0; i < intdata.length; i++) {
            String toAdd = intdata[i];
            list.append(toAdd, uptime);
        }
    }
}

class LinkedList {
    Node head;

    // Empty Constructor.
    LinkedList() {}
    // Constructor with base info.
    LinkedList(String contents, float upTime){
        head = new Node(contents, upTime);
        head.next = head;
    }

    // Appends the LinkedList with new info.
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
        lastNode.next = newNode;
        newNode.next = currentNode;
    }

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

    public Node getLastNode() {
        Node currentNode = head;

        while (currentNode.next != null && currentNode.next != head) {
            currentNode = currentNode.next;
        }

        return  currentNode;
    }
}

class Node {
    Node next;
    String data;
    float upTime;

    // Node constructor.
    Node(String contents, float slideUpTime) {
        upTime = slideUpTime;
        data = contents;
    }
}