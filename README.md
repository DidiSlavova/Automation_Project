# Automation_Project

This is a Java Maven test automation project based on TestNG and Selenium WebDriver. The project is organizaed according to Page Object Model design pattern and PageFactory.
The project contains five automated test based on the following website: http://training.skillo-bg.com:4200/posts/all.
The tests recreate the steps for deleting user's post, loging out of a user,modifying user's profile by changing the password, creating new post and uploading a profile picture.
In the project is created a testng.xml fail, executing all test with 'mvn clean test' using Chrome browser.
In case of test failure, a screenshot and report are created in a specified directory in the project.
