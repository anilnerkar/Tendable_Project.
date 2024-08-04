# Tendable_Project
## Overview
This project contains automated tests for the Tendable website using Selenium, Java, Maven, and TestNG. The tests cover the following scenarios:
1. Confirm accessibility of the top-level menus: Home, Our Story, Our Solution, and Why Tendable.
2. Verify that the "Request a Demo" button is present and active on each of the aforementioned top-level menu pages.
3. Validate the error message when submitting the "Contact Us" form without the "Message" field.

### Prerequisites
- Java JDK 8 or higher
- Maven
- ChromeDriver (compatible with the installed version of Chrome)

#### How to Run
1. Clone the repository.
2. Navigate to the project directory.
3. Update the path to the ChromeDriver in the setup method of `com.tenableProject.Test`.
4. Run the tests using Maven:
   ```bash 
   mvn test
