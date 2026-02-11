package Screen;

import javax.swing.*;
import java.awt.*;

public class Screen {

    public Window window;

    public Screen() {
        window = new Window("Results");
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

    //window for the results of simulation
    public void resultsWindow(String results) {
        //self explanatory i think
        JTextArea textArea = new JTextArea(results);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        //lets ya scroll
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(1000, 500));

        //shows everything
        JOptionPane.showMessageDialog(
                window.frame,
                scrollPane,
                "Results",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


}
