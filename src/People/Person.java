package People;

public class Person {
    PersonRole role;
    PersonSchedule schedule;
    boolean signVisible = false;
    int secondsSignVisibleMaximum;
    int secondsSignVisible;

    public Person(PersonRole role) {
        this.role = role;
        this.schedule = new PersonSchedule(this);
        this.secondsSignVisibleMaximum = 5;

        this.secondsSignVisible = secondsSignVisibleMaximum;
    }

    public void process(int seconds) {
        int blockStartTime = 0;

        for (PersonScheduleBlock block : schedule.schedule) {
            int blockDuration = block.hours * PersonConstants.SECONDS_PER_HOUR; // Total time schedule block takes to complete
            int blockEndTime = blockStartTime + blockDuration; // Time it ends (seconds)

            if (block.events != null) {
                for (PersonScheduleBlockEvent event : block.events) {
                    if (!event.happened) {
                        boolean shouldHappen = false;

                        // Could use a switch statement for this probably
                        if (event.time == PersonScheduleBlockEventTime.START) {
                            if (seconds >= blockStartTime) { // The event should've happened already
                                shouldHappen = true;
                            }
                        } else if (event.time == PersonScheduleBlockEventTime.END) {
                            if (seconds >= blockEndTime) { // Event should've ended already
                                shouldHappen = true;
                            }
                        }

                        if (shouldHappen) {
                            // Execute the event!
                            event.happened = true;
                            if (event.method != null) {
                                event.method.execute(this, seconds);
                            }
                        }
                    }
                }
            }

            blockStartTime = blockEndTime; // Adjust the start time for the next block
        }
    }
}
