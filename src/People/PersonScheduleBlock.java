package People;

import java.util.ArrayList;

public class PersonScheduleBlock {
    String label;
    int hours;
    ArrayList<PersonScheduleBlockEvent> events;
    public PersonScheduleBlock(String label, int hours) {
        this.label = label;
        this.hours = hours;
        events = new ArrayList<>();
    }
}
