import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public class ChessClubAdmissionForm extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JTextField cityTextField;
    private JTextField educationTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JCheckBox termsCheckBox;
    private JButton submitButton;

    public ChessClubAdmissionForm() {
        setTitle("Chess Club Admission Form");
        setSize(400, 700); // Set screen width and height
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load image from URL and paint it as the background with transparency
                try {
                    URL imageURL = new URL("https://img.freepik.com/free-vector/vintage-chess-competition-poster_1284-40125.jpg?w=360&t=st=1687374882~exp=1687375482~hmac=09bd17a69128c47ac9b0d06d71fb0b546c80c6399ee48c169487d287ca422833");
                    Image image = new ImageIcon(imageURL).getImage();
                    int imageWidth = getWidth();
                    int imageHeight = getHeight();
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f)); // Set transparency
                    g2d.drawImage(image, 0, 0, imageWidth, imageHeight, null);
                    g2d.dispose();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setPreferredSize(new Dimension(600, 800));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.BLACK);
        nameTextField = new JTextField(15);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setForeground(Color.BLACK);
        ageTextField = new JTextField(10);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setForeground(Color.BLACK);
        cityTextField = new JTextField(15);

        JLabel educationLabel = new JLabel("Education:");
        educationLabel.setForeground(Color.BLACK);
        educationTextField = new JTextField(15);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(Color.BLACK);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        JLabel termsLabel = new JLabel("Agree with the terms:");
        termsLabel.setForeground(Color.BLACK);
        termsCheckBox = new JCheckBox();

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(nameLabel, gbc);
        formPanel.add(createCircularBackgroundPanel(nameTextField), gbc);
        formPanel.add(ageLabel, gbc);
        formPanel.add(createCircularBackgroundPanel(ageTextField), gbc);
        formPanel.add(cityLabel, gbc);
        formPanel.add(createCircularBackgroundPanel(cityTextField), gbc);
        formPanel.add(educationLabel, gbc);
        formPanel.add(createCircularBackgroundPanel(educationTextField), gbc);
        formPanel.add(genderLabel, gbc);
        formPanel.add(maleRadioButton, gbc);
        formPanel.add(femaleRadioButton, gbc);
        formPanel.add(termsLabel, gbc);
        formPanel.add(termsCheckBox, gbc);

        contentPanel.add(formPanel, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30));
        submitButton.setBackground(Color.DARK_GRAY);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String age = ageTextField.getText();
                String city = cityTextField.getText();
                String education = educationTextField.getText();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                boolean termsAgreed = termsCheckBox.isSelected();

                String message = "Name: " + name + "\nAge: " + age + "\nCity: " + city + "\nEducation: " + education + "\nGender: " + gender
                        + "\nAgreed with the terms: " + (termsAgreed ? "Yes" : "No");
                JOptionPane.showMessageDialog(null, message);
            }
        });
        contentPanel.add(submitButton, BorderLayout.SOUTH);

        setContentPane(contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createCircularBackgroundPanel(Component component) {
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(Color.BLACK);
                g2d.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        panel.setOpaque(false);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChessClubAdmissionForm();
            }
        });
    }
}
