

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.*;

public class UserDashboard extends JFrame implements ActionListener{
    private JLabel nameLabel, memberStatusLabel;
    private JList<String> signedUpList, availableList;
    public DefaultListModel<String> signedUpModel, availableModel;
    private JButton signUpButton, signOutButton;
    private JTextField courseSignUpField;
    private User user;

    public UserDashboard(User user) throws ClassNotFoundException, IOException {
        super("User Dashboard");
        this.user = user;

        // Initialize labels
        nameLabel = new JLabel("Name: " + user.getName());
        memberStatusLabel = new JLabel("Member Status: " + user.getMemberStatus());

        // Initialize lists and models
        signedUpModel = new DefaultListModel<>();
        signedUpList = new JList<>(signedUpModel);
        availableModel = new DefaultListModel<>();
        availableList = new JList<>(availableModel);

        CourseList courseList = new CourseList("courseData.bin");
        ArrayList<String> courses = courseList.getCourseList();
        setAvailableClasses(courses);

        ArrayList<String> coursesSignedUp = user.getSignedUpCourses();
        System.out.println(coursesSignedUp.toString());
        setSignedUpClasses(coursesSignedUp);

        // Initialize buttons
        signUpButton = new JButton("Sign Up");
        signOutButton = new JButton("Sign Out");
        courseSignUpField = new JTextField();

        signUpButton.addActionListener(this);

        // Add components to the frame
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(nameLabel);
        topPanel.add(memberStatusLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(new JScrollPane(signedUpList));
        centerPanel.add(new JScrollPane(availableList));
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        bottomPanel.add(courseSignUpField);
        bottomPanel.add(signUpButton);
        bottomPanel.add(signOutButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Set frame properties
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            // open user login screen
           CourseList courseList = new CourseList("courseData.bin");
           
           try {
                Course course = courseList.getCourseByName(courseSignUpField.getText());
                user.signUp(course);
                UserList userList = new UserList("userData.bin");
                userList.addUser(user);
            } catch (ClassNotFoundException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } 
    }

    public void setSignedUpClasses(ArrayList<String> classes) {
        if(classes == null) return;
        signedUpModel.clear();
        for (String className : classes) {
            signedUpModel.addElement(className);
        }
    }

    public void setAvailableClasses(ArrayList<String> classes) {
        availableModel.clear();
        for (String className : classes) {
            availableModel.addElement(className);
        }
    }

}
