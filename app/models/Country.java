package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.FileParser;

import play.*;
import play.db.jpa.*;
 
import javax.persistence.*;
import java.util.*;


// I couldn't produce the same Country class as last assignment
// JPA doesn't allow for editing of ArrayList in it's CRUD module
// I instead opt to store the borders and cities in a string
// Then split that string up where necessary
@Entity
public class Country extends Area{
	//Country Class

	//Initialising variables
    public String cities;
    public String capital;
    public String borders;   
    // Here's how you're actually supposed to hold the data
    // Or rather, the more ideal solution than just holding data as strings
    // But I was getting too many issues with implementing this
    // Largely to do with linking the countries and the cities together
    // Which is pretty tough to do when you're running the bootstrap 
    
    // If you're reading this, all the trip planning is done in the utility function
    // I'm not stupid, I know how it's supposed to work
    // I'm just too busy with my other assignments
    // And my Final Year Project
    // to refactor this code again
    /*
    @ManyToMany
    public List<City> citiesList;
    
    public City capitalCity;

    @ManyToMany
    public List<Country> borderCountries;
	*/
    
	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
	}

	public String getBorders() {
		return borders;
	}

	public void setBorders(String borders) {
		this.borders = borders;
	}

	public String toString() {
		return this.getName();
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}


	// Constructor
	public Country(String name, int population, String bordering, String capital, String cities) {
		//Initialise Data
		setBorders(bordering);
		setName(name);
		setCapital(capital);
		setPopulation(population);
		setCities(cities);
	}


    
}
