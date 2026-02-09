package People;

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

    public PeopleProcessExample(int maxPeople, int percentPayingAttention) {
        people = new ArrayList<>();
        random = new Random();

        for (int i = 0; i < maxPeople; i++) {
            Person person = new Person(PersonRole.STUDENT, percentPayingAttention);
            person.schedule.generate(random);

            people.add(person);
        }
    }

    //    public void processDay() {
//        int secondIncrements = 5;
//
//        for (int second = 0; second < PersonConstants.SECONDS_PER_HOUR * PersonConstants.HOURS_PER_DAY; second += secondIncrements) {
//            for (Person person : people) {
//                // Simulate every second for every person every day
//                person.process(second);
//
//                // generic ahh sign seeing thing, wanna track the slides and shit in the future...
//                if (person.signVisible) {
//                    person.secondsSignVisible -= secondIncrements;
//                    if (person.secondsSignVisible <= 0) {
//                        person.signVisible = false;
//                        person.secondsSignVisible = person.secondsSignVisibleMaximum;
//                    }
//                }
//            }
//        }
//
//        for (Person person : people) {
//            System.out.println(person);
//            person.schedule.reset();
//        }
//    }

    //makes the results into a string
    public String processDay() {
        StringBuilder results = new StringBuilder();
        int secondIncrements = 5;

        for (int second = 0; second < PersonConstants.SECONDS_PER_HOUR
                * PersonConstants.HOURS_PER_DAY; second += secondIncrements) {
            for (Person person : people) {
                person.process(second);

                if (person.signVisible) {
                    person.secondsSignVisible -= second;
                    if (person.secondsSignVisible < 0) {
                        person.signVisible = false;
                        person.secondsSignVisible = person.secondsSignVisible;
                    }
                }
            }
        }
        results.append("Results\n");
        results.append("------------------\n");

        for (Person person : people) {
            results.append(person.toString()).append("\n");
            person.schedule.reset();
        }
        return results.toString();
    }
}

