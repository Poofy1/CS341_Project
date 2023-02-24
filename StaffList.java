import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StaffList {
	Staff head;
	Staff current;
	public StaffList() {
		try {
			add("admin", 0000000000, "admin", "password", true);
			File file = new File("StaffList.txt");
			if(file.exists()) {
				Scanner scan = new Scanner(file);
				while(scan.hasNext()) {
					String n = scan.next();
					int pn = scan.nextInt();
					String u = scan.next();
					String p = scan.next();
					add(n, pn, u, p, false);
				}
				scan.close();
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void add(String n, int pn, String u, String p, boolean a) {
		if(head == null) {
			head = new Staff(n, pn, u, p, a, null);
		}else {
			head = new Staff(n, pn, u, p, a, head);
		}
	}
	
	public void search(String n) {
		Staff temp = head;
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
	
	public void modify(String n, int pn, String u, String p) {
		current.modify(n, pn, u, p);
	}
	
	public void deactivate() {
		if(!current.admin) current.deactivate();
	}
	
	public void teachClass(Course p) {
		current.teachClass(p);
	}
	
	public void close() {
		try {
			File file = new File("ProgramList.txt");
			if(file.exists()) file.delete();
			BufferedWriter write = new BufferedWriter(new PrintWriter(file));
			Staff temp = head.next; //Skips admin
			
			while(temp != null) {
				write.write(temp.name + " "  + temp.phoneNumber + " " + temp.username + " " + temp.password + " ");
				temp = temp.next;
			}
			write.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
