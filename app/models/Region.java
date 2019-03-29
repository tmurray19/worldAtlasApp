

/*
 package models;
 

import play.*;
import play.db.jpa.*;
 
import javax.persistence.*;
import java.util.*;


import play.data.binding.*;
import play.data.validation.*;

// I couldn't produce the same Country class as last assignment
// JPA doesn't allow for editing of ArrayList in it's CRUD module
// I instead opt to store the borders and cities in a string
// Then split that string up where necessary
@Entity
public class Region extends Area{
	//Country Class

	//Initialising variables
	public String name;
	@Column
	@ElementCollection(targetClass=City.class)
	@OneToMany   
	public List<City> cities;
	public City capital;
	//@Cascade(CascadeType.SAVE_UPDATE)
	//@ManyToOne  
	@Column
	@ElementCollection(targetClass=Region.class)
    public List<Region> borderState;
    
    

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}



	public City getCapital() {
		return capital;
	}



	public void setCapital(City capital) {
		this.capital = capital;
	}



	public List<Region> getBorders() {
		return borderState;
	}



	public void setBorders(List<Region> borders) {
		this.borderState = borders;
	}
    


	//public String toString() {
	//	return this.getName();
	//}


	public void addBordering(Region region) {
		this.borderState.add(region);
		if (!region.getBorderingCountries().contains(this))
			region.addBordering(this);
	}

	public List<Region> getBorderingCountries() {
		return borderState;
	}

	// Constructor
	public Region(String name, int population, List<Region> bordering, City capital, List<City> cities) {
		//Initialise Data
		setBorders(bordering);
		setName(name);
		setCapital(capital);
		setPopulation(population);
		setCities(cities);
	}


    
}
*/
