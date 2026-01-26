package Keiths_BIG_Package;

public class Node {
    public Node next;
    public String data;
    float upTime;

    // Keiths_BIG_Package.Node constructor.
    public Node(String contents, float slideUpTime) {
        upTime = slideUpTime;
        data = contents;
    }
}
