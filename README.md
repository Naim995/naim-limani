# Swagger Petstore Sample

## Overview
This is the pet store test automation challenge. All tests are located under the following package: ***src/test/java/ip/swagger/petstore/tests***  
#### Technology used:
- IDE: IntelliJ
- Programming language: **JAVA**
- Frameworks and libraries: 
  - RestAssured
  - TestNG
  - Hamcrest
  - Allure reports
  - Lombok
  - Maven

###Project test folder structure

Test folder structure consists 4 packages:
1. model - it contains the PetRequest model since it has conflict using the lombok builder
2. requests - all api requests that return the Response object 
3. restassured - rest assured utilites and config
4. tests - all automated tests and BaseAPITest 

## How to run the tests?

1. Navigate to https://github.com/swagger-api/swagger-petstore and clone the repository
2. Run the server using this command:
```
mvn package jetty:run
```   
Wait for the server to run. This will start Jetty embedded on port 8080.
3. Navigate to https://github.com/Naim995/n26HomeChallenge and clone the repository
4. If you do not have allure commandline installed then install it in order to view the test reports:
```
npm install -g allure-commandline --save-dev
```

6.  Run the TestNG xml test suite (filename: testng.xml) 
```
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
```

7. After tests are finished a folder with name: allure-results will be generated. View test report:
```
allure serve allure-results
```
It will open a tab on your browser and redirect you to the allure test report page
