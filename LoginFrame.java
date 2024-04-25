import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends Frame implements ActionListener {
    // Components of the login form
    private Label lblUsername;
    private Label lblPassword;
    private TextField txtUsername;
    private TextField txtPassword;
    private Button btnLogin;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        lblUsername = new Label("Username:");
        lblPassword = new Label("Password:");
        txtUsername = new TextField();
        txtPassword = new TextField();
        txtPassword.setEchoChar('*'); // To mask the password input
        btnLogin = new Button("Login");

        // Adding components to the frame
        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(new Label()); // Placeholder for layout
        add(btnLogin);

        // Register action listener for the login button
        btnLogin.addActionListener(this);

        // Event handler to close the window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose(); // Closing the window
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = txtUsername.getText();
            String password = txtPassword.getText();

            // Simulate authentication (you can replace this with actual authentication logic)
            if (username.equals("admin") && password.equals("password")) {
                System.out.println("Login successful");
                // You can perform further actions here like opening a new window
            } else {
                System.out.println("Login failed. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of the login frame and display it
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}
        

