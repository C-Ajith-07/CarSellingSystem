
package database_project;

import java.io.FileWriter;

public class User {
    String userName;
    String password;
    String role;
    int userId;
    User(){
        userName = "king";
        password = "Ajith@123";
        role = "customer";
    }
    
    User(int userId ,String userName, String password, String role){
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.userId = userId;
    }
    
    // void userDetails(){
    //     System.out.println("Company name : "+userId+"\nuser name : ");
    // }
    
    
    String getUserName() {
        return userName;
    }
    
    void setUserName(String userName) {
        this.userName = userName;
    }
    
    String getPassword() {
        return password;
    }
    
//  void setPassword(String password) {
//      this.password = password;
//  }
//  
    String getRole() {
        return role;
    }
    
    void setRole(String role) {
        this.role = role;
    }
    
}
