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
    public static void countryList(String s) {
    	List <Country> c = Country.findAll();
    	render(c);
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
        if (validation.hasErrors()) {
            render("Application/tripPlanner.html");
        }

        // This line renders  the required string
		if(from.getHost() == to.getHost()) {
            flash.success("%s");
		}else {
            flash.error("No travel method available.");
		}
		
		tripPlanner();
	}
	
}
