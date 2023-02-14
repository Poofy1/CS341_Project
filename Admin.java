package CS341_Project;

public class Admin {

    // Account Details
    public String firstName;
    public String lastName;
    public String email;
    public int phone;
    public String username;
    public String password;


    public Admin(String firstName, String lastName, String email, int phone, String username, String password){
        UpdateAdmin(firstName, lastName, email, phone, username, password);
    }

    public void UpdateAdmin(String firstName, String lastName, String email, int phone, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

}
