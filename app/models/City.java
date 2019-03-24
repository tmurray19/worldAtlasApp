package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.FileParser;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class City extends Area{
	
	
	public City(String name) {
		setName(name);
	}
	
	
}
