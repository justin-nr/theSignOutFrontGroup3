package SlideShow;

import Queue.Node;

public class SlideShow {
    int slideNumber;
    SlideShowNode currentSlide;
    int slides;
    LinkedList list;
    public int size; // keith why didn't you add this bro

    public SlideShow() { // OMG OMG WE MADE A SLIDE!!!! 🤯🤯🤯🤯🤯
        slideNumber = 0;
        list = new LinkedList();
        size = 0;
    }

    public SlideShow(String[] initialData, float uptime) { // Slide show with info
        list = new LinkedList();

        size = initialData.length;
        for (int i = 0; i < initialData.length; i++) {
            String toAdd = initialData[i];
            list.append(toAdd, uptime);
        }

        currentSlide = list.head;
    }

    public void nextSlide() {
        slideNumber++;

        list.head = list.head.next;

        currentSlide = list.head;
    }

    public void insert(String info, int position, float upTime) {
        list.insert(info, position, upTime);
    }

    public void append(String info, float upTime) {
        list.append(info, upTime);
    }

    public SlideShowNode getNodeFromCurrentSecond (int second) {
        SlideShowNode currentNode = list.head;
        int timePassed = 0;
        int timeSpentOnSlide = 0;

        while (timePassed < second) {
            timePassed ++;
            timeSpentOnSlide ++;

            if (currentNode.upTime < timeSpentOnSlide) {
                currentNode = currentNode.next;
                timeSpentOnSlide = 0;
            }
        }
        return currentNode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        SlideShowNode currentNode = list.head;

        while (currentNode.next != null && currentNode.next != list.head) {
            builder.append(currentNode.data).append(" -> ");
            currentNode = currentNode.next;
        }
        builder.append(currentNode.data).append(" -> ");
        if (currentNode.next == list.head) {
            builder.append("(Circle Linked List)");
        } else {
            builder.append("nil");
        }

        return builder.toString();
    }
}