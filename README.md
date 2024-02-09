```markdown
# Travel Agency Application

This is a Java application that simulates a travel agency. It allows users to view available travel packages, choose a destination, and sign up for activities.

## Project Structure

1. `Main` class: This is the entry point of the application. It creates a `TravelPackageService`, generates a list of `Destination` objects, and creates a `TravelAgency`. It then enters a loop where it interacts with the user, asking if they are interested in any of the destinations.

2. `TravelPackageService` class: This class is responsible for creating `Destination` objects and `TravelPackage` objects. It also handles user interaction, such as getting passenger details, chosen destination, and chosen activity.

3. `TravelAgency` class: This class represents a travel agency. It has a list of `TravelPackage` objects and methods to print welcome messages and agency details.

4. `TravelPackage` class: This class represents a travel package. It has properties like `name`, `capacity`, `passengerList`, and `destinationList`.

5. `Destination` class: This class represents a destination. It has a list of `Activity` objects.

6. `Activity` class: This class represents an activity at a destination.

7. `Passenger` class: This class represents a passenger. It has methods to sign up for an activity.

## How to Run

This is a Maven project, so you can run it using the Maven command:


## Testing

Unit tests are written using JUnit 5. You can run them using the Maven command:

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

