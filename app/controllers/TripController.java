package controllers;


import play.*;
import play.mvc.*;

import java.util.*;

import models.*;



public class TripController extends Controller {
	
	City cityA, cityB;
	Country countryA, countryB;
	String thisShouldBetheHTMLInput;
    Country countryR = User.find("byEmail", thisShouldBetheHTMLInput).first();
	// Set Country
	public void setCountry(String CountryA, String CountryB, String CityA, String CityB) {
		countryA = Country.find("byName", CountryA).first();
		countryB = Country.find("byName", CountryB).first();
		
		cityA = City.find("byName", CityA).first();
		cityB = City.find("byName", CityB).first();

		render(countryA, countryB, cityA, cityB);
	}
	
}
