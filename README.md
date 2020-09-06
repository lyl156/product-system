# Product-system  
Spring-CRUD-product-system is web app demonstrating CRUD operations.  
## Performance  
- Implement Ranking list with Redis.  
When ranking stored in DB change frequently,
the number of access to DB is huge. Cache can reduce access burden of DB.  
- message with Kafka 
## Availability  
- stateless service failover through load balance
- CI/CD  
- Data/ DB backup  
- Monitor and manage data  
## Scalability  
- server load balance  
## Security  
- Prevent XSS with Filter
## Package  
This web app is based on :  
- Maven  
- Spring Boot  
- Spring MVC  
- Spring data JPA(Hibernate, MySQL)  
- Redis  
- Thymleaf  
## Usage  
1. Install Redis and start at port 6379(default port number)  
2. Import this project in IDE to resolve the dependencies  
3. Start this project with H2 or change `spring.profiles.active` in application.properties to start with MySQL  
4. Run this project  