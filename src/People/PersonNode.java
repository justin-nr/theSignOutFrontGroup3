package People;

import Queue.Node;

import java.util.Random;

public class PersonNode extends Node {
    public Person person;

    public PersonNode(PersonRole role) {
        super();

        person = new Person(role);
        // REPLACE THIS SHIT PLEASE IT IS TERRIBLE
        person.schedule.generate(new Random());
    }

    public PersonNode(PersonRole role, int percentPayingAttention) {
        super();

        person = new Person(role, percentPayingAttention);
        person.schedule.generate(new Random());
    }

    @Override
    public String toString() {
        // placeholder
        return "";
    }
}
