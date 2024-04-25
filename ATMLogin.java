import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ATMLogin extends Frame implements ActionListener {
    TextField atmNumberField, pinField;
    Button loginButton;
    Label statusLabel, balanceLabel;

    BufferedImage backgroundImage;

    public ATMLogin() {
        try {
            // Load the background image
            backgroundImage = ImageIO.read(new File("atm_background.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new GridLayout(5, 2));

        Label atmNumberLabel = new Label("ATM Number:");
        atmNumberField = new TextField();
        Label pinLabel = new Label("PIN:");
        pinField = new TextField();
        pinField.setEchoChar('*'); 
        // Displaying * for PIN input
        loginButton = new Button("Login");
        statusLabel = new Label("");
        balanceLabel = new Label("");

        add(atmNumberLabel);
        add(atmNumberField);
        add(pinLabel);
        add(pinField);
        add(new Label());
        add(loginButton);
        add(new Label());
        add(statusLabel);
        add(new Label("Account Balance:"));
        add(balanceLabel);

        // Adding action listener to login button
        loginButton.addActionListener(this);

        // Setting frame properties
        setTitle("ATM Login");
        setSize(800, 600); // Set frame size according to image size
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        // Draw the background image
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    // Simulated method to retrieve account balance
    private double getAccountBalance(String atmNumber) {
        // This method would typically retrieve balance from a database or external source
        // For demonstration purposes, we'll use a simple static balance for known accounts
        if (atmNumber.equals("123456")) {
            return 1000.00; // Sample balance for account 123456
        }
        return 0.0; // Default balance if account not found
    }

    // implementing ActionListener 
    public void actionPerformed(ActionEvent e) {
        String atmNumber = atmNumberField.getText();
        String pin = pinField.getText();

        // Perform login verification
        if (atmNumber.equals("123456") && pin.equals("1234")) {
            double balance = getAccountBalance(atmNumber);
            balanceLabel.setText("$" + balance);
            statusLabel.setText("Login Successful!");
            // Now you can enable additional transaction buttons or features
        } else {
            statusLabel.setText("Invalid ATM number or PIN. Please try again.");
            balanceLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new ATMLogin();
    }
}
