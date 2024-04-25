import java.awt.*;
import java.awt.event.*;

public class ATMSystem extends Frame implements ActionListener {
    // Components for login page
    TextField atmNumberField, pinField;
    Button loginButton;

    // Components for balance page
    Label balanceLabel;
    Button backButton;

    // Components for transaction page
    Label transactionLabel;
    Button backToBalanceButton;

    // balance for demonstration
    double balance = 5000.00;
    int transactionCount = 20; // transaction count for demonstration

    public ATMSystem() {
        // layout for login page
        setLayout(new GridLayout(3, 2));

        // components for login page
        Label atmNumberLabel = new Label("ATM Number:");
        atmNumberField = new TextField();
        Label pinLabel = new Label("PIN:");
        pinField = new TextField();
        pinField.setEchoChar('*'); // Display * for PIN input
        loginButton = new Button("Login");

        // Adding components to the login page
        add(atmNumberLabel);
        add(atmNumberField);
        add(pinLabel);
        add(pinField);
        add(new Label());
         // Placeholder
        add(loginButton);

        // Adding action listener to login button
        loginButton.addActionListener(this);

        // Setting frame properties for login page
        setTitle("ATM Login");
        setSize(300, 150);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    // implementing ActionListener 
    public void actionPerformed(ActionEvent e) {
        String atmNumber = atmNumberField.getText();
        String pin = pinField.getText();

        // check for demonstration
        if (atmNumber.equals("123456") && pin.equals("1234")) {
            // Display balance page if login is successful
            displayBalancePage();
        } else {
            System.out.println("Invalid ATM number or PIN. Please try again.");
        }
    }

    // Method displaying the balance page
    private void displayBalancePage() {
        // Removing components from login page
        removeAll();

        // layout for balance page
        setLayout(new FlowLayout());

        // Creating components for balance page
        balanceLabel = new Label("Your current balance is: $" + balance);
        backButton = new Button("Back");

        // Adding components to the balance page
        add(balanceLabel);
        add(backButton);

        // Adding action listener to back button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Displaying login page again when back button is clicked
                removeAll();
                add(atmNumberField);
                add(pinField);
                add(new Label());
                add(loginButton);
                validate();
            }
        });

        // Setting frame properties for balance page
        setTitle("Account Balance");
        setSize(250, 100);
        setVisible(true);
    }

    // Method displaying the transaction page
    private void displayTransactionPage() {
        // Removing components from balance page
        removeAll();

        // layout for transaction page
        setLayout(new FlowLayout());

        // Creating components for transaction page
        transactionLabel = new Label("Total transactions till date: " + transactionCount);
        backToBalanceButton = new Button("Back to Balance");

        // Adding components to the transaction page
        add(transactionLabel);
        add(backToBalanceButton);

        // Adding action listener to back to balance button
        backToBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display balance page again when back button is clicked
                displayBalancePage();
            }
        });

        // Setting frame properties for transaction page
        setTitle("Transaction Count");
        setSize(250, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ATMSystem();
    }
}
