package CS341_Project;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class UserList {
	User head;
	User current;

	public UserList() {
		try {
			File file = new File("UserList.txt");
			if(file.exists()) {
				Scanner scan = new Scanner(file);
				while(scan.hasNext()) {
					String n = scan.next();
					String email = scan.next();
					int pn = scan.nextInt();
					String u = scan.next();
					String p = scan.next();
					add(n, email, pn, u, p, false);
				}
				scan.close();
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void add(String n, String email, int pn, String u, String p, boolean a) {
		if(head == null) {
			head = new User(n, email, pn, u, p, a, null);
		}else {
			head = new User(n, email, pn, u, p, a, head);
		}
	}
	
	public void search(String n) {
		User temp = head;
		if(temp.name.equals(n)) {
			current = temp; 
			return;
		}
		temp = temp.next;
		while(temp != null) {
			if(temp.name.equals(n)) {
				current = temp; 
				return;
			}
			temp = temp.next;
		}
	}
	
	public void modify(String n, String email, int pn, String u, String p, boolean a) {
		current.modify(n, email, pn, u, p, a);
	}
	
	private Course findCourse(String courseName, String teacherName, StaffList staffList){
		// Find the staff with the course
		staffList.search(teacherName);

		//Find Course in the staff courses
		ArrayList<Course> courseList = staffList.current.classes;
		Course course = null;
		for (Course temp : courseList) {
			if (temp.name.equals(courseName)) {
				course = temp;
				break;
			}
		}

		return course;
	}

	// Add course to current users schedual 
    // returns False if failed
    public boolean JoinClass(String courseName, String teacherName, StaffList staffList) {
        // Find the staff with the course
		Course course = findCourse(courseName, teacherName, staffList);

		//failed to find course
		if (course == null) {
			return false;
		} 

		// Add course to current user
		course.participants++;
		current.schedule.add(course);
        
        return true;
    }

    // Remove course from schedual 
	// returns false if failed
	public boolean LeaveClass(String courseName, String teacherName, StaffList staffList) {
		// Find the staff with the course
		Course course = findCourse(courseName, teacherName, staffList);

		//failed to find course
		if (course == null) {
			return false;
		} 

		// Remove course from current user
		course.participants--;
		current.schedule.remove(course);
		
		return true;
	}

	public void close() {
		try {
			File file = new File("UserList.txt");
			if(file.exists()) file.delete();
			BufferedWriter write = new BufferedWriter(new PrintWriter(file));
			User temp = head;
			
			while(temp != null) {
				write.write(temp.name + " " + temp.email + " " + temp.phone + " " + temp.username + " " + temp.password + " ");
				temp = temp.next;
			}
			write.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
