

import java.io.*;
import java.util.*;

public class CourseList {
    private static List<Course> courseList;
    private static String filename;

    public CourseList(String filename) {
        CourseList.filename = filename;
        courseList = new ArrayList<>();
    }

    // method to add a course to the list

    public void addCourse(Course course) throws IOException, ClassNotFoundException {
        courseList.add(course);
        saveToFile();
    }

    // method to retrieve a course by name

    public Course getCourseByName(String name) throws IOException, ClassNotFoundException {
        loadFromFile();
        for (Course course : courseList) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }

	public ArrayList<String> getCourseList() throws ClassNotFoundException, IOException {
        

        ArrayList<String> toReturn = new ArrayList<String>();
		loadFromFile();
		for(Course course : courseList) {
			toReturn.add(course.toString());
		}
		return toReturn;
	}

    // method to save the list of courses to a file

    public void saveToFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(courseList);
        oos.close();
    }

    // method to load the list of courses from a file

    @SuppressWarnings("unchecked")
    private void loadFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        courseList = (List<Course>) ois.readObject();
        ois.close();
    }

    public String toString() {
        return courseList.toString();
    }
}
