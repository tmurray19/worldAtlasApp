
import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;
import controllers.*;

public class TripTest extends UnitTest{
	/*
    @Before
    public void setup() {
        Fixtures.deleteAllModels();
    }
    */
    @Test
    public void testBus() {
    	new Country("Test1", 100, "Test2, Test3", "CityA", "CityA, CityB, CityC").save();
    	Country test = Country.find("byName", "Test1").first();


    	new City(test, "CityA").save();
    	City citA = City.find("byName", "CityA").first();
    	new City(test, "CityB").save();
    	City citB = City.find("byName", "CityB").first();
    	
    	assertEquals(citA.getHost(), citB.getHost()); 
    	String byBusStr = "Move from " + "CityA" + ", " + "Test1" 
		+ " to " + 
		"CityB" + ", " + "Test1" + " by Bus.\n";
		TravelContext t = new TravelContext(new ByBus());
    	assertEquals(t.travelTo(test,citA,test,citB), byBusStr);
    }
    
    @Test
    public void testTrain() {
    	new Country("Test1", 100, "Test2, Test3", "CityA", "CityA, CityB, CityC").save();
    	Country test = Country.find("byName", "Test1").first();
    	
    	new Country("Test2", 100, "Test1", "CityD", "CityD, CityE").save();
    	Country test2 = Country.find("byName", "Test2").first();

    	new City(test, "CityA").save();
    	City citA = City.find("byName", "CityA").first();
    	new City(test2, "CityD").save();
    	City citD = City.find("byName", "CityD").first();
    	
    	String byTrainStr = "Move from " + "CityA" + ", " + "Test1" 
		+ " to " + 
		"CityD" + ", " + "Test2" + " by Train.\n";
		TravelContext t = new TravelContext(new ByTrain());
    	assertEquals(t.travelTo(test,citA,test2,citD), byTrainStr);
    }
    
    @Test
    public void testPlane() {
    	new Country("Test1", 100, "Test2, Test3", "CityA", "CityA, CityB, CityC").save();
    	Country test = Country.find("byName", "Test1").first();
    	
    	new Country("Test3", 100, "Test2", "CityF", "CityF, CityG").save();
    	Country test3 = Country.find("byName", "Test3").first();

    	new City(test, "CityA").save();
    	City citA = City.find("byName", "CityA").first();
    	new City(test3, "CityF").save();
    	City citF = City.find("byName", "CityF").first();
    	
    	String byPlaneStr = "Move from " + "CityA" + ", " + "Test1" 
		+ " to " + 
		"CityF" + ", " + "Test3" + " by Plane.\n";
		TravelContext t = new TravelContext(new ByPlane());
    	assertEquals(t.travelTo(test,citA,test3,citF), byPlaneStr);
    }
    
    @After
    public void teardown() {
    	Fixtures.delete(Country.class);
    	Fixtures.delete(City.class);
    	Fixtures.loadModels("countries.json");
    }
	
}