# Skillo Automation Exam
![alt text](https://www.skillo-bg.com/images/logo/logo.png)

## Automation framework

Used technologies:
* TestNG
* Selenium WebDriver
* Page Object Model
* PageFactory 

This repository contains the following test cases:

| Test class | Name | Description |
| ------ | ------ | ------ |
| HomeTest | anonymousLikeShouldNotBeAllowed | Only logged in users should be able to like posts. Visitors should be redirected to the login page when attempting to give a like. |
| LoginTest | loginSuccessful | Login with valid username and password should be possible. |
| LoginTest | loginUnsuccessful | Login with invalid username or password should not be possible. |
| PostTest | createPost | Logged in users should be able to create new posts by uploading picture and filling caption. |
| ProfileTest | profileCorrect | Logged in users should be able open their profile page. |
| RegisterTest | registerSuccessful | Visitors should be able to register with valid username/email/password. |

Testng.xml files is located in `TrainingSkillo/src/test` directory.