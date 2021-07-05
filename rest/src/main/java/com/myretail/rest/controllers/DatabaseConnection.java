package com.myretail.rest.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.bson.Document;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.configuration.CodecRegistries;

import com.mongodb.*;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.codecs.pojo.PojoCodecProvider;

import com.myretail.rest.classes.PriceData;

import java.util.*;
@Component
public class DatabaseConnection implements CommandLineRunner {

    public List<PriceData> getPriceData()
    {
      ConnectionString connectionString = new ConnectionString("mongodb+srv://Admin:Admin@cluster0.5b5wj.mongodb.net/myretail_prices?retryWrites=true&w=majority");
      CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder()
              .automatic(true)
              .build()));
      MongoClientSettings settings = MongoClientSettings.builder()
              .applyConnectionString(connectionString)
              .codecRegistry(codecRegistry)
              .build();
      MongoClient mongoClient = MongoClients.create(settings);
      MongoDatabase database = mongoClient.getDatabase("myretail_prices");
      MongoCollection<Document> collection = database.getCollection("priceData");
      
      List<PriceData> allPriceData = collection.find(new Document(), PriceData.class).into(new ArrayList<PriceData>());
      for(PriceData priceData:allPriceData) {
        System.out.println(priceData.toString());
      }

      return allPriceData;
    }
    

    @Override
    public void run(String...args) throws Exception {
      //getPriceData();
    }
    
}
