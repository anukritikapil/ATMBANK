import java.awt.*;
import java.awt.event.*;

public class ATMLogin extends Frame implements ActionListener {
    // Login Frame Components
    TextField atmNumberField, pinField;
    Button loginButton;

    // Registration Frame Components
    TextField newAtmNumberField, newPinField;
    Button registerButton;

    // Main Menu Frame Components
    Button balanceInquiryButton, withdrawButton, depositButton, logoutButton;

    // Frames
    Frame loginFrame, registrationFrame, mainMenuFrame;

    public ATMLogin() {
        // Login Frame
        loginFrame = new Frame("ATM Login");
        loginFrame.setLayout(new GridLayout(3, 2));

        Label atmNumberLabel = new Label("ATM Number:");
        atmNumberField = new TextField();
        Label pinLabel = new Label("PIN:");
        pinField = new TextField();
        pinField.setEchoChar('*'); // Displaying * for PIN input
        loginButton = new Button("Login");

        loginFrame.add(atmNumberLabel);
        loginFrame.add(atmNumberField);
        loginFrame.add(pinLabel);
        loginFrame.add(pinField);
        loginFrame.add(new Label()); // Placeholder
        loginFrame.add(loginButton);

        loginButton.addActionListener(this);

        // Registration Frame
        registrationFrame = new Frame("ATM Registration");
        registrationFrame.setLayout(new GridLayout(3, 2));

        Label newAtmNumberLabel = new Label("New ATM Number:");
        newAtmNumberField = new TextField();
        Label newPinLabel = new Label("New PIN:");
        newPinField = new TextField();
        newPinField.setEchoChar('*');
        registerButton = new Button("Register");

        registrationFrame.add(newAtmNumberLabel);
        registrationFrame.add(newAtmNumberField);
        registrationFrame.add(newPinLabel);
        registrationFrame.add(newPinField);
        registrationFrame.add(new Label()); // Placeholder
        registrationFrame.add(registerButton);

        registerButton.addActionListener(this);

        // Main Menu Frame
        mainMenuFrame = new Frame("ATM Main Menu");
        mainMenuFrame.setLayout(new GridLayout(4, 1));

        balanceInquiryButton = new Button("Balance Inquiry");
        withdrawButton = new Button("Withdraw");
        depositButton = new Button("Deposit");
        logoutButton = new Button("Logout");

        mainMenuFrame.add(balanceInquiryButton);
        mainMenuFrame.add(withdrawButton);
        mainMenuFrame.add(depositButton);
        mainMenuFrame.add(logoutButton);

        // Setting frame properties
        loginFrame.setSize(300, 150);
        loginFrame.setVisible(true);
        loginFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        registrationFrame.setSize(300, 150);
        registrationFrame.setVisible(false);
        registrationFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainMenuFrame.setSize(300, 200);
        mainMenuFrame.setVisible(false);
        mainMenuFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Check login credentials
            String atmNumber = atmNumberField.getText();
            String pin = pinField.getText();

            // Dummy authentication
            if (atmNumber.equals("123456") && pin.equals("1234")) {
                // Show main menu
                loginFrame.setVisible(false);
                mainMenuFrame.setVisible(true);
            } else {
                System.out.println("Invalid ATM number or PIN. Please try again.");
            }
        } else if (e.getSource() == registerButton) {
            // Register new ATM user
            String newAtmNumber = newAtmNumberField.getText();
            String newPin = newPinField.getText();

            // Dummy registration process
            System.out.println("New user registered with ATM number: " + newAtmNumber);
            System.out.println("Please remember your PIN: " + newPin);

            // Show login frame after registration
            registrationFrame.setVisible(false);
            loginFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ATMLogin();
    }
}
