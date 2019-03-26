package controllers;
 
import play.*;
import play.mvc.*;
 
import java.util.*;
 
import models.*;
 
import play.test.*;

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
    // Read in File from Form
    // Update file in database with file uploaded
    // Reread the updated file 
    public static void uploadJSON() {
    	
    	//Reloads countries model
    	Fixtures.loadModels("countries.json");
    }
    
}