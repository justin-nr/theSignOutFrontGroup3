import People.PersonNode;
import People.PersonRole;
import Queue.Queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(new PersonNode(PersonRole.STUDENT));
        queue.append(new PersonNode(PersonRole.STUDENT));
    }
}
