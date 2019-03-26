package controllers;
 
import play.*;
import play.mvc.*;
 
import java.util.*;
 
import models.*;
 
@With(Secure.class)
public class Admin extends Controller {
    
	// Connects Admin
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            User user = User.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.name);
        }
    }
 
    // Renders index page
    public static void index() {
        render();
    }
    
    // Renders upload page
    public static void jsonUpload() {
    	render();
    }
    
    // Uploads JSON file
    // TODO
    public static void uploadJSON() {
    	
    }
    
}