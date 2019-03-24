package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    // Renders index page
    public static void index() {
        render();
    }


    // Renders say hello page (TESTING)
    public static void sayHello(String myName){
        render(myName);
    }


    // Renders country list
    public static void countryList(String s) {
    	List <Country> c = Country.findAll();
    	render(c);
    }

    // Renders trip planner
    public static void tripPlanner(){
      render();
    }
    
    
    public static void lister() {
    }
    
    
    
}
