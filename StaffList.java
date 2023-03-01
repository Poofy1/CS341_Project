

import java.io.*;
import java.util.*;

public class StaffList {
    private static List<Staff> staffList;
    private static String filename;

    public StaffList(String filename) {
        StaffList.filename = filename;
        staffList = new ArrayList<>();
    }

    // method to add a staff to the list

    public void addStaff(Staff staff) throws IOException, ClassNotFoundException {
        staffList.add(staff);
        saveToFile();
    }

    // method to retrieve a staff by email

    public Staff getStaffByEmail(String email) throws IOException, ClassNotFoundException {
        loadFromFile();
        for (Staff staff : staffList) {
            if (staff.getEmail().equals(email)) {
                return staff;
            }
        }
        return null;
    }

    // method to save the list of staff to a file

    private static void saveToFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(staffList);
        oos.close();
    }

    // method to load the list of staff from a file

    @SuppressWarnings("unchecked")
    private void loadFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        staffList = (List<Staff>) ois.readObject();
        ois.close();
    }
}
