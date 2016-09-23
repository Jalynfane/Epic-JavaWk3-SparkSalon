# Spark Salon
Version 0.0.0: September 23, 2016

by [Karen Freeman-Smith](https://github.com/karenfreemansmith)

## Description
Final Project for Week 3, Java at Epicodus. A program to manage a hair salon with stylists and clients using Java, PostgreSQL, and Spark with JUnit tests and RESTful routing.


### Specifications
#### User Stories:
* As a salon employee, I need to be able to see a list of all our stylists.
* As an employee, I need to be able to select a stylist, see their details, and see a list of all clients that belong to that stylist.
* As an employee, I need to add new stylists to our system when they are hired.
* As an employee, I need to be able to add new clients to a specific stylist.
* As an employee, I need to be able to update a stylist's details.
* As an employee, I need to be able to update a client's details.
* As an employee, I need to be able to delete a stylist if they're no longer employed here.
* As an employee, I need to be able to delete a client if they no longer visit our salon.

#### Database Diagram:
![database diagram](database.png)

#### Technical Specifications:
(insert table here)

## Setup/Installation
* Clone directory
* Setup database in PSQL:
  * CREATE DATABASE hair_salon;
  * \c hair_salon
  * CREATE TABLE clients (id serial PRIMARY KEY, stylistid int, firstname varchar, lastname varchar, address varchar, city varchar, state varchar, zip int, age int, notes varchar);
  * CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);
  * CREATE TABLE appointments (id serial PRIMARY KEY, time timestamp, procedureid int, clientid int);
  * CREATE TABLE porcedures (id serial PRIMARY KEY, description varchar, price float);
  * CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;
* Type 'gradle run' inside the directory
* Navigate to 'http://localhost:4567'

## Support & Contact
For questions, concerns, or suggestions please email karenfreemansmith@gmail.com

## Known Issues
* N/A

## Technologies Used
Java, JUnit, Spark, PostgreSQL, Gradle

## Legal
*Licensed under the GNU General Public License v3.0*

Copyright (c) 2016 Copyright _Karen Freeman-Smith_ All Rights Reserved.
