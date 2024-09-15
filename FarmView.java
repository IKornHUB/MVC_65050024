import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FarmView extends JFrame {
    private JTextField inputField = new JTextField(10);
    private JButton submitButton = new JButton("Submit");
    private JTextArea displayArea = new JTextArea(20, 60);
    private JButton kickGoatButton = new JButton("Kick the Goat :)");
    private JButton milkedButton = new JButton("Milked!");

    public FarmView() {
        setTitle("Farm Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter COW ID:"));
        panel.add(inputField);
        panel.add(submitButton);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        panel.add(scrollPane);
        add(panel, BorderLayout.CENTER);

        // Initially, the kick goat and milked buttons are hidden
        kickGoatButton.setVisible(false);
        milkedButton.setVisible(false);

        // Adding buttons to a separate panel for better layout control
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(kickGoatButton);
        buttonPanel.add(milkedButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public String getInput() {
        return inputField.getText();
    }

    public void setDisplayText(String text) {
        displayArea.setText(text);
    }

    public void showGoatView() {
        kickGoatButton.setVisible(true);
        milkedButton.setVisible(false);
        displayArea.setText("It's a Goat!\n"+"⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣶⠴⣶⠷⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⣠⢞⣿⠟⣥⡟⢁⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⢿⣏⣶⣶⢷⣾⠷⣸⣿⢞⣽⢊⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠈⠻⣯⣀⡷⠖⣓⠒⣱⣟⡼⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⣠⠞⠋⠀⣨⣴⡿⠘⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⢀⣤⠴⣏⡀⠀⠀⠀⠀⠉⠀⠀⢷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠖⠻⠟⣶\r\n" + //
                        "⠸⢾⡤⠿⠃⠀⠀⠀⠀⢀⡠⠇⠸⠤⣤⣀⣀⣀⣠⡴⠒⠚⠉⠉⠉⠒⢢⣤⢷⡿\r\n" + //
                        "⠀⠸⡸⡀⠀⢀⠀⡴⣾⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣷⠈⠁\r\n" + //
                        "⠀⠀⠙⠒⠻⣥⢊⡂⡏⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⣿⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⢻⠈⣧⡇⢣⠀⠀⢀⠀⡀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠰⡴⠃⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⢸⠀⡿⠁⠈⠙⢲⠌⡄⢰⣀⣀⣀⣀⣀⣠⣤⣼⢤⠀⠘⡇⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⣞⡜⠁⠀⠀⠀⠀⡄⠃⠀⢇⠀⠀⠀⠀⠀⠀⢺⢸⠀⠀⡇⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠘⠋⠀⠀⠀⠀⢀⡴⠃⡀⠀⠸⡀⠀⠀⠀⠀⠀⢸⢸⠀⢀⡇⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣯⡂⣰⣇⠀⠄⣇⠀⠀⠀⠀⢠⣺⢈⠀⠀⡳⡄⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠈⠓⠬⠇⠀⠀⠀⠀⠀⠈⠉⠑⠲⠞⠁⠀⠀");
    }

    public void showCowViewWith3Teats() {
        kickGoatButton.setVisible(false);
        milkedButton.setVisible(false);
        setDisplayText("Cow has 3 teats. Unable to milk.\n"+"⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⣠⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠛⣻⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⢀⡴⠒⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀\r\n" + //
                        "⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⣆⡀⣠⢿⡄⠀⠀⠀\r\n" + //
                        "⠈⠧⣄⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣧⡈⠉⠁⠘⢳⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⢀⡼⠋⢀⡼⠁⠀⠀⠀⣠⠟⠀⠀⠀⠀⠈⢹⣍⣟⡁⠀⠀⠘⠈⣇⠀⠀\r\n" + //
                        "⠀⠀⡴⠋⢧⡀⠘⠦⢤⡀⠀⣰⠇⠀⠀⠀⠀⠀⠀⢸⡇⠉⠁⠀⠀⠀⠀⠘⢦⠀\r\n" + //
                        "⠀⠀⢳⡀⠸⡇⠀⠀⠀⠓⠊⠁⠀⢰⠞⠳⡄⠀⢠⡟⠀⠀⡴⠦⣄⡀⢤⣐⣪⠇\r\n" + //
                        "⠀⠀⠀⢳⡀⣹⠀⠀⠀⠀⠀⣠⠴⠋⠀⠀⡷⠀⠀⠙⢦⡼⠁⠀⠀⠉⠓⠛⠁⠀\r\n" + //
                        "⠀⠀⠀⠀⠹⣇⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⢧⠀⠀⣤⡞⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⣼⠀⡾⠒⣶⡞⠓⠐⡦⠴⠒⢻⠁⢸⠁⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⣿⠀⡇⠸⡱⠟⡶⢾⠓⠀⠀⠸⡆⢸⡄⢹⡀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⢻⡀⢹⣄⣹⡄⠀⠀⠀⠀⠀⠀⢳⠈⡷⣄⣧⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠙⠛⡇⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠃⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    public void showCowViewWith4Teats() {
        kickGoatButton.setVisible(false);
        milkedButton.setVisible(true);
        setDisplayText("Cow has 4 teats. Able to milk.\n"+"⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⣠⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠛⣻⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⢀⡴⠒⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀\r\n" + //
                        "⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⣆⡀⣠⢿⡄⠀⠀⠀\r\n" + //
                        "⠈⠧⣄⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣧⡈⠉⠁⠘⢳⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⢀⡼⠋⢀⡼⠁⠀⠀⠀⣠⠟⠀⠀⠀⠀⠈⢹⣍⣟⡁⠀⠀⠘⠈⣇⠀⠀\r\n" + //
                        "⠀⠀⡴⠋⢧⡀⠘⠦⢤⡀⠀⣰⠇⠀⠀⠀⠀⠀⠀⢸⡇⠉⠁⠀⠀⠀⠀⠘⢦⠀\r\n" + //
                        "⠀⠀⢳⡀⠸⡇⠀⠀⠀⠓⠊⠁⠀⢰⠞⠳⡄⠀⢠⡟⠀⠀⡴⠦⣄⡀⢤⣐⣪⠇\r\n" + //
                        "⠀⠀⠀⢳⡀⣹⠀⠀⠀⠀⠀⣠⠴⠋⠀⠀⡷⠀⠀⠙⢦⡼⠁⠀⠀⠉⠓⠛⠁⠀\r\n" + //
                        "⠀⠀⠀⠀⠹⣇⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⢧⠀⠀⣤⡞⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⣼⠀⡾⠒⣶⡞⠓⠐⡦⠴⠒⢻⠁⢸⠁⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⣿⠀⡇⠸⡱⠟⡶⢾⠓⠀⠀⠸⡆⢸⡄⢹⡀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⢻⡀⢹⣄⣹⡄⠀⠀⠀⠀⠀⠀⢳⠈⡷⣄⣧⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠙⠛⡇⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠃⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void addKickGoatListener(ActionListener listener) {
        kickGoatButton.addActionListener(listener);
    }

    public void addMilkedListener(ActionListener listener) {
        milkedButton.addActionListener(listener);
    }

    public void clearInput() {
        inputField.setText("");
    }
}
