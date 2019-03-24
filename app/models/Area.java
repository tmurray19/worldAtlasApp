package models;
import java.util.ArrayList;

import javax.persistence.*;

import play.db.jpa.*;




// An attempt at implementing polymorphism into the project
@Entity
public class Area extends Model{
	// Initialising variables
	// Has to be initialised as 0 here, so that values can be added correctly down the hirearchy
	private long population;
	private String name;
	
	// Set name
	public void setName(String n) {
		this.name = n;
	}
	
	// returns name
	public String getName() {
		return this.name;
	}
	
	// returns population
	public long getPop() {
		return this.population;
	}
	
	// sets population
	public void setPop(long p) {
		this.population = p;
		
	}
	
}
