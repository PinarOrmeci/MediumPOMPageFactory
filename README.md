### Build with

* **Selenium**  : Browser automation framework
* **Maven** : Dependency management
* **Junit5** : Testing framework
* **WebDriverManager** : Local driver binary management


#### Running Tests With IntelliJ IDE

Clone repo and after opening project, click play button in the ide.

#### Running Tests With Maven Command

###### Running single test or test class:

mvn surefire:test -Dtest=**testName or className**

<u>Example :</u>  mvn surefire:test -Dtest=LoginTest.testEmptyInfoLogin


