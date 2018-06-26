# Movie Library Project

Simple project to demonstrate basic functionality using Java Spring Boot and AngularJS. Any comments are welcome!

#### Requirements
1. Node v8.10.0
2. NPM v6.0.0
3. Java JDK v10.0.1
4. Maven v3.5.4

### Instructions to Load
1. Install npm components by running: `npm install`
2. Install bower components by running: `bower install`
3. Run Command `mvn project` to build application
1. Run Command `simple-server src/main/resources/static 5000` to start client web page

### Improvements since 25/06/2018
1. PUT Method works for updating movies
2. Enable CORS on API for seperate client-facing app
3. Improved User Interface for creating, deleting and updating items
4. Integrated client-facing app with OMBDAPI service for fetching suggested movies.

### Needs Improvements
1. Load Data from external file using Jackson (or ideally, as some kind of database)
3. Configure npm start to build and configure everything automatically