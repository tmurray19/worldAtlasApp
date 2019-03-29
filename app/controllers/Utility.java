package controllers;

import java.util.*;
import models.*;

import play.*;
import play.db.jpa.*;
 
import javax.persistence.*;


// If you're comparing Utility classes from my assignment 1 to my assignment 2
// Note that I opted to rewrite it
// This was due to the methods by which I read in the countries and cities
// It is unnecessary for this assignment, which can read the json file in the bootstrap file
// and create a list of country and city classes
public class Utility{
	// format data from form into 
	//			cities
	//			countries
	//			borders
	// else
	// implements strategy design patterns
	
	// We can assume that the locations are not the same
	static String tripPlan(City from, City to) {
		// Define trip plan string to be sent back to user
		// We will fill this later
		String trip="";
		// Define travelContext to be set when necessary
		TravelContext t;
		
		// Define the country you're traveling to an from
		Country toCountry = to.getHost();
		Country countryFrom = from.getHost();

		// Define desitnationReached boolean to be false
		// The destination has not yet been reached, so its false
		boolean destinationReached = false;
		// While the destination is not reached
		while(!(destinationReached)) {		
			// Converts Borders to an arrayList
			// This is only necessary if the borderlist is a string
			// Which it is in the case of my database, and how I store the information
			// I could use a set or an arrayList of countries
			// But they aren't mutable in the admin panel, which was a requirement of the assignment
			// Remove that requirement, and the Strings are changed to arrayLists
			ArrayList<String> countryFromBorders = new ArrayList<String>(Arrays.asList(countryFrom.getBorders().split(", ")));
			// Make a check to see if you made it to the destination
			if(from.equals(to)) {
				// Destination has been reached, so return the trip plan
				return trip;
			}
			// Otherwise we need to plan a trap
			
			// Check if you can fly first
			// If you're in a capital, travel to the other country's capital
			
			// if from.getName is equal countryFrom.getCapital
			// and
			// our destination country is not bordering our current country
			// or IS NOT our current country
			else if(from.getName().equals(countryFrom.getCapital()) && !(countryFromBorders.contains(toCountry.getName()) || countryFrom == toCountry)) {
				// Query the database for the city related to the country's 'capital' city
				List<Object> c = City.find("name", toCountry.getCapital()).fetch();
				City capitalTo = (City) c.get(0);
				// Travel to the new city, update where you are
				t = new TravelContext(new ByPlane());
				trip += t.travelTo(countryFrom, from, toCountry, capitalTo);
				from = capitalTo;
				countryFrom = toCountry;
			}
			
			// If we're in the same country, we need to move between cities by bus
			else if(countryFrom.equals(toCountry)) {
				// Travel to the new city, update where you are
				t = new TravelContext(new ByBus());
				trip += t.travelTo(countryFrom, from, toCountry, to);
				from = to;
				countryFrom = toCountry;
			}

			// If two countries share a common border
			// Train to the connector country
			else if((commonBorder(countryFrom, toCountry))!=null) {
				t = new TravelContext(new ByTrain());
				Country connector = commonBorder(countryFrom, toCountry);
				ArrayList<String> connectorCities = new ArrayList<String>(Arrays.asList(connector.getCities().split(", ")));
				// Get the second city in the list, which is not the capital
				List<Object> c = City.find("name", connectorCities.get(1)).fetch();
				City nonCapital = (City) c.get(0);
				trip += t.travelTo(countryFrom, from, connector, nonCapital);
				from = nonCapital;
				countryFrom = connector;
				
			}
			// Else just train to border countries
			else if(countryFromBorders.contains(toCountry.getName())){
				t = new TravelContext(new ByTrain());
				trip += t.travelTo(countryFrom, from, toCountry, to);
				from = to;
				countryFrom = toCountry;
			}
			
			
			// Otherwise move to capital
			else {
				// Find capital of country you're in
				List<Object> c = City.find("name", countryFrom.getCapital()).fetch();
				City capital = (City) c.get(0);
				t = new TravelContext(new ByBus());
				trip += t.travelTo(countryFrom, from, countryFrom, capital);
				from = capital;
			}
		}
		return trip;
	}

	// Find common borders of two countries
	private static Country commonBorder(Country countryFrom, Country countryTo) {
		ArrayList<String> countryToBorders = new ArrayList<String>(Arrays.asList(countryTo.getBorders().split(",")));
		ArrayList<String> countryFromBorders = new ArrayList<String>(Arrays.asList(countryFrom.getBorders().split(",")));		
		ArrayList<String> common = new ArrayList<String>(countryToBorders);
		common.retainAll(countryFromBorders);

		if(!(common.isEmpty())) {
			List<Object> c = Country.find("name", common.get(0)).fetch();
			Country connector = (Country) c.get(0);
			return connector;
		}
		else {
			return null;
		}
	}
	
}
