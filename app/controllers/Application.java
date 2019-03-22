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
    	s = "Test";
    	ArrayList<String> arr = new ArrayList<>();
    	arr.add(s);
        render(arr);
    }

    // Renders trip planner
    public static void tripPlanner(){
      render();
    }
    
}
