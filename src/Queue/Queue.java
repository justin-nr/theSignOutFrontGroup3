package Queue;

public class Queue {

    Node head = null;

    Queue() {
        head = null;
    }

    Queue(String contents) {
        head = new Node(contents);
    }

    //append class
    void append(String contents) {
        System.out.println("Adding " + contents);
        if (head == null) {
            head = new Node(contents);
        }else{
            Node currentNode = head;
            while (currentNode.next !=null){
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(contents);
        }
    }

    //overrides & makes info to string
    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        Node currentNode = head;
        while (currentNode != null) {
            returnString.append(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        return returnString.toString();
    }
}

//Node class
class Node {
    String data;
    Node next = null;

    Node(String contents) {
        data = contents;

    }
}