package Screen;

import javax.swing.*;

public class Window {
    public JFrame frame;

    public Window(String title) {
        frame = new JFrame(title);
        frame.setName(title);
        frame.setSize(650, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
