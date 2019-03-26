import play.*;
import play.jobs.*;
import play.test.*;
 
import models.*;
 

// This file serves to auto generate the users and the countries in the yml/json files
// Just for showcase/testing purpose
@OnApplicationStart
public class Bootstrap extends Job {
 
    public void doJob() {
        // Check if the user database is empty
        if(User.count() == 0) {
        	// Auto generates users
            Fixtures.loadModels("user-data.yml");
        }
        if(Country.count() == 0) {
        	Fixtures.loadModels("countries.json");
        }
    }
 
}