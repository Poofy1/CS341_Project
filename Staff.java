package CS341_Project;
import java.util.ArrayList;

public class Staff {
	String name;
	int phoneNumber;
	String username;
	String password;
	ArrayList<Course> classes;
	boolean activated;
	boolean admin;
	Staff next;
	
	public Staff(String n, int pn, String u, String p, boolean a, Staff s) {
		name = n;
		phoneNumber = pn;
		username = u;
		password = p;
		classes = new ArrayList<Course>();
		activated = true;
		admin = a;
		next = s;
	}
	
	public void modify(String n, int pn, String u, String p) {
		name = n;
		phoneNumber = pn;
		username = u;
		password = p;
	}

	public void teachClass(Course p) {
		classes.add(p);
	}
	
	public void deactivate() {
		activated = false;
	}
}
