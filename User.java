package CS341_Project;

public class User {

    // Account Details
    public String firstName;
    public String lastName;
    public String email;
    public int phone;
    public String username;
    public String password;

    // Privalages
    public boolean member;

    public User(String firstName, String lastName, String email, int phone, String username, String password){
        UpdateUser(firstName, lastName, email, phone, username, password);
    }

    public void UpdateUser(String firstName, String lastName, String email, int phone, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }


    // Add course to schedual 
    public void AddCourse(CourseNode course){
        UserNode user = new UserNode(this);

        course.participants.AddNode(user);
    }

}
