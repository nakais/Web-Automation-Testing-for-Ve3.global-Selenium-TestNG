# Web Automation Testing for Ve3.global

This project automates the testing of key functionalities on the [Ve3.global](https://www.ve3.global/) website using Selenium WebDriver and TestNG.

## Table of Contents
- [Objective](#objective)
- [Tools and Technologies](#tools-and-technologies)
- [Getting Started](#getting-started)
- [Test Script Development](#test-script-development)
- [Data-Driven Testing](#data-driven-testing)
- [Test Reporting](#test-reporting)
- [Defect Reporting](#defect-reporting)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

## Objective

The main objective of this project is to automate the testing of key functionalities on the [Ve3.global](https://www.ve3.global/) website to ensure its quality and reliability.

## Tools and Technologies

1. Selenium WebDriver: Used for web automation.
2. Java (or language of your choice): The programming language used for test scripting.
3. TestNG: The testing framework for organizing and executing tests.

## Getting Started

Follow these steps to set up and run the web automation tests on your local machine.

### Prerequisites

- Java Development Kit (JDK) installed.
- Maven installed.
- WebDriver binaries compatible with your preferred browser (e.g., ChromeDriver, GeckoDriver) placed in a directory available in the system PATH.

### Installation

1. Clone the repository:

   ```
   git clone https://github.com/yourusername/ve3-global-automation.git
   ```

2. Navigate to the project directory:

   ```
   cd ve3-global-automation
   ```
3. Compile and execute the tests:
   ```
   mvn test
   ```

### Test Script Development

I write automated test scripts using Selenium WebDriver for the following scenarios:
 - Verify that the Ve3.global homepage loads successfully.
 - Go to page https://www.ve3.global/news/.
 - Verify all the elements on the page are displayed
 - Test the newsletter form by filling it out and submitting it successfully.
 - Attempt to submit the newsletter form with invalid data and verify the error message(s).


### Data-Driven Testing

We employ data-driven testing to thoroughly validate the newsletter submission functionality using different combinations of names and email addresses. The data for these tests is stored in the `newlattertestdata.json` file.


