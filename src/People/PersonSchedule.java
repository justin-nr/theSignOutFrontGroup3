package People;

import java.util.ArrayList;
import java.util.Random;

public class PersonSchedule {
    ArrayList<PersonScheduleBlock> schedule = new ArrayList<>();
    Person person;

    public PersonSchedule(Person person) {
        this.person = person;
    }

    public void reset() {
        // Just reset the shit for next day
        for (PersonScheduleBlock block : schedule) {
            if (block.events != null) {
                for (PersonScheduleBlockEvent event : block.events) {
                    event.happened = false;
                }
            }
        }
    }

    public void generate(Random random) {
        switch (person.role) {
            case STUDENT:
                int studentHours = PersonConstants.HOURS_PER_DAY;
                int hoursCache;
                boolean nightOwl = false;

                // Students sometimes stay up to 1-2 in the morning
                if (random.nextInt(100) < 50) {
                    nightOwl = true;
                    hoursCache = random.nextInt(2) + 1;
                    schedule.add(new PersonScheduleBlock("Free time", hoursCache)); // max: 2
                    studentHours -= hoursCache;
                }

                // At least 5 hours of sleep
                hoursCache = random.nextInt(5, 8);
                schedule.add(new PersonScheduleBlock("Sleep", hoursCache)); // max: 7
                studentHours -= hoursCache;

                // An hour to get ready
                schedule.add(new PersonScheduleBlock("Wakeup", 1)); // 1
                studentHours--;

                // AT SCHOOL!!!
                hoursCache = random.nextInt(5, 10); // max: 9
                PersonScheduleBlock school = new PersonScheduleBlock("School", hoursCache);

                // just realized both these lambda functions are the same, optimize later
                // At the start of the schedule block, run an event for coming
                school.events.add(new PersonScheduleBlockEvent(
                        "SchoolEntering",
                        PersonScheduleBlockEventTime.START,
                        (person, second) -> {
                            person.signVisible = true;
                            person.seenSign = true;
                            person.collectiveSignViewTime += new Random().nextInt(1, 5);
                            System.out.println("Someone (Coming) began seeing the sign at second: " + second);
                        }));

                // At the end of the schedule block, run an event for leaving
                school.events.add(new PersonScheduleBlockEvent(
                        "SchoolExiting",
                        PersonScheduleBlockEventTime.END,
                        (person, second) -> {
                            person.signVisible = true;
                            person.seenSign = true;
                            person.collectiveSignViewTime += new Random().nextInt(1, 5);
                            System.out.println("Someone (Leaving) began seeing the sign at second: " + second);
                        }));

                schedule.add(school);
                studentHours -= hoursCache;

                // Some students stay up late
                if (!nightOwl && random.nextInt(100) < 50) {
                    int studentHoursSleep = (int)(studentHours * random.nextFloat(0.25f, 0.76f));
                    schedule.add(new PersonScheduleBlock("Free time", studentHours - studentHoursSleep));
                    schedule.add(new PersonScheduleBlock("Sleep", studentHoursSleep));
                } else {
                    schedule.add(new PersonScheduleBlock("Free time", studentHours));
                }

                break;
            case STAFF:
                // Who knows?????
                schedule.add(new PersonScheduleBlock("Placeholder", 24));
                break;
        }
    }
}
