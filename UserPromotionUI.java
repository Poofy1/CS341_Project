

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class UserPromotionUI extends JFrame {

    private JLabel titleLabel;
    private JList<User> userList;
    private DefaultListModel<User> listModel;
    private JScrollPane userScrollPane;
    private JTextField emailField;
    private JButton promoteButton;

    private UserList users = new UserList("userData.bin");
    

    public UserPromotionUI() throws ClassNotFoundException, IOException {
        setTitle("User Promotion");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        ArrayList<User> userlist = users.getUserList();

        // Create UI components
        titleLabel = new JLabel("User List:");
        listModel = new DefaultListModel<>();
        userList = new JList<>(listModel);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userScrollPane = new JScrollPane(userList);
        emailField = new JTextField(20);
        promoteButton = new JButton("Promote to Member");

        // Add components to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(userScrollPane, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(new JLabel("Enter email:"));
        bottomPanel.add(emailField);
        bottomPanel.add(promoteButton);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        // Populate list model with users
        for (User user : userlist) {
            listModel.addElement(user);
        }

        // Add action listener to promote button
        promoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                User selectedUser = userList.getSelectedValue();
                if (selectedUser != null && selectedUser.getEmail().equals(email)) {
                    selectedUser.setMember(true);
                    UserList userList = new UserList("userData.bin");
                    
                    try {
                        userList.addUser(selectedUser);
                    } catch (ClassNotFoundException | IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

}
