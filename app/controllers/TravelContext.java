package controllers;

import models.*;

// A context class, for initialising the Strategy Design Pattern, and (maybe) 
// deciding the correct way to travel between two given cities
public class TravelContext {
	// Initialising variables
	private StrategyPlanner plan;
	
	// Constructor
	public TravelContext (StrategyPlanner plan) {
		this.plan = plan;
	}
	
	// Calls the relevant fromTo function
	public String travelTo(Country conA, City cityA, Country conB, City cityB) {
		return plan.fromTo(conA, cityA, conB, cityB);
	}
	
}
