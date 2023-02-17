package CS341_Project;

public class Testing {
    public static void main(String[] args) {
        // Create accounts
        Staff staff = new Staff(new User("John", "Doe", "johndoe@example.com", 1234567890, "johndoe", "password"));
        User user = new User("Jane", "Doe", "janedoe@example.com", 1234567890, "janedoe", "password");

        // Create a new course
        staff.CreateCourse("Jumping jacks for 4 hours straight", 2023021012);

        // add a user to it
        CourseNode course = staff.courses.head;
        user.AddCourse(course);

        // Print the user's name and the course name
        System.out.println("Staff: " + staff.firstName + " " + staff.lastName);
        System.out.println("User: " + user.firstName + " " + user.lastName);
        System.out.println("Course: " + course.name);
    }
}
