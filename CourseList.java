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
            current.setNext(node);
        }
    }
}
