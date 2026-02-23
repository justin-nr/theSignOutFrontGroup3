package SlideShow;

public class LinkedList {
    public SlideShowNode head;

    // Empty Constructor.
    public LinkedList() {}
    // Constructor with base info.
    LinkedList(String contents, float upTime){
        head = new SlideShowNode(contents, upTime);
        head.next = head;
    }

    // Appends the Keiths_BIG_Package.LinkedList with new info.
    public void append(String contents, float upTime) {
        if (head != null) {
            SlideShowNode currentNode = head;
            while (currentNode.next != head) {
                currentNode = currentNode.next;
            }
            SlideShowNode node = new SlideShowNode(contents, upTime);
            currentNode.next = node;
            node.next = head;
        } else {
            head = new SlideShowNode(contents, upTime);
            head.next = head;
        }
    }

    // append at a specific position
    public void insert(String contents, int position, float upTime) {
        SlideShowNode currentNode = head;
        SlideShowNode lastNode = null;
        int pos = 0;

        while (currentNode.next != null && currentNode.next != head && pos != position) {
            lastNode = currentNode;
            currentNode = currentNode.next;
            pos++;
        }

        SlideShowNode newNode = new SlideShowNode(contents, upTime);
        assert lastNode != null;
        lastNode.next = newNode;
        newNode.next = currentNode;
    }

    public int getNodeCount() {
        int value = 0;
        SlideShowNode currentNode = head;

        while (currentNode.next != null && currentNode.next != head) {
            value += 1;
            currentNode = currentNode.next;
        }

        value += 1;

        return value;
    }

    //Gets last node in the linked list
    public SlideShowNode getLastNode() {
        SlideShowNode currentNode = head;

        while (currentNode.next != null && currentNode.next != head) {
            currentNode = currentNode.next;
        }

        return  currentNode;
    }
}

