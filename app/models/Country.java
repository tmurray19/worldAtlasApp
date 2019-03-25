package models;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.FileParser;

import play.*;
import play.db.jpa.*;
 
import javax.persistence.*;
import java.util.*;



@Entity
public class Country extends Area{
	//Country Class

	//Initialising variables
    private ArrayList<String> cities;
    private String capital;
    private ArrayList<String> borders;

	// Add a city to the city arrayList
	public void setCities(ArrayList<String> cities) {
		this.cities = cities;
	}

	// Returns the whole array to user
	public ArrayList<String> getCities(){
		return this.cities;
	}

	public void setBorders(ArrayList<String> bordering) {
		this.borders = bordering;
	}

	public ArrayList<String> getBorders(){
		return this.borders;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}


	// Constructor
	public Country(String name, int population, ArrayList<String> bordering, String capital, ArrayList<String> cities) {
		//Initialise Data
		setBorders(bordering);
		setName(name);
		setCapital(capital);
		setPopulation(population);
		setCities(cities);
	}

	public String toString() {
		return this.getName();
	}
    
}
