package CS341_Project;

public class CourseNode {
    
    // Course Data
    public String name;
    public int timeID; // Possible format: Hour/Day/Moth/Year {12}{02}{10}{2023}
    public int cost;
    public int participation; // # of users going to this course
    public String instructor;

    // List Data 
    public CourseNode next;


    public Course(String name, int timeID, String instructor){
        this.name = name;
        this.timeID = timeID;
        this.instructor = instructor;

        // Default Values
        this.cost = 20;
        this.participation = 0;
        this.next = null;
    }



}
