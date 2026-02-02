package People;

import Keiths_BIG_Package.SlideShow;

import java.util.ArrayList;
import java.util.Random;

public class PeopleProcessExample {
    ArrayList<Person> people;
    Random random;


    public PeopleProcessExample() {
        people = new ArrayList<>();
        random = new Random();

        for (int i = 0; i < 50; i++) {
            Person person = new Person(PersonRole.STUDENT);
            person.schedule.generate(random);

            people.add(person);
        }
    }

    public PeopleProcessExample(SlideShow show) {
        people = new ArrayList<>();
        random = new Random();

        for (int i = 0; i < 50; i++) {
            Person person = new Person(PersonRole.STUDENT);
            person.schedule.generate(random);
            person.show = show;

            people.add(person);
        }
    }
    public PeopleProcessExample(SlideShow show, int maxPeople, int percentPayingAttention) {
        people = new ArrayList<>();
        random = new Random();

        for (int i = 0; i < maxPeople; i++) {
            Person person = new Person(PersonRole.STUDENT, percentPayingAttention);
            person.schedule.generate(random);
            person.show = show;

            people.add(person);
        }
    }
    public void processDay() {
        int secondIncrements = 5;

        for (int second = 0; second < PersonConstants.SECONDS_PER_HOUR * PersonConstants.HOURS_PER_DAY; second += secondIncrements) {
            for (Person person : people) {
                // Simulate every second for every person every day
                person.process(second);

                // generic ahh sign seeing thing, wanna track the slides and shit in the future...
                if (person.signVisible) {
                    person.secondsSignVisible -= secondIncrements;
                    if (person.secondsSignVisible <= 0) {
                        person.signVisible = false;
                        person.secondsSignVisible = person.secondsSignVisibleMaximum;
                    }
                }
            }
        }

        for (Person person : people) {
            System.out.println(person);
            person.schedule.reset();
        }
    }
}
