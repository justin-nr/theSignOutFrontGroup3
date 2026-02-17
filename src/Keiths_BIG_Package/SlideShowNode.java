package Keiths_BIG_Package;

public class SlideShowNode {
    public SlideShowNode next;
    public String data;
    float upTime;

    // Keiths_BIG_Package.Node constructor.
    public SlideShowNode(String contents, float slideUpTime) {
        upTime = slideUpTime;
        data = contents;
    }
}
