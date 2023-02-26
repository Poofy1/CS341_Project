package CS341_Project;

public class Course {
	String name;
	String[] date;
	int numWeeks;
	int[] time;
	String location;
	int participants;
	int fee;
	int mFee;
	String description;
	Course next;
	
	public Course(String n, String[] d, int[] t, String l, int p, int f, int mF, String de, Course next) {
		name = n;
		date = d;
		numWeeks = d.length;
		time = t;
		location = l;
		participants = p;
		fee = f;
		mFee = mF;
		description = de;
		this.next = next;
	}
	
	public void modify(String n, String[] d,  int[] t, String l, int p, int f, int mF, String de) {
		name = n;
		date = d;
		numWeeks = d.length;
		time = t;
		location = l;
		participants = p;
		fee = f;
		mFee = mF;
		description = de;
	}
	
	public String toString() {
		return name + ", " + date[0] + " - " + date[date.length-1] + ", " + time[0] + " to " + time[1] + ", " + location + ", maximum " + participants + ", $" + fee + " non-member, $" + mFee + " member, " + description;
	}
}
