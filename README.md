INSTRUCTIONS:
This project was built mostly using SpringBoot, Jquery and mySql.

The application can be accessed through the URL bellow and a "The Random Beer App!" page will be displayed.
http://localhost:8080/beer-app/

The deployment can be made using the following alternatives:
1) putting the beer-app.WAR into the Tomcat's webapps folder.
2) executing a command line: java -jar beer-app.war

It is possible import the source code to any IDE supporting Maven. 
Use Java 8 and Tomcat 8 to run the application.
The database is placed in a Docker container running in a EC2 AWS instance.
It was used data to populate the beerdb from http://openbeerdb.com/