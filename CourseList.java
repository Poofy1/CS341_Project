package CS341_Project;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CourseList {
	
	Course head;
	Course current;
	public CourseList() {
		try {
			File file = new File("CourseList.txt");
			if(file.exists()) {
				Scanner scan = new Scanner(file);
				while(scan.hasNext()) {
					String n = scan.next();
					int nW = scan.nextInt();
					
					String[] d = new String[nW];
					for(int x = 0; x < nW; x++) {
						d[x] = scan.next();
					}
					
					int[] t = {scan.nextInt(), scan.nextInt()};
					String l = scan.next();
					int p = scan.nextInt();
					int f = scan.nextInt();
					int mF = scan.nextInt();
					String de = scan.next();
					add(n, d, t, l, p, f, mF, de);
				}
				scan.close();
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void add(String n, String[] d, int[] t, String l, int p, int f, int mF, String de) {
		if(head == null) {
			head = new Course(n, d, t, l, p, f, mF, de, null);
		}
		else {
			head = new Course(n, d, t, l, p, f, mF, de, head);
		}
	}
	
	public void search(String n) {
		Course temp = head;
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
	
	public void modify(String n, String[] d, int[] t, String l, int p, int f, int mF, String de) {
		current.modify(n, d, t, l, p, f, mF, de);
	}
	
	public void addParticipant() {
		current.participants--;
	}
	
	public void removeParticipant() {
		current.participants++;
	}
	
	public void close() {
		try {
			File file = new File("CourseList.txt");
			if(file.exists()) file.delete();
			BufferedWriter write = new BufferedWriter(new PrintWriter(file));
			Course temp = head;
			
			while(temp != null) {
				write.write(temp.name + " " + temp.numWeeks + " ");
				for(int x = 0; x < temp.numWeeks; x++) {
					write.write(temp.date[x] + " ");
				}
				write.write(temp.time[0] + temp.time[1] + temp.location + " " + temp.participants + " " + temp.fee + " " + temp.mFee + " " + temp.description + " ");
				temp = temp.next;
			}
			write.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
