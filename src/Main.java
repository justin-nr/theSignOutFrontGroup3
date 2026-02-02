import Keiths_BIG_Package.SlideShow;
import People.PeopleProcessExample;
import People.Person;
import People.PersonNode;
import People.PersonRole;
import Queue.Queue;
import Screen.Screen;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(new PersonNode(PersonRole.STUDENT));
        queue.append(new PersonNode(PersonRole.STUDENT));

        //shows window
        Screen screen = new Screen();
        screen.window.frame.setVisible(true);

        int amount = -1;
        int percent = -1;

        while (amount <= -1) {
            boolean success = false;
            try {
                amount = Integer.parseInt(screen.createOptionMessage("How many people will be simulated:"));
                success = true;
            } catch (NumberFormatException e) {
                screen.showPopUp("There has been an error, please fill out the info box correctly. (must be greater than or equal to 0)");
            }

            if (amount <= -1 && success) {
                screen.showPopUp("There has been an error, please fill out the info box correctly. (must be greater than or equal to 0)");
            }
        }
        while (percent <= -1 | percent > 100) {
            boolean success = false;
            try {
                percent = Integer.parseInt(screen.createOptionMessage("Percent of people paying attention: (0 -> 100)"));
                success = true;
            } catch (NumberFormatException e) {
                screen.showPopUp("There has been an error, please fill out the info box correctly. (Do not add a % at the end and keep it within the 0 - 100 range!)");
            }

            if (percent <= -1 | percent > 100) {
                screen.showPopUp("There has been an error, please fill out the info box correctly. (Do not add a % at the end and keep it within the 0 - 100 range!)");
            }
        }
        SlideShow show = new SlideShow();
        show.append("Diddy's Party", 12);
        show.append("Prison", 12);
        show.append("Vacation Slide", 12);
        show.append("Thuggin Club", 12);
        show.append("What, another slide just for fun.", 12);

        System.out.println(show);

        PeopleProcessExample processExample = new PeopleProcessExample(show, amount, percent);
        processExample.processDay();
    }
}
