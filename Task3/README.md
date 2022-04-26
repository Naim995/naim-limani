# Swagger Petstore Sample 
 Key points
- All test methods are named properly by specifically describing their purpose and scope of testing. I also refer them as test cases.  
The proposed test cases for automation are the ones assuring expected response codes (negative testing for example:expect 404 and positive testing for example: expect 200),
  response body, assuring that data is created by using get requests and asserting that data are created as expected.  
  Extra tests that I would add is also authentication and authorization use cases. For example: send a request as an unauthorized client and expect status code 403.  
- One should avoid automating flaky test scenario, exploratory testing or any test cases that have a negative ROI.  
  When running API tests one must be responsible for the test data management. We can either:
  - use docker images or local environments, stubs and destroy them in the end or use a similar enviroment (like staging) and delete data by either using api's or droping data inside the database.
  - the negative of docker images or local env. is that it doesn't take into consideration network issues and in case microservices it doesn't completely mimick the integration between external services,
  positive is that it is very easy to manage data
  - the negative of using staging like enviroments which resembles the prod env is that data is harder to manage. We either suppose that delete api endpoints is working correctly or if database is used to 
    clear/drop data we can expose security risks. Also we are dependant from all external services so if an external service fail you test will provide a false negative. Positive side of this is
    that it resemebles the prod environment and it takes into consideration almost everything in the sence of real life scneario test execution.
    
    <br/>
  p.s. I encountered some bugs and issues with the petstore hence I avoided some tests such as 
testing missing mandatory properties in the API request payload
  
## Repository overview
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
allure serve taraget/allure-results
```
It will open a tab on your browser and redirect you to the allure test report page

**One can also use the maven allure command te generate and open test reports with the following:***
```
mvn allure:report
mvn allure:serve
```
