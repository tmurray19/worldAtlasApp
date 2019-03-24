package controllers;
 
import models.*;
 

//Security module to authenticate Admins and Users
public class Security extends Secure.Security {
	
    static boolean authenticate(String username, String password) {
        return User.connect(username, password) != null;    
        }
    
    // Checks if a user is an admin
    static boolean check(String profile) {
        if("admin".equals(profile)) {
            return User.find("byEmail", connected()).<User>first().isAdmin;
        }
        return false;
    }
    
}