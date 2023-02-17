package CS341_Project;

public class UserList {
    public UserNode head;

    public UserList(){
        this.head = null;
    }

    public void AddNode(UserNode node){
        if (head == null){
            head = node;
        }
        else{
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }
}


class UserNode {
    
    public User user;
    public UserNode next;

    public UserNode(User user){
        this.user = user;
    }
}
