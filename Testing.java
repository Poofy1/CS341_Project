package CS341_Project;

public class Testing {
    public static void main(String[] args) {

        // Create staff and users
        User user1 = new User("John", "Doe", "johndoe@gmail.com", "1234567890", "johndoe", "password");
        User user2 = new User("Jane", "Doe", "janedoe@gmail.com", "2345678901", "janedoe", "password");
        User user3 = new User("Bob", "Smith", "bobsmith@gmail.com", "3456789012", "bobsmith", "password");
        Staff staff = new Staff(user1);
    
        // Create courses
        CourseList courses = new CourseList();
        CourseNode course1 = new CourseNode("Jumping jacks for 4 hours", "2023031012", staff.lastName);
        CourseNode course2 = new CourseNode("benching 600 pounds", "2023031510", staff.lastName);
    
        // Staff creates a new course
        if (staff.CreateCourse(course1, courses)) {
            System.out.println("New course created: " + course1.name);
        } else {
            System.out.println("Failed to create new course due to time conflict.");
        }
    
        // Staff creates a new course
        if (staff.CreateCourse(course2, courses)) {
            System.out.println("New course created: " + course2.name);
        } else {
            System.out.println("Failed to create new course due to time conflict.");
        }
    



        // User1 adds course1 to their schedule
        if (user1.AddParticipant(course1, courses)) {
            System.out.println(user1.firstName + " " + user1.lastName + " added to " + course1.name);
        } else {
            System.out.println("Failed to add " + course1.name + " due to time conflict.");
        }

        // User2 adds course1 to their schedule
        if (user2.AddParticipant(course1, courses)) {
            System.out.println(user2.firstName + " " + user2.lastName + " added to " + course1.name);
        } else {
            System.out.println("Failed to add " + course1.name + " due to time conflict.");
        }

        // User2 adds course1 to their schedule again (error)
        if (user2.AddParticipant(course1, courses)) {
            System.out.println(user2.firstName + " " + user2.lastName + " added to " + course1.name);
        } else {
            System.out.println("Failed to add " + course1.name + " due to time conflict.");
        }

        // User3 adds course2 to their schedule
        if (user3.AddParticipant(course2, courses)) {
            System.out.println(user3.firstName + " " + user3.lastName + " added to " + course2.name);
        } else {
            System.out.println("Failed to add " + course2.name + " due to time conflict.");
        }
    
        // Staff deletes course2
        if (staff.DeleteCourse(course2, courses)) {
            System.out.println("Course deleted: " + course2.name);
        } else {
            System.out.println("Course not found in the course list.");
        }
    }
}
