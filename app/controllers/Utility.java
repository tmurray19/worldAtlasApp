package controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import models.City;
import models.Country;

import java.util.ArrayList;

// Decided to define a utility class to handle and hold various functions
// I felt these functions could be fit into the Country class
// But I think it makes more sense to have a static class that just references these function
public class Utility {
	
	// For internal reference to jsonfile
	private static JSONObject jsonCities;

	
	// Retrieve and define the jsonCities JSONObject
	// Can be considered a constructor of sorts
	public static void dataSetter() {
		try {
			//Sets jsonCities to the JSONObject called in the FileParser class
			jsonCities = FileParser.dataSetter();
	
		}
		//This exception is to stop misreading files
		//Same as all other cases below
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Returns the array of countries bordering a given country
	public static JSONArray getCountryBorder(Country country) {
		try {
			dataSetter();
			//Get borders of countries
			JSONObject borders = (JSONObject) jsonCities.get("bordering");

			//Get countries info
			//JSONArray countries = (JSONArray) jsonCities.get("countries");
			JSONArray countryBorder = (JSONArray) borders.get(country.getName());
			return countryBorder;

		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Checks if two given countries share a border
	public static boolean borderChecker(Country country1, Country country2) {
		// If the list of a given country contains the other given country
		if(getCountryBorder(country1).contains(country2.getName())) {
			//returns true
			return true;
		}
		//otherwise returns false
		else {
			return false;
		}
	}
	
	// Gets the list of countries in the json file
	public static void getCountries() {
		JSONArray countries = (JSONArray) FileParser.dataSetter().get("countries");
		for(int i = 0, size = countries.size(); i < size; i++) {
			JSONObject objectInArray = (JSONObject) countries.get(i);
			System.out.println(objectInArray.get("name"));
		}
	}
	
	// Checks if you've reached your destination
	public static boolean areWeThereYet(City a, City Dest) {
		if(a.getName().equals(Dest.getName())) {
			System.out.println("Destination Reached");
			return true;
		}
		
		else {
			return false;
		}
	}
	
	// Returns string list of all common borders of two countries
	public static ArrayList<String> commonBorders(Country A, Country B){
		// Safely adds bordering strings to two lists
		ArrayList<String> r = new ArrayList<String>();
		JSONArray rArry = getCountryBorder(A);
		for(Object i: rArry) {
			r.add(i.toString());
		}
		
		ArrayList<String> l = new ArrayList<String>();
		JSONArray lArry = getCountryBorder(B);
		for(Object j: lArry) {
			l.add(j.toString());
		}
		
		// Returns list
		ArrayList<String> common = new ArrayList<String>(r);
		common.retainAll(l);
		return common;
	}
	
	// These three methods are for deciding which strategy to initialise
	// They are to be used in conjunction with the strategy 'web'
	// These could have been embedded somewhere in the web, but
	// It's much easier to host them here, with the other utility functions
	
	// Check if two counties are capital
	public static boolean flyFrom(City a, City b) {
		if(a.getCapital() && b.getCapital()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean busFrom(Country conA, City cityA, Country conB, City cityB) {
		if((conA.getName().equals(conB.getName())) && !(cityA.getName().equals(cityB.getName()))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean trainFrom(Country conA, City cityA, Country conB, City cityB) {
		if(getCountryBorder(conA).contains(conB.getName()) && !(cityA.getName().equals(cityB.getName()))) {
			return true;
		}
		else {
			return false;
		}
	}
}
	
	

