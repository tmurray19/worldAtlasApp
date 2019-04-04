# worldAtlasApp
Webapp implementation of CT548 assignment 1

## Submission Guidlines
  * My JSON Data file is different to what you're likely to provide
  * It's closer to a Yaml file than a JSON file
  * It gives countries and cities custom names
  * Below is a sample of a Country and City class as it's found in the json file:
  ...
    "Country(test)": {
      "name": "Test",
      "capital": "City Name",
      "borders": "Other Countryry",
      "population": 999999999999,
      "cities": " City Name, Other City"
    },
    "City(cityName)": {
      "host": "test",
      "name": "City Name"
    },
    "City(otherCity)": {
      "host": "test",
      "name": "Other City"
    },
    ...
    * It also stores the border countries and cities as strings instead of Country classes and City Classes as arraylists
    * The reason I implemented it in this way is because one of the requirements was updating the data from the admin panel
    * And I couldn't get arrayLists or Lists or Sets to work within the panel


  * Instead of ArrayLists or Sets or Lists, the Cities and Bordering Countries are kept as Strings
  * The burden is then on trip planning file to link these up in the database with the corresponding countries
  * This is done using SQL Queries
  * Provided the data is correctly input, the Trip Planner should give the most efficient route for travel

  * Admin username and password is:
            email:          alpha@test.com
            password:       secret

  * Tests are simple. There are three
      * UserTest adds a user to the database, and tries to connect as that user
      * CountriesTest creates and looks for a Country and City class
      * TripTest sets up three scenarios where the relevant Strategy should be called, and tests to see if its equal to what the string should return
