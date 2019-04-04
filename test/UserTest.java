

import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class UserTest extends UnitTest {
	/*
	@Before
    public void setup() {
        Fixtures.deleteAllModels();
    }
	 */

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        new User("Foo", "foo@gmail.com", "secret").save();


        // Retrieve the user with e-mail address bob@gmail.com
        User foo = User.find("byEmail", "foo@gmail.com").first();

        // Test
        assertNotNull(foo);
        assertEquals("foo@gmail.com", foo.email);
    }

    @Test
    public void tryConnectAsUser() {
        // Create a new user and save it
        new User("Test", "alpha@test.com", "badPassword").save();


        // Test
        assertNotNull(User.connect("alpha@test.com", "badPassword"));
        assertNull(User.connect("test2@tester.ie", "badpassword"));
        assertNull(User.connect("test3@gmail.com", "secret"));
    }
    
    @After
    public void teardown() {
    	Fixtures.delete(User.class);
        Fixtures.loadModels("user-data.yml");
    }
    
}
