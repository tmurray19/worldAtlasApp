package controllers;
 
import play.*;
import play.mvc.*;
 
import java.util.*;
 
import models.*;
 
@With(Secure.class)
public class Admin extends Controller {
    
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            User user = User.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.name);
        }
    }
 
    public static void index() {
        render();
    }
    
    
    public static void countries() {
    	List <Country> c = Country.findAll();
    	render(c);
    }
}