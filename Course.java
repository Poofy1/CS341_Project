

import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private String[] date;
    private int weeks;
    private int[] time;
    private String location;
    private int maxParticipants;
    private String description;
    private String nmFee;
	private String mFee;
    private int participants;

    public Course(String name, String[] date, int[] time, String location, int maxParticipants, String description, String fee, String mFee) {
        this.name = name;
        this.date = date;
        weeks = date.length;
        this.time = time;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.description = description;
        this.nmFee = fee;
		this.mFee = mFee;
		participants = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDates() {
        return date[0] + "-" + date[date.length - 1];
    }

    public void setDates(String[] date) {
        this.date = date;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public String getTime() {
        return time[0] + " to " + time[1];
    }

    public void setTime(int[] time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getnmFee() {
        return nmFee;
    }

    public void setnmFee(String fee) {
        this.nmFee = fee;
    }

	public String getmFee() {
		return mFee;
	}
	
	public void setmFee(String fee) {
		this.mFee = fee;
	}

	public int getNumParticipants() {
		return participants;
	}

	public void addParticipant() {
		participants++;
	}

    public void modifyCourse(String name, String[] date, int[] time, String location, int maxParticipants, String description, String fee, String mFee) {
        this.name = name;
        this.date = date;
        weeks = date.length;
        this.time = time;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.description = description;
        this.nmFee = fee;
		this.mFee = mFee;
    }

	public String toString() {
		return "Name: " + name + ", " + "Dates: " + date[0] + " - " + date[date.length-1] + ", " + "Time: " + time[0] + " to " + time[1] + ", " + "Location: " + location + ", Maximum Participants: " + maxParticipants + ", $" + nmFee + " for non-member, $" + mFee + " for member, " + "Description: " + description;
	}
}