package com.myretail.rest.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Component
public class DatabaseConnection implements CommandLineRunner {
    

    @Override
    public void run(String...args) throws Exception {
        System.out.println("hello");
    }
    // 
//     ConnectionString connectionString = new ConnectionString("mongodb+srv://Admin:<password>@cluster0.5b5wj.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
// MongoClientSettings settings = MongoClientSettings.builder()
//         .applyConnectionString(connectionString)
//         .build();
// MongoClient mongoClient = (MongoClient) MongoClients.create(settings);
// MongoDatabase database = mongoClient.getDatabase("myretail_prices");
    
}
