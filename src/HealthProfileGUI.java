import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class HealthProfileGUI extends JFrame implements ActionListener  {
    private JTextField nameField, lastNameField, genderField, birthDateField, heightField, weightField;
    private JLabel nameLabel, lastNameLabel, genderLabel, birthDateLabel, heightLabel, weightLabel;
    private JButton submitButton, calculateButton;

    public HealthProfileGUI() {
        JOptionPane.showMessageDialog(null, "Input all your data and press calculate to get your BMI");
        setTitle("Health Profile");
        setSize(1600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel= new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridx=0;
        gbc.gridy=0;


        //headlines
        nameLabel = new JLabel("Name: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        lastNameLabel = new JLabel("Last Name: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lastNameLabel, gbc);

        genderLabel = new JLabel("Gender: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(genderLabel, gbc);

        birthDateLabel = new JLabel("Birth Date (in format YYYY-MM-DD): ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(birthDateLabel, gbc);

        heightLabel = new JLabel("Height: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(heightLabel, gbc);

        weightLabel = new JLabel("Weight: ");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(weightLabel, gbc);


        //user input fields
        gbc.gridx = 5;
        gbc.gridy = 0;
        nameField = new JTextField(10);
        panel.add(nameField, gbc);

        gbc.gridy = 1;
        lastNameField = new JTextField(10);
        panel.add(lastNameField, gbc);

        gbc.gridy = 2;
        genderField = new JTextField(10);
        panel.add(genderField, gbc);

        gbc.gridy = 3;
        birthDateField = new JTextField(10);
        panel.add(birthDateField, gbc);

        gbc.gridy = 4;
        heightField = new JTextField(10);
        panel.add(heightField, gbc);

        gbc.gridy = 5;
        weightField = new JTextField(10);
        panel.add(weightField, gbc);

        gbc.gridy = 6;
        gbc.gridwidth=2;
        calculateButton = new JButton("Calculate");
        panel.add(calculateButton, gbc);
        calculateButton.addActionListener(this);

        //headlines and text fields
        add(panel);
        pack();
        setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            String name = nameField.getText();
            String lastName = lastNameField.getText();
            int height = Integer.parseInt(heightField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String gender = genderField.getText();
            LocalDate birthDate = LocalDate.parse(birthDateField.getText());

            // Create a HealthProfile object
            HealthProfile profile = new HealthProfile(name, lastName, gender, birthDate, height, weight);

            // Calculate BMI
            double bmi = profile.BMI(weight, height);

            // Display BMI
            String message = String.format("Hello %s, your BMI is %.2f", name, bmi);
            JOptionPane.showMessageDialog(null, message);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers and date.");
        }
        catch(DateTimeParseException ex ){
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid date.");
        }
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            HealthProfileGUI frame= new HealthProfileGUI();
            frame.setVisible(true);
        });
    }
}
