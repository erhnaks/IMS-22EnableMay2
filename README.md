# QA 22MayEnable2 Software Core Fundemental Project - Inventory Management System (IMS)


## Contents:
* [Project Brief](#Project-Brief)  
* [Getting Started](#Getting-Started)
* [Prerequisites](#Prerequisites)  
* [Installing](#Installing)
* [MySQL Database](#MySQL-Database)
* [Project Management](#Project-Management)
* [Tests](#Tests)
* [Deployment](#Deployment)
* [Versioning](#Versioning)
* [Authors](#Authors)
* [License](#License)
* [Acknowledgments](#Acknowledgments)

# Project Brief

Inventory Management System written in Java. In this application a user can create customers, items and orders with full create, read, update and delete operations.
The system accepts orders with an item id and calculate the total cost of that order. This then can be read from the database later, update or even deleted.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Please use this link to clone the app [Github-Link](https://github.com/erhnaks/IMS-22EnableMay2)

### Prerequisites

What things you need to install the software and how to install them

You need the following software to build and run this application;

* Java JDK
* Maven
* Git for version control
* Eclipse IDE 

### Installing

1. Clone the repository from [Github-Link](https://github.com/erhnaks/IMS-22EnableMay2)
2. Install it ims mvn java -jar (This will make sure the Java file executes)
3. Open the project on Eclipse

Once the application is built succesfully, the application then can be used to create, read, update or delete the followings from the database;
* Customers
* Items
* Orders


### MySQL Database

##### Initial Application ERD;

![ERD1](https://user-images.githubusercontent.com/97620234/172918017-fefda8c3-0226-4495-b58e-ce296cd438a4.png)


##### Final Application ERD;

![ERD2Final](https://user-images.githubusercontent.com/97620234/172917642-07f724ea-e5a3-45cd-84ee-fe97374a809a.png)


## Project Management

Jira was used for project management including GitHub Smart commits.

![JiraBoard_Image](https://user-images.githubusercontent.com/97620234/172918783-49f0a5d4-0e2e-498d-a58d-a16fc87da5b5.png)

## Tests

## Running the tests

The unit and integration tests are written for the application and you may access them on src/test/java. To run the test for this application simple left click on the folder and select Run as Junit Test.

### Unit Tests 

These tests are written to test the functions of the application and its methods.

Here is an example of an Unit Test

	@Test
	public void constructorWithoutId() {
		Item item = new Item("phone", 1.99F);
		assertNull(item.getItem_id());
		assertNotNull(item.getItem_name());
		assertNotNull(item.getPrice());
	}


### Integration Tests 

Mockito has been used for integration tests. Here is an example of one of the mockito test that has been created;

@Test
	public void testCreate() {
		final String F_NAME = "barry", L_NAME = "scott";
		final Customer created = new Customer(F_NAME, L_NAME);

		Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}


# Deployment

### Deployment

Maven Deployment Tool has been used to deploy this application.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [Github](http://github.com) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Erhan Aksu** [Github-Link](https://github.com/erhnaks/IMS-22EnableMay2)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
# IMS-Start
# IMS-Start
