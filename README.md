This repository includes automated tests for `https://the-internet.herokuapp.com` website.

## Packages

The project uses the following packages:
* Selenium WebDriver
* ChromeDriver / GeckoDriver
* TestNG


## Project Structure

* The tests are organized as `DriverFactory`, `pages`, and `tests`.  
* `DriverFactory` class is responsible for creating the driver that can take the desired browser.
* `pages` folder contains BasePage that includes the base methods of the test framework 
and page objects which represent each page of the website.
* `tests` folder includes tests for each page of the website.

## Author
Vica Markosyan