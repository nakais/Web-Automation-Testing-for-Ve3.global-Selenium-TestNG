# Web Automation Testing for Ve3.global

This project automates the testing of key functionalities on the [Ve3.global](https://www.ve3.global/) website using Selenium WebDriver and TestNG.

## Table of Contents
- [Objective](#objective)
- [Tools and Technologies](#tools-and-technologies)
- [Getting Started](#getting-started)
- [Test Script Development](#test-script-development)
- [Data-Driven Testing](#data-driven-testing)
- [Test Scenarios Documentation](#test-scenarios-documentation)
- [Test Reporting](#test-reporting)
- [Contributing](#contributing)
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

## Test Script Development

I write automated test scripts using Selenium WebDriver for the following scenarios:
 - Verify that the Ve3.global homepage loads successfully.
 - Go to page https://www.ve3.global/news/.
 - Verify all the elements on the page are displayed
 - Test the newsletter form by filling it out and submitting it successfully.
 - Attempt to submit the newsletter form with invalid data and verify the error message(s).


## Data-Driven Testing

I employ data-driven testing to thoroughly validate the newsletter Monthly VE3 Insights form submission functionality using different combinations of name and email addresses. The data for these tests is stored in the `NewLatterTestData.json` file.

#### Test Data

The `NewLatterTestData.json` file contains a structured set of test data in JSON format. Each test case in the JSON file consists of a name and an email address. These test cases are used to drive the newsletter Monthly VE3 Insights form submission tests, allowing us to assess how the system handles various name and email inputs.

#### Implementation

In our test scripts, such as `TestRunner.java`, we read the test data from the `NewLatterTestData.json` file and execute the same test scenario multiple times with different data sets. This approach ensures comprehensive testing of the newsletter submission form.

## Test Scenarios Documentation
https://docs.google.com/spreadsheets/d/1df5f-F-9caVeoUn12fYvFxasSIhh6YNvgVsc4GYnnCc/edit?usp=sharing

## Test Reporting

#### Allure Report:
![Ve3_allure_1](https://github.com/nakais/Web-Automation-Testing-for-Ve3.global-Selenium-TestNG/assets/52671754/e7419361-60a0-4374-902c-d63fc1abfe7c)

![Ve3_allure_2](https://github.com/nakais/Web-Automation-Testing-for-Ve3.global-Selenium-TestNG/assets/52671754/2736bd3b-839c-4c69-89f3-50f13439a7a9)

#### HTML Report:
![Ve3_html_1](https://github.com/nakais/Web-Automation-Testing-for-Ve3.global-Selenium-TestNG/assets/52671754/4e66870d-511d-410c-830b-c66f84e07618)

## Contributing
If you'd like to contribute to this project, please follow these guidelines:

1. Fork the project.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push to your forked repository.
5. Create a pull request to the original repository.

## Author
Nazrul Islam
```
Customize this template with your project-specific information, such as the project structure, test scenarios, data-driven testing details, and defect reporting process. Your `README.md` file will serve as a guide for users and contributors to your web automation testing project for Ve3.global.
```





