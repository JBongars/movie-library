#Movie Project

This project is incomplete as it is still missing the following components:

API
============
1. API cannot read JSON using Jackson
2. API controller has no PUT method available
3. API cannot serve static files (serve through POM or through @RequestMapping or through @Configuration)
4. No native command to build and deploy app (mvn build is failing due to pom but works on intellij IDEA)
5. Ideally, would like to include some kind of database

Client
============
1. No controls for accessing/ updating items
2. Package management a little messy, would like to remove npm
3. Would like to configure npm start to build and configure everything automatically


Overall, that was a pretty hard weekend.



INSTRUCTIONS TO LOAD
======================
1. Install npm components by running: `npm install`
2. Install bower components by running: `bower install`
3. Compile and run Spring Boot Application by running on Eclipse IDE or Intellij IDEA (Working to improve this step)
1. Run Command `simple-server src/main/resources/static 5000` to start client web page