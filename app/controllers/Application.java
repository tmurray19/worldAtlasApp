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
}
