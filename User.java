package CS341_Project;

public class User {

    // Account Details
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String username;
    public String password;

    // Privalages
    public boolean member;

    // UserSchedule
    public UserSchedule schedule;

    public User(String firstName, String lastName, String email, String phone, String username, String password){
        UpdateUser(firstName, lastName, email, phone, username, password);
    }

    public void UpdateUser(String firstName, String lastName, String email, String phone, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    // Add course to schedual 
    // returns False if time conflict
    public boolean AddParticipant(CourseNode course, CourseList courses) {
        // Check for time conflicts
        TimeSlot current = schedule.head;
        while (current != null) {
            if (current.timeID.equals(course.timeID)) {
                // Time conflict found, return false
                return false;
            }

            // Add to schedule at end of list
            if (current.next == null){
                current.next = new TimeSlot(course.timeID);
                break;
            }
            current = current.next;
        }
    
        // No time conflict, add user to the course's participants list
        UserNode user = new UserNode(this);
        course.participants.AddNode(user);
        return true;
    }

    // Remove course from schedual 
    // returns false if user is not found
    public boolean DeleteParticipant(CourseNode course) {
        // Find the user's node in the course's participants list
        UserNode current = course.participants.head;
        UserNode prev = null;
        while (current != null) {
            if (current.user == this) {
                // User found, remove the node from the participants list
                if (prev == null) {
                    // Node is the head of the list
                    course.participants.head = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
    
        // User not found in the participants list
        return false;
    }
}


class Staff {

    // Account Details
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String username;
    public String password;

    // Hosted Courses
    public CourseList courses;

    // Admin
    public boolean isAdmin = false;

    // UserSchedule
    public UserSchedule schedule;


    // Migrate user to staff (Delete user account after migration)
    public Staff(User user){
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.phone = user.phone;
        this.username = user.username;
        this.password = user.password;
    }


    // Create a new course
    // returns False if time conflict
    public boolean CreateCourse(CourseNode newCourse, CourseList courses){
        // Check for time conflicts
        CourseNode current = courses.head;
        while (current != null) {
            if (current.timeID.equals(newCourse.timeID)) {
                // Time conflict found, return false
                return false;
            }
            current = current.next;
        }

        // No time conflict, add course to instructor schedule 
        courses.AddNode(newCourse);
        return true;
    }

    // Delete a course
    public boolean DeleteCourse(CourseNode course, CourseList courses) {
        // Find the course's node in the course list
        CourseNode current = courses.head;
        CourseNode prev = null;
        while (current != null) {
            if (current == course) {
                // Course found, remove the node from the list
                if (prev == null) {
                    // Node is the head of the list
                    courses.head = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
    
        // Course not found in the list
        return false;
    }
}