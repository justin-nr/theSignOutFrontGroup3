package Screen;

import javax.swing.*;

public class Screen {

    public Window window;

    public Screen() {
        window = new Window("No Title");
    }

    public Screen(String title) {
        window = new Window(title);
    }

    public int createOptionConfirmation(String question) {
        return JOptionPane.showConfirmDialog(window.frame, question);
    }

    public String createOptionMessage(String question) {
        return JOptionPane.showInputDialog(window.frame, question);
    }

    public void showPopUp(String message) {
        JOptionPane.showMessageDialog(window.frame, message);
    }
}
