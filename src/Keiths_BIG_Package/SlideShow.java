package Keiths_BIG_Package;

public class SlideShow {
    int slideNumber;
    LinkedList list;

    public SlideShow() { // OMG OMG WE MADE A SLIDE!!!! 🤯🤯🤯🤯🤯
        slideNumber = 0;
        list = new LinkedList();
    }
    public SlideShow(String[] initialData, float uptime) { // Slide show with info
        list = new LinkedList();
        for (int i = 0; i < initialData.length; i++) {
            String toAdd = initialData[i];
            list.append(toAdd, uptime);
        }
    }

    public void insert(String info, int position, float upTime) {
        list.insert(info, position, upTime);
    }

    public void append(String info, float upTime) {
        list.append(info, upTime);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node currentNode = list.head;

        while (currentNode.next != null && currentNode.next != list.head) {
            builder.append(currentNode.data).append(" -> ");
            currentNode = currentNode.next;
        }
        builder.append(currentNode.data).append(" -> ");
        builder.append("nil");

        return builder.toString();
    }
}