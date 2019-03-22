package controllers;


import play.*;
import play.mvc.*;

import java.util.*;

import models.*;



public class TripController extends Controller {
	
	City cityA, cityB;
	Country countryA, countryB;
	
	// Set Country
	public void setCountry(String CountryA, String CountryB, String CityA, String CityB) {
		//Initialise Countries
		this.countryA = new Country(CountryA);
		this.countryB = new Country(CountryB);
		
		// Initialise cities
		this.cityA = new City(CityA);
		this.cityB = new City(CityB);
	}
	
}
