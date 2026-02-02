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

        int amount;

        try {
            amount = Integer.parseInt(screen.createOptionMessage("Possible, sightings:"));
        } catch (NumberFormatException e) {
            screen.showPopUp("There has been an error, please fill out the info box correctly.");
            screen.window.frame.dispose();
//            throw new RuntimeException(e);
        }
    }
}
