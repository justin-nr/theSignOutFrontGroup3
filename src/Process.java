import SlideShow.SlideShowNode;
import SlideShow.SlideShow;
import People.Person;
import People.PersonConstants;
import People.PersonNode;
import People.PersonRole;
import Queue.Queue;
import Queue.Node;

import java.util.ArrayList;

public class Process {
    int numStudents;
    int percentPayingAttention;
    Queue students;

    SlideShow slideshow;
    public ArrayList<String> slidesSeenEveryone;

    public Process(int numStudents, int numSlides, int percentPayingAttention) {
        this.numStudents = numStudents;
        this.percentPayingAttention = percentPayingAttention;

        slideshow = new SlideShow();

        slidesSeenEveryone = new ArrayList<>();

        ArrayList<String> slideshowNames = new ArrayList<>();

        for (int i = 0; i < numSlides; i++) {
            slideshowNames.add("Slide " + i);
        }

        slideshow = new SlideShow(slideshowNames.toArray(new String[0]), 12);
    }

    public String processDay(int granularity) {
        students = new Queue();
        for (int i = 0; i < numStudents; i++) {
            PersonNode studentNode = new PersonNode(PersonRole.STUDENT, percentPayingAttention);
            studentNode.person.setShow(slideshow);
            students.append(studentNode);
        }

        for (int second = 0; second < PersonConstants.SECONDS_PER_HOUR * PersonConstants.HOURS_PER_DAY; second += granularity) {
            for (int i = 0; i < numStudents; i++) {
                if (students.head == null) {
                    break;
                }

                PersonNode studentNode = (PersonNode) students.popHead();
                Person student = studentNode.person;

                student.process(second);

                if (student.signVisible) {
                    SlideShowNode previousNode = new SlideShowNode("", 0);
                    while (student.secondsSignVisible > 0) {
                        student.secondsSignVisible--;

                        SlideShowNode node = slideshow.getNodeFromCurrentSecond(second + (student.secondsSignVisibleMaximum - student.secondsSignVisible));
                        if (node != previousNode) {
                            if (!student.slidesSeen.contains(node.data)) {
                                student.slidesSeen.add(node.data);
                            }
                            previousNode = node;
                        }
                        if (!slidesSeenEveryone.contains(node.data)) {
                            slidesSeenEveryone.add(node.data);
                            System.out.println("DASHDSAASDHHASDIHASDIUGASDIUGYIUYGAFSDIUSADGGUYI");
                        }
                    }
                    student.signVisible = false;
                    student.secondsSignVisible = student.secondsSignVisibleMaximum;
                }

                studentNode.next = null;
                students.append(studentNode);
            }
        }

        StringBuilder results = new StringBuilder();
        results.append("Broad Results\n");
        results.append("------------------\n");

        double aggregatePercentage = 0;
        int studentCount = 0;

        Node statsNode = students.head;
        while (statsNode != null) {
            Person student = ((PersonNode) statsNode).person;

            double seenCount = student.slidesSeen.size();
            double percentSeen = (seenCount / slideshow.size) * 100.0;

            aggregatePercentage += percentSeen;
            studentCount++;
            statsNode = statsNode.next;
        }

        double averageSeen = (studentCount > 0) ? (aggregatePercentage / studentCount) : 0;

        results.append("Average slide percentage seen by a student today: ").append(averageSeen).append("%").append("\n");
        results.append("Total percentage of slides seen by all students today: ").append(((float) slidesSeenEveryone.size() / slideshow.size) * 100f).append("%");
        results.append("\n\nFine Results\n");
        results.append("------------------\n");

        Node currentNode = students.head;
        while (currentNode != null) {
            PersonNode studentNode = (PersonNode) currentNode;
            results.append(studentNode.person.toString()).append("\n");
            studentNode.person.schedule.reset();
            currentNode = currentNode.next;
        }

        return results.toString();
    }
}
