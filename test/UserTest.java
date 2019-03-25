

import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        new User("foo@gmail.com", "secret", "Foo").save();

        // Retrieve the user with e-mail address bob@gmail.com
        User bob = User.find("byEmail", "foo@gmail.com").first();

        // Test
        assertNotNull(bob);
        assertEquals("Bob", bob.name);
    }

    @Test
    public void tryConnectAsUser() {
        // Create a new user and save it
        new User("alpha@test.com", "secret", "Test").save();

        // Test
        assertNotNull(User.connect("alpha@test.com", "secret"));
        assertNull(User.connect("test2@tester.ie", "badpassword"));
        assertNull(User.connect("test3@gmail.com", "secret"));
    }
}
