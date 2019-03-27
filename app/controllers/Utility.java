package controllers;


import models.*;

// If you're comparing Utility classes from my assignment 1 to my assignment 2
// Note that I opted to rewrite it
// This was due to the methods by which I read in the countries and cities
// (I have altered their respective Model classes from
public class Utility {
	// format data from form into 
	//			cities
	//			countries
	//			borders
	// 	write function that returns false when not possible
	// else
	// implements strategy design patterns
	
	// We can assume that the locations are not the same
	static String tripPlan(City from, City to) {
		// Define trip plan string to be sent back to user
		String trip="";
		// Define travelContext to be set when necessary
		TravelContext t;
		
		// Define the destination country and city
		Country destinationCountry=to.getHost();
		City destinationCity = to;
		
		// Define the country travelling to and from
		Country countryFrom = from.getHost();
		Country countryTo = to.getHost();
		
		//Make arrayList of bordering countries and cities
		
		// Define desitnationReached boolean to be false
		// The destination has not yet been reached, so its false
		boolean destinationReached = false;
		// While the destination is not reached
		while(!(destinationReached)) {
			// Check if the cities have the same name
			if(from.equals(destinationCity)) {
				// Destination has been reached
				destinationReached = true;
				// Break out of loop
				break;
			}
			// Otherwise we need to plan a trap
			
			// If we're in the same country, we need to move between cities by bus
			else if(countryFrom.equals(countryTo)) {
				// Update travel context
				t = new TravelContext(new ByBus());
				// Add the trip step to the master list
				trip += t.travelTo(countryFrom, from, countryTo, to);
				// Update where you currently are
				from = to;
				countryFrom = countryTo;
			}
			// Check if two countries border one another
			//else if()
			
		}
		return trip;
	}
	
}
