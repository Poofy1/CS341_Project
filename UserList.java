

import java.io.*;
import java.util.*;

public class UserList {
    private static List<User> userList;
    private static String filename;

    public UserList(String filename) {
        UserList.filename = filename;
        userList = new ArrayList<>();
    }

    // method to add a user to the list

    public void addUser(User user) throws IOException, ClassNotFoundException {
        userList.add(user);
        saveToFile();
    }

    // method to retrieve a user by email

    public User getUserByEmail(String email) throws IOException, ClassNotFoundException {
        loadFromFile();
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUserList() throws ClassNotFoundException, IOException {
        

        ArrayList<User> toReturn = new ArrayList<>();
		loadFromFile();
		for(User user : userList) {
			toReturn.add(user);
		}
		return toReturn;
	}

    // method to save the list of users to a file

    public void saveToFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(userList);
        oos.close();
    }

    // method to load the list of users from a file

    @SuppressWarnings("unchecked")
    private void loadFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        userList = (List<User>) ois.readObject();
        ois.close();
    }

    public String toString() {
        return userList.toString();
    }
}
