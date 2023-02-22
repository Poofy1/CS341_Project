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
        this.schedule = new UserSchedule();
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
    public boolean AddParticipant(String name, CourseList courses) {
        // Find the course's node in the course list
        CourseNode current = courses.head;
        while (current != null) {
            if (current.name.equals(name)) {
                // Course found, add to schedual???
                TimeSlot currentTime = schedule.head;
                if (currentTime == null){
                    schedule.head = new TimeSlot(current.timeID);
                }
                else{
                    while (true) {
                        if (currentTime.timeID.equals(current.timeID)) {
                            // Time dup found, cancel everything
                            return false;
                        }
    
                        if (currentTime.next == null) {
                            // Time not found, create time, continue
                            currentTime.next = new TimeSlot(current.timeID);
                            break;
                        }
    
                        currentTime = currentTime.next;
                    }
                }

                current.participants++;
                return true;
            }

            current = current.next;
        }

        //Nothing found
        return false;
    }

    // Remove course from schedual 
    // returns false if user is not found
    public boolean DeleteParticipant(String name, CourseList courses) {
        // Find the course's node in the course list
        CourseNode current = courses.head;
        while (current != null) {
            if (current.name.equals(name)) {

                // Course found, delete from schedule
                TimeSlot currentTime = schedule.head;
                TimeSlot prevTime = null;
                while (true) {
                    if (currentTime.timeID.equals(current.timeID)) {
                        // Time found, delete from schedule
                        if (prevTime == null) {
                            // Node is the head of the list
                            schedule.head = currentTime.next;
                        } else {
                            prevTime.next = currentTime.next;
                        }
                        break;
                    }

                    if (currentTime.next == null) {
                        // Time not found, return false
                        return false;
                    }

                    prevTime = currentTime;
                    currentTime = currentTime.next;
                }

                current.participants--;
                return true;
            }
            current = current.next;
        }

        // Course not found in the list
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
        UpdateStaff(firstName, lastName, email, phone, username, password);
        this.schedule = new UserSchedule();
    }

    public void UpdateStaff(String firstName, String lastName, String email, String phone, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }


    // Create a new course
    // returns null if time conflict
    public CourseNode CreateCourse(String name, String timeID, CourseList courses){
        // Check for time conflicts
        TimeSlot currentTime = schedule.head;

        //Create TimeSlot
        if (currentTime == null){
            schedule.head = new TimeSlot(timeID);
        }
        else{
            while (true) {
                if (currentTime.next == null){
                    // No time conflict, add course list and to instructor schedule 
                    currentTime.next = new TimeSlot(timeID);
                    break;
                }
    
                if (currentTime.timeID.equals(timeID)) {
                    // Time conflict found, return null
                    return null;
                }
    
                currentTime = currentTime.next;
            }
        }
        
        // Create Course
        CourseNode newCourse = new CourseNode(name, timeID, this.lastName);
        CourseNode current = courses.head;
        if(current == null){
            courses.head = newCourse;
        }
        else{
            while (true) {
                if(current.next == null){
                    current.next = newCourse;
                    break;
                }
                current = current.next;
            }
        }
        
        return newCourse;
    }

    // Delete a course
    // returns true if deleted sucessfully 
    // Staff can only delete courses under their name!!!
    public boolean DeleteCourse(String name, CourseList courses) {
        // Find the course's node in the course list
        CourseNode current = courses.head;
        CourseNode prev = null;
        while (current != null) {
            if (current.name.equals(name)) {

                // Course found, delete from instructor schedule
                TimeSlot currentTime = schedule.head;
                TimeSlot prevTime = null;
                while (true) {
                    if (currentTime.timeID.equals(current.timeID)) {
                        // Time found, delete from instructor schedule
                        if (prevTime == null) {
                            // Node is the head of the list
                            schedule.head = currentTime.next;
                        } else {
                            prevTime.next = currentTime.next;
                        }
                        break;
                    }

                    if (currentTime.next == null) {
                        // Time not found, return false
                        return false;
                    }

                    prevTime = currentTime;
                    currentTime = currentTime.next;
                }

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