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
    
	public static void planTrip(@Required Long startCityId, @Required Long endCityId) {
		City from = City.findById(startCityId);
		City to = City.findById(endCityId);
		
        if (validation.hasErrors()) {
            render("Application/tripPlanner.html");
        }
		
		System.out.println(from.getName());
		System.out.println(to.getName());

		if(from.getHost() == to.getHost()) {
            flash.success("Bus from %s to %s", from.getName(), to.getName());
		}else {
            flash.error("No travel method available.");
		}
		
		tripPlanner();
	}
	
}
