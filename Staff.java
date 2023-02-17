package CS341_Project;

public class Staff {

    // Account Details
    public String firstName;
    public String lastName;
    public String email;
    public int phone;
    public String username;
    public String password;

    // Hosted Courses
    public CourseList courses;

    // Admin
    public boolean isAdmin = false;


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
    public void CreateCourse(String name, int timeID){
        CourseNode node = new CourseNode(name, timeID, lastName);

        if (courses == null){
            courses = new CourseList();
        }
        
        courses.AddNode(node);
    }

}
