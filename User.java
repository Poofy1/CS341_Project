package CS341_Project;
import java.util.ArrayList;

public class User {

    // Account Details
    public String name;
    public int phone;
    public String email;
    public String username;
    public String password;
    ArrayList<Course> schedule;

    // Privalages
    public boolean activated;

    //Next
    public User next;

    public User(String name, String email, int phone, String username, String password, boolean activated, User next){
        modify(name, email, phone, username, password, activated);
        this.schedule = new ArrayList<Course>();
        this.next = next;
    }

    public void modify(String name, String email, int phone, String username, String password, boolean activated){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.activated = activated;
    }
}
