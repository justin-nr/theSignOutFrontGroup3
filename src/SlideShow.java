public class SlideShow {
    int slideNumber;
    LinkedList list;

    SlideShow() { // OMG OMG WE MADE A SLIDE!!!! 🤯🤯🤯🤯🤯
        slideNumber = 0;
        list = new LinkedList();
    }
    SlideShow(String[] intialdata, float uptime) { // Slide show with info
        list = new LinkedList();
        for (int i = 0; i < intialdata.length; i++) {
            String toAdd = intialdata[i];
            list.append(toAdd, uptime);
        }
    }
}