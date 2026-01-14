public class SlideShow {
    SlideShow() {

    }
}

class LinkedList {
    Node head;

    // Empty Constructor.
    LinkedList() {}
    // Constructor with base info.
    LinkedList(String contents){
        head = new Node(contents);
        head.next = head;
    }

    // Appends the LinkedList with new info.
    public void append(String contents) {
        if (head != null) {
            Node currentNode = head;
            while (currentNode.next != head) {
                currentNode = currentNode.next;
            }
            Node node = new Node(contents);
            currentNode.next = node;
            node.next = head;
        } else {
            head = new Node(contents);
            head.next = head;
        }
    }
}

class Node {
    Node next;
    String data;

    // Node constructor.
    Node(String contents) {
        data = contents;
    }
}