package People;

import Keiths_BIG_Package.SlideShow;

import java.util.ArrayList;
import java.util.Random;

public class Person {
    PersonRole role;
    PersonSchedule schedule;
    ArrayList<String> slidesSeen;
    SlideShow show;
    boolean seenSign = false;
    boolean signVisible = false;
    boolean payingAttention;
    int secondsSignVisibleMaximum;
    int secondsSignVisible;
    int collectiveSignViewTime = 0;

    public Person(PersonRole role) {
        this.role = role;
        this.schedule = new PersonSchedule(this);
        this.secondsSignVisibleMaximum = 5;
        this.slidesSeen = new ArrayList<>();

        this.secondsSignVisible = secondsSignVisibleMaximum;

        int r = new Random().nextInt(3);
        this.payingAttention = r == 0;
    }
    public Person(PersonRole role, int percent) {
        this.role = role;
        this.schedule = new PersonSchedule(this);
        this.secondsSignVisibleMaximum = 5;
        this.slidesSeen = new ArrayList<>();

        this.secondsSignVisible = secondsSignVisibleMaximum;

        int r = new Random().nextInt(1, 100);
        this.payingAttention = r <= percent;
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
                            if (event.method != null && payingAttention) {
                                event.method.execute(this, seconds);
                            }
                        }
                    }
                }
            }

            blockStartTime = blockEndTime; // Adjust the start time for the next block
        }
    }

    @Override
    public String toString() {
        if (!seenSign) {
            return "PersonType: " + role + " | SeenSign: " + seenSign;
        } else {
            return "PersonType: " + role + " | SeenSign: " + seenSign + " | Total Sign Viewed Length: " + collectiveSignViewTime + " | SEEN: " + slidesSeen.toString();
        }
    }
}
