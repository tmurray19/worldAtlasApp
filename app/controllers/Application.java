package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;
import java.util.*;

import models.*;

public class Application extends Controller {

    // Renders index page
    public static void index() {
        render();
    }

    // Renders country list
    public static void countryList() {
    	List <Country> c = Country.findAll();
    	render(c);
    }
    
    // Renders country list
    public static void regionList() {
    	//List <Test> t = Test.findAll();
    	//render(t);
    }

    // Renders trip planner
    public static void tripPlanner(){
    	List <City> cit = City.findAll();
    	render(cit);
    }
    
    // This code serves to generate and return the most efficient trip from one city to another
    // Really, it's just a driver file for the Utility functions
    // It passes the completed string to the HTML files
	public static void planTrip(@Required Long startCityId, @Required Long endCityId) {
		City from = City.findById(startCityId);
		City to = City.findById(endCityId);
		
		// This line sends the user to the tripPlanner page
		// In the case that something goes wrong
		// This also sends the user to the page on the first time clicking the link
		// So that users can pick the places they want to travel from and to
        if (validation.hasErrors()) {
            render("Application/tripPlanner.html");
        }

        // This line renders  the required string
        
        // If the cities DON'T have the same name:
		if(!(from.getName() == to.getName())) {
			// Calls trip planner function
            flash.success("%s", Utility.tripPlan(from, to));
        // Otherwise
        // If they have the same name
		}else if(from.getName() == to.getName()) {
			// Tell the user movement is unnecessary
			flash.error("You are already in this city.");		
		}
		// Otherwise
		else {
			// Tell user that movement is impossible
			flash.error("Method of travel unavailable.");
		}
		tripPlanner();
	}
	
}
