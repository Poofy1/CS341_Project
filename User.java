

import java.io.*;
import java.util.ArrayList;

public class User implements Serializable {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    private boolean member;

    private ArrayList<Course> signedUpCourses;

    public User(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        signedUpCourses = new ArrayList<>();
    }

    public void signUp(Course course) {
        signedUpCourses.add(course);
    }

    public ArrayList<String> getSignedUpCourses() {
        ArrayList<String> toReturn = new ArrayList<String>();

        for(Course course : signedUpCourses) {
            toReturn.add(course.toString());
        }

        return toReturn;
    }

    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Phone Number: " + phoneNumber;
    }

    // getters and setters for all attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMemberStatus() {
        if(member) return "Member";
        return "Non-Member";
    }

    public void setMember(boolean t) {
        if(t == true) member = true;
        else member = false;
    }

}

