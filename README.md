# myRetail_RESTful_Service2

# Purpose
create a RESTful service that can retrieve product and price details by ID. 
# Functions
Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number.
Performs an HTTP GET to retrieve the product name from an external API. 
Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response. 
In total get ID, Name, current_price, and currency_code
BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store. 

# Technologies
VS Code
Java
Maven Wrapper
Spring Boot
Tomcat
MongoDB Atlas

# Screenshots of everything working

Database
![image](https://user-images.githubusercontent.com/33266684/124628783-6fd15980-de46-11eb-9c8f-00f6c8ac38c6.png)

Pull of database data
![image](https://user-images.githubusercontent.com/33266684/124628451-179a5780-de46-11eb-9ce9-51353d9f98f4.png)

Json data on retail service site of a product with a tcin id.
![image](https://user-images.githubusercontent.com/33266684/124629470-187fb900-de47-11eb-9f2c-9837f3a59529.png)

After matching by id with PriceData stored in the database a page is returned with the Product and PriceData
![image](https://user-images.githubusercontent.com/33266684/124630682-49acb900-de48-11eb-9f8e-2e146947e56b.png)


# Sources
https://www.youtube.com/watch?v=uq4GjRF_860
I used this to get started with Spring Boot and Maven in VS Code
https://spring.io/guides/gs/rest-service/
https://spring.io/guides/gs/consuming-rest/
https://www.baeldung.com/jackson-object-mapper-tutorial
https://docs.spring.io/spring-framework/docs/current/javadoc-api/overview-summary.html
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/package-summary.html
https://www.mongodb.com/java
https://spring.io/guides/tutorials/rest/
https://www.youtube.com/watch?v=OROTCvW1lZE
Request param vs path var
