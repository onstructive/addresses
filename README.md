# Address directory 📇

![Java CI](https://github.com/onstructive/addresses/workflows/Java%20CI/badge.svg)

## Introduction

Thank you for applying for a developer position at onstructive. This repository contains a simple Micronaut project that contains a directory of Swiss postal codes. We would like you to continue the development and add support a street and house number directory.

The main goal of this assignment is to understand how you are solving problems.

## Requirements

Make sure you have installed the following tools:

- JDK 14 (You can use sdkman to easily switch between JDK installations. See https://sdkman.io/jdks).
- Your favourite Java IDE. We recommend using IntelliJ IDEA.
- Gradle (the project provides a Gradlew wrapper, so no additional installation is required)

## Your assignments 📃

### Fork this repo

Please fork this repository and make your fork repo private. By doing it that way your application and personal data remains private and only onstructive HR has knowlegde of it.

### Assignment 1 - Analyze the existing code 👓

Walk through the existing code and try to run and understand it. We would like you to explain how the application works. Feel free to ask questions on parts you don't understand.

For IntelliJ users: The repository contains a file called `postalCodes.http` that can be used to run HTTP calls against locally running Micronaut application. This might help you to discover the application.

#### Explanation of the modules

Within this project you find the following modules.

##### Domain

The domain module represents the persistence layer and holds JPA entities, and their repositories (see https://micronaut-projects.github.io/micronaut-data/latest/guide/).

##### Services API

A service api module for interacting with backend services.

##### Services

This is the business service layer that implements specific business logic. It is responsible for defining the transactional boundaries.

##### REST API

The rest api consumes the business service layer and transforms the data to the REST model.

##### Server

This module represents the applications itself. It will result in an executable fat jar. 

### Assignment 2 - Implement update postal code 🛠

Currently `ch.onstructive.candidates.PostalCodeController#update` is not yet implemented. Give it a try an make it possible to update the postal code or the city name of an postal code instance.

```java
@Put
public HttpStatus update(@Valid PostalCodePutModel model) {
    return HttpStatus.OK;
}
```

### Assignment 3 - Add support for street & house numbers 🛠

The application holds a list of postal codes and city names. Your task is to add streets and house numbers to it such as _Untermoosstrasse 36, 8047 Zurich_ contains information such as

- Street name
- House number

Make sure a street & house number always is assigned to a postal code. Expose a list of streets with their postal code on the REST API at `/api/v1/streets`.

### Assignment 4 - Prepare a brief presentation 💡

In the 2nd interview you present your solution and explain your design decisions. Be prepared for a brief Q&A.

## Unit & Integration Tests

Please find and extend the test at `server/src/test/groovy`. The tests are written in Groovy using Spock.

## Code style

The code style is being enforced by the Gradle build. If you run into code style issues simply run `./gradlew spotlessApply` and your code style will be compliant.

## Once you are done 🎓

When you are done with your work please give `saw303` access to your private fork repository and send me the link to the repository at silvio@onstructive.ch. Thank you.

## Questions ❔

If you have any questions please do not hesitate to contact me at silvio@onstructive.ch
