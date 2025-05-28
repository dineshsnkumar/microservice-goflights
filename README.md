## Go Flights
- A microservice based flight ticketing system

### Functionality
- Users can register and manage their profile
- Listing of flights based on origin, destination, travel dates and number of travellers
- Users can book a flight


### Description

- Flights and users microservices are built with Spring Boot and Spring Data
- It uses H2 and MySQL databases 
- Spring Cloud Config along with RabbitMQ is used to manage configurations related to microservices in local, QA and PROD env
- Eureka is used for service discovery and registration
- RabbitMQ is used for pub/sub and Kafka for event streaming to send notifications to users
- Docker compose is used to build the env


### Future plans

- Add Observability and Monitoring
- Spring Security -> OAuth, JWT
- Convert the entire project to use K8s 
- Add Elasticsearch to the project for keyword lookup
- Implement SAGA design patterns for transactions 