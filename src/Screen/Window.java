package Screen;

import javax.swing.*;
import java.awt.*;

public class Window {
    public JFrame frame;

    public Window(String title) {
        frame = new JFrame(title);
        frame.setName(title);
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
