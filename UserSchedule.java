package CS341_Project;

public class UserSchedule {
    public TimeSlot head;

    public UserSchedule(){
        this.head = null;
    }

    public void AddNode(TimeSlot node){
        if (head == null){
            head = node;
        }
        else{
            TimeSlot current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }
}


class TimeSlot {
    
    public String timeID;
    public TimeSlot next;

    public TimeSlot(String timeID){
        this.timeID = timeID;
    }
}
