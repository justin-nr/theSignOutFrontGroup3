import Keiths_BIG_Package.SlideShow;
import People.Person;
import People.PersonConstants;
import People.PersonNode;
import People.PersonRole;
import Queue.Queue;

import java.util.ArrayList;

public class Process {
    int numStudents;
    Queue students;

    SlideShow slideshow;

    public Process(int numStudents, int numSlides) {
        this.numStudents = numStudents;

        slideshow = new SlideShow();

        ArrayList<String> slideshowNames = new ArrayList<>();

        for (int i = 0; i < numSlides; i++) {
            slideshowNames.add("Slide " + i);
        }

        slideshow = new SlideShow(slideshowNames.toArray(new String[0]), 12);
    }

    public String processDay(int granularity) {
        students = new Queue();

        for (int i = 0; i < numStudents; i++) {
            // Populate the queue with student nodes
            students.append(new PersonNode(PersonRole.STUDENT));
        }

        for (int second = 0; second < PersonConstants.SECONDS_PER_HOUR * PersonConstants.HOURS_PER_DAY; second += granularity) {
            while (students.head != null) {
                // we need to FUCKING cast this stupid shit because JAVA is fucking RETARDED
                PersonNode studentNode = (PersonNode) students.popHead();
                Person student = studentNode.person;

                student.process(second);

                if (student.signVisible) {
                    student.secondsSignVisible -= granularity;
                    if (student.secondsSignVisible <= 0) {
                        student.signVisible = false;
                        student.secondsSignVisible = student.secondsSignVisibleMaximum;
                    }
                }
            }
        }

        return "placeholder shitttttt";
    }
}
