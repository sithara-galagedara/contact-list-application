## Contact List Web System

![alt text]([https://github.com/[username]/[reponame]/blob/[branch]/application-snapshot.PNG](https://github.com/sithara-galagedara/contact-list-application/blob/main/application-snapshot.PNG)?raw=true)

Available Functions

1. Search People By Name
2. Visibility of All the People Details

### Backend Technical Implementations 

1.Spring Data JPA and the configurations added. At the moment this is only a Database ready system and database configurations and entities added to connect a database while going forward. Make sure to remove the exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class} part from the ContactListApplication class when database connected.

2.For all the package classes related logins added the LoggingAspect

3.PeopleEntity class is the mapping for the database and to transfer the data from persistence layer to front-end, uses PeopleDTO class. SharedEntity class added to keep the record audit details and this class gets inherits from the PeopleEntity.

4.CSV file is available in the resource folder and when loading the application from the front-end it will show all the fetched data from CSV. At the moment CSV file uses as the datasource

5.CorsFilter added to handle CORS pre-flight requests

6.Application can run on the profiles Dev, Prod & Test. In default it's set to run on Dev profile

### How to run the Backend Services?

1.Open the project as a Maven project and perform a maven install to resolve the relevant libraries

2.Run the application

4.Configured port is 8090 and access the backend with URL http://localhost:8090

Shows all the people : http://localhost:8090/people

Search by name : http://localhost:8090/people/search?personName=Moe%20Szyslak

### Frontend Technical Implementations 

1.Frontend contains only a single component People

2.Http Service added in to the component to handle all backend calls 

3.To change the base url refer the environment file

### How to run the Frontend ?

1.Install the latest node version

2.Open the project from an any IDE

3.Perform a npm install to install all the dependencies

4.Type ng serve to run the application

5.Navigate to the http://localhost:4200/

