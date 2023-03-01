

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class StaffDashboard extends JFrame {
    private JList<String> classList;
    private JButton newClassBtn, promoteUsersBtn;
    private DefaultListModel<String> availableModel;
    
    public StaffDashboard() throws ClassNotFoundException, IOException {
        // Set up the JFrame
        setTitle("Class List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create a list to display the classes
        CourseList courseList = new CourseList("courseData.bin");
        ArrayList<String> courses = courseList.getCourseList();
        // System.out.println(courseList.toString());
        // System.out.println(courses.toString());
        availableModel = new DefaultListModel<String>();
        setAvailableClasses(courses);
        classList = new JList<String>(availableModel);
        JScrollPane scrollPane = new JScrollPane(classList);
        add(scrollPane, BorderLayout.CENTER);
        
        // Create a button to add a new class
        newClassBtn = new JButton("New Class");
        newClassBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new JFrame for adding a class
                CreateCourseUI newClassUI = new CreateCourseUI();
                newClassUI.setVisible(true);
            }
        });

        promoteUsersBtn = new JButton("Promote Users");
        promoteUsersBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new JFrame for adding a class
                UserPromotionUI upi = null;
                try {
                    upi = new UserPromotionUI();
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                upi.setVisible(true);
            }
        });

        Panel buttonPanel = new Panel(new GridLayout(1, 2));
        buttonPanel.add(newClassBtn);
        buttonPanel.add(promoteUsersBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void setAvailableClasses(ArrayList<String> classes) {
        if(classes == null) return;
        availableModel.clear();
        for (String className : classes) {
            availableModel.addElement(className);
        }
    }
    
    private class CreateCourseUI extends JFrame {
        private JTextField nameField, startDateField, endDateField, startTimeField, endTimeField, locationField, maxParticipantsField, nonMemberFeeField, memberFeeField;
        private JTextArea descriptionArea;
        private JButton saveBtn, cancelBtn;
    
        public CreateCourseUI() {
            // Set up the JFrame
            setTitle("Create Course");
            setSize(400, 500);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new BorderLayout());
    
            // Create a panel to hold the input fields
            JPanel inputPanel = new JPanel(new GridLayout(11, 2));
    
            // Add a field for the course name
            inputPanel.add(new JLabel("Name:"));
            nameField = new JTextField();
            inputPanel.add(nameField);
    
            // Add fields for the start date and time
            inputPanel.add(new JLabel("Start Date (yyyy-MM-dd):"));
            startDateField = new JTextField();
            inputPanel.add(startDateField);
            inputPanel.add(new JLabel("Start Time (HHMM):"));
            startTimeField = new JTextField();
            inputPanel.add(startTimeField);
    
            // Add fields for the end date and time
            inputPanel.add(new JLabel("End Date (yyyy-MM-dd):"));
            endDateField = new JTextField();
            inputPanel.add(endDateField);
            inputPanel.add(new JLabel("End Time (HHMM):"));
            endTimeField = new JTextField();
            inputPanel.add(endTimeField);
    
            // Add a field for the location
            inputPanel.add(new JLabel("Location:"));
            locationField = new JTextField();
            inputPanel.add(locationField);
    
            // Add a field for the maximum number of participants
            inputPanel.add(new JLabel("Max Participants:"));
            maxParticipantsField = new JTextField();
            inputPanel.add(maxParticipantsField);
    
            // Add a field for the non-member fee
            inputPanel.add(new JLabel("Non-Member Fee:"));
            nonMemberFeeField = new JTextField();
            inputPanel.add(nonMemberFeeField);
    
            // Add a field for the member fee
            inputPanel.add(new JLabel("Member Fee:"));
            memberFeeField = new JTextField();
            inputPanel.add(memberFeeField);
    
            // Add a field for the course description
            inputPanel.add(new JLabel("Description:"));
            descriptionArea = new JTextArea(5, 20);
            JScrollPane scrollPane = new JScrollPane(descriptionArea);
            inputPanel.add(scrollPane);
    
            add(inputPanel, BorderLayout.CENTER);
    
            // Create a panel for the buttons
            JPanel buttonPanel = new JPanel(new FlowLayout());
    
            // Create a button to save the course
            saveBtn = new JButton("Save");
            saveBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Create a new course object
                    CourseList courseList = new CourseList("courseData.bin");

                    String[] dates = {startDateField.getText(), endDateField.getText()};
                    int[] times = {Integer.parseInt(startTimeField.getText()), Integer.parseInt(endTimeField.getText())};

                    Course newCourse = new Course(nameField.getText(), dates, times, locationField.getText(), Integer.parseInt(maxParticipantsField.getText()), descriptionArea.getText(), memberFeeField.getText(), nonMemberFeeField.getText());
                    
                    try {
                        courseList.addCourse(newCourse);
                    } catch (ClassNotFoundException | IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    dispose();
                }
            });

            cancelBtn = new JButton("Cancel");
            cancelBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {   
                    dispose();
                }
            });

            buttonPanel.add(saveBtn);
            buttonPanel.add(cancelBtn);
            add(buttonPanel, BorderLayout.SOUTH);
        }
    }
                   
    
}

