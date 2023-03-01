


import java.io.Serializable;

public class Staff implements Serializable{
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean admin;
    private boolean activated;
    
    public Staff(String name, String email, String password, String phoneNumber, boolean admin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        activated = true;
        this.admin = admin;
    }

    
    
    // Getters and setters for each attribute
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin() {
        admin = true;
    }

    public boolean isActivated() {
        return activated;
    }

    public void deactivate() {
        activated = false;
    }

    public void modify(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}


    

