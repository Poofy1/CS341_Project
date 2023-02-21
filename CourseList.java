package CS341_Project;

public class CourseList {
    public CourseNode head;

    public CourseList(){
        this.head = null;
    }

    public void AddNode(CourseNode node){
        if (head == null){
            head = node;
        }
        else{
            CourseNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }
}


class CourseNode {
    
    // Course Data
    public String name;
    public String timeID; // Possible format: Hour/Day/Moth/Year {12}{02}{10}{2023}
    public int cost;
    public String instructor;

    // List Data 
    public CourseNode next;
    public UserList participants;


    public CourseNode(String name, String timeID, String instructor){
        this.name = name;
        this.timeID = timeID;
        this.instructor = instructor;

        // Default Values
        this.cost = 20;
        this.participants = new UserList();
        this.next = null;
    }



}
