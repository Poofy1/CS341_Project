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
    public boolean staff;

    //Course Info


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

    public void UpdateStaff(boolean input){
        if(input){
            member = true;
            staff = true;
        }
        else{
            staff = false;
        }
    }

    public void AddCourse(){
        //Add to linked list here
    }

}
