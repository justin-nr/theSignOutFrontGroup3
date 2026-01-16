package People;

public class PersonScheduleBlockEvent {
    String label;
    PersonScheduleBlockEventTime time;
    PersonScheduleBlockEventMethod method;
    boolean happened;
    public PersonScheduleBlockEvent(String label, PersonScheduleBlockEventTime time, PersonScheduleBlockEventMethod method){
        this.label = label;
        this.time = time; // if it's emitted at beginning or end
        this.method = method;
        this.happened = false;
    }
}
