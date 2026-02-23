import People.PeopleProcessExample;
import People.PersonNode;
import People.PersonRole;
import Queue.Queue;
import Screen.Screen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(new PersonNode(PersonRole.STUDENT));
        queue.append(new PersonNode(PersonRole.STUDENT));

        //shows window
        Screen screen = new Screen();
        screen.window.frame.setVisible(false);

        int amount = -1;
        int percent = -1;

//        System.out.println(screen.createOptionMessage("How many people will be simulated:"));

        while (amount <= -1) {
            boolean success = false;
            try {
                String hold = screen.createOptionMessage("How many people will be simulated:");
                System.out.println(hold==null);
                if (hold == null)  {
                    System.exit(0);
                } else  {
                    amount = Integer.parseInt(hold);
                    success = true;
                }
            } catch (NumberFormatException e) {
                screen.showPopUp("There has been an error, please fill out the info box correctly. (must be greater than or equal to 0)");
//                throw e;
            }

            if (amount <= -1 && success) {
                screen.showPopUp("There has been an error, please fill out the info box correctly. (must be greater than or equal to 0)");
            }
        }
        while (percent <= -1 | percent > 100) {
            boolean success = false;
            try {
                String hold = screen.createOptionMessage("Percent of people paying attention: (0 -> 100)");
                System.out.println(hold==null);
                if (hold == null) {
                    System.exit(0);
                } else  {
                    percent = Integer.parseInt(hold);
                    success = true;
                }
            } catch (NumberFormatException e) {
                screen.showPopUp("There has been an error, please fill out the info box correctly. (Do not add a % at the end and keep it within the 0 - 100 range!)");
            }

            if (percent <= -1 | percent > 100) {
                screen.showPopUp("There has been an error, please fill out the info box correctly. (Do not add a % at the end and keep it within the 0 - 100 range!)");
            }
        }

        Process process = new Process(amount, 20, percent);
        screen.resultsWindow(process.processDay(5));
        System.exit(0);
    }
}
