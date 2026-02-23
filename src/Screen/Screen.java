package Screen;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

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

    public int requestInt(String question, String errorText, int minimumNumber, int maximumNumber) {
        while(true) {
            try {
                String response = this.createOptionMessage(question);
                if (Objects.equals(response, "") || response == null) {
                    System.exit(0);
                }
                response = response.replace("%", "");
                int responseInteger = Integer.parseInt(response);
                if (responseInteger >= minimumNumber && responseInteger <= maximumNumber) {
                    return responseInteger;
                }

                throw new NumberFormatException();
            } catch (NumberFormatException var7) {
                this.showPopUp(errorText);
            }
        }
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
        scrollPane.setPreferredSize(new Dimension(800, 500));

        //shows everything
        JOptionPane.showMessageDialog(
                window.frame,
                scrollPane,
                "Results",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void resultsWindowWeek(ProcessResult[] results) {
        JTabbedPane tabbedPane = new JTabbedPane();

        for (ProcessResult result : results) {
            tabbedPane.addTab(result.title, createScrollableTextArea(result.result));
        }

        tabbedPane.setPreferredSize(new Dimension(800, 500));

        JOptionPane.showMessageDialog(
                window.frame,
                tabbedPane,
                "Results",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private JScrollPane createScrollableTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }
}
