
import org.junit.*;

import controllers.Countries;

import java.util.*;
import play.test.*;
import models.*;

public class CountriesTest extends UnitTest{
	
	
    //@Before
    //public void setup() {
    //    Fixtures.deleteAllModels();
    //}
    
    @Test
    public void countryCreateAndRetrieve() {
    	new Country("Test1", 100, "Test2, Test3", "CityA", "CityA, CityB, CityC").save();
    	
    	Country test = Country.find("byName", "Test1").first();
    	
        assertNotNull(test);
        assertEquals("Test1", test.name);
    }
    
    @Test
    public void cityCreateAndRetrieve() {
    	// Test can be set to be null instead, the test will still pass
    	Country test = Country.find("byName", "Test1").first();


    	new City(test, "CityA").save();
    	City cit = City.find("byName", "CityA").first();
    	
        assertNotNull(cit);
        assertEquals("CityA", cit.name);
    	
    }
    
    @After
    public void teardown() {
    	Fixtures.delete(Country.class);
    	Fixtures.delete(City.class);
    	Fixtures.loadModels("countries.json");
    }
	
}
