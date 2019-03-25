package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.FileParser;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class City extends Area{
	
	@ManyToOne
	public Country host;
	
	public City(Country host, String name) {
		this.host = host;
		setName(name);
	}
	
	public String toString() {
		return this.getName();
	}

	
}
