

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class App extends JFrame implements ActionListener {

    private JButton userLoginButton;
    private JButton staffLoginButton;
    private JButton createAccountButton;

    public App() throws ClassNotFoundException, IOException {
        super("Login Screen");

        // create components
        userLoginButton = new JButton("User Login");
        staffLoginButton = new JButton("Staff Login");
        createAccountButton = new JButton("Create Account");
        

        // add action listeners to buttons
        userLoginButton.addActionListener(this);
        staffLoginButton.addActionListener(this);
        createAccountButton.addActionListener(this);

        // set layout and add components to frame
        setLayout(new GridLayout(3, 1));
        add(userLoginButton);
        add(staffLoginButton);
        add(createAccountButton);

        // set frame properties
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Staff admin = new Staff("admin", "email", "password", "1", true);
        StaffList staffList = new StaffList("staffData.bin");
        
        staffList.addStaff(admin);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userLoginButton) {
            // open user login screen
            UserLoginUI userLoginUI = new UserLoginUI();
            userLoginUI.setVisible(true);
        } else if (e.getSource() == staffLoginButton) {
            // open staff login screen
            StaffLoginUI staffLoginUI = new StaffLoginUI();
            staffLoginUI.setVisible(true);
        } else if (e.getSource() == createAccountButton) {
            UserSignupUI userSignUpUI = new UserSignupUI();
            userSignUpUI.setVisible(true);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // create and display login UI
        App loginUI = new App();
        loginUI.setVisible(true);
    }
}

class UserLoginUI extends JFrame implements ActionListener{
    // add user login UI components here
    private JTextField emailField;
    private JTextField passwordField;
    private JButton loginButton;

    public UserLoginUI() {
        super("User Login Screen");

        // create components
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // add action listener to login button
        loginButton.addActionListener(this);

        // set layout and add components to frame
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        setContentPane(panel);

        // set frame properties
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText();
            String password = passwordField.getText();

            UserList userList = new UserList("userData.bin");
            CourseList courseList = new CourseList("courseData.bin");
            
            try {
                User user = userList.getUserByEmail(email);
                // System.out.println(userList.toString());
                if(user == null) {
                    JOptionPane.showMessageDialog(null, "Error: User does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if(password.equals(user.getPassword())) {
                        UserDashboard userDashboard = new UserDashboard(user);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Error: Invalid password.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            
            } catch (ClassNotFoundException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            dispose();



            // TODO: validate email and password
            // and check if they match a user in the database
            // if successful, open the user's dashboard
            // if unsuccessful, display an error message
        }
    }
}

class StaffLoginUI extends JFrame implements ActionListener{
    // add staff login UI components here
    private JTextField emailField;
    private JTextField passwordField;
    private JButton loginButton;

    public StaffLoginUI() {
        super("Staff Login Screen");

        // create components
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // add action listener to login button
        loginButton.addActionListener(this);

        // set layout and add components to frame
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        setContentPane(panel);

        // set frame properties
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText();
            String password = passwordField.getText();

            StaffList staffList = new StaffList("staffData.bin");
            CourseList courseList = new CourseList("courseData.bin");

            try {
                Staff staff = staffList.getStaffByEmail(email);
                if(staff == null) {
                    JOptionPane.showMessageDialog(null, "Error: User does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if(password.equals(staff.getPassword())) {
                        StaffDashboard staffDashboard = new StaffDashboard();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Error: Invalid password.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            
            } catch (ClassNotFoundException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            dispose();
            // TODO: validate email and password
            // and check if they match a user in the database
            // if successful, open the user's dashboard
            // if unsuccessful, display an error message
        }
    }
}

class UserSignupUI extends JFrame implements ActionListener {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField phoneField;
    private JButton signupButton;

    public UserSignupUI() {
        super("User Signup Screen");

        // create components
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel phoneLabel = new JLabel("Phone Number:");
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        phoneField = new JTextField(20);
        signupButton = new JButton("Signup");

        // add action listener to signup button
        signupButton.addActionListener(this);

        // set layout and add components to frame
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(new JLabel());
        panel.add(signupButton);
        setContentPane(panel);

        // set frame properties
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String phone = phoneField.getText();

            User user = new User(name, email, password, phone);

            UserList userList = new UserList("userData.bin");
            
            try {
                userList.addUser(user);
            } catch (ClassNotFoundException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            dispose();
            

            // TODO: validate user input and add new user to database
            // if successful, display a success message and close the window
            // if unsuccessful, display an error message
        }
    }
}
