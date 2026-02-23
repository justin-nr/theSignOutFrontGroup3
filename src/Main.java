import People.PeopleProcessExample;
import People.PersonNode;
import People.PersonRole;
import Queue.Queue;
import Screen.Screen;
import Screen.ProcessResult;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(new PersonNode(PersonRole.STUDENT));
        queue.append(new PersonNode(PersonRole.STUDENT));

        //shows window
        Screen screen = new Screen();
        screen.window.frame.setVisible(false);

        int numberOfSlides = screen.requestInt("How many slides are up on the sign on any given day?", "Please enter a realistic number.", 1, 1500);
        int amount = screen.requestInt("How many students are estimated to pass the sign each day?", "Please enter a realistic number.", 1, 500);
        int percentPayingAttention = screen.requestInt("What percent of students are estimated to pay attention to the sign?", "Please enter a percentage between 0 and 100.", 0, 100);

        String[] modeOptions = {
                "Day",
                "Week",
                "Cancel"
        };

        int modeSelection = JOptionPane.showOptionDialog(
                screen.window.frame,
                "Would you like to simulate a day or a week?",
                "Input",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                modeOptions,
                modeOptions[0]
        );

        if (modeSelection == JOptionPane.CLOSED_OPTION || modeSelection == 2) {
            System.exit(0);
            return;
        }

        switch (modeSelection) {
            case 0:
                // Day
                Process process = new Process(amount, numberOfSlides, percentPayingAttention);
                screen.resultsWindow(process.processDay(5));
                System.exit(0);
                break;
            case 1:
                // Week
                Process processMondayWednesday = new Process(amount, numberOfSlides, percentPayingAttention);
                Process processTuesdayThursday = new Process(amount, numberOfSlides, percentPayingAttention);
                Process processFriday = new Process((int) (amount * 0.35), numberOfSlides, (int) (percentPayingAttention * 0.9));

                ProcessResult[] results = new ProcessResult[5];

                results[0] = new ProcessResult("Monday", processMondayWednesday.processDay(10));
                results[1] = new ProcessResult("Tuesday", processTuesdayThursday.processDay(10));
                results[2] = new ProcessResult("Wednesday", processMondayWednesday.processDay(10));
                results[3] = new ProcessResult("Thursday", processTuesdayThursday.processDay(10));
                results[4] = new ProcessResult("Friday", processFriday.processDay(25));

                screen.resultsWindowWeek(results);
                System.exit(0);

                break;
        }
    }
}
