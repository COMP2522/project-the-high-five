package org.bcit.comp2522.project;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class DatabaseHandler {

    MongoDatabase database;

    public DatabaseHandler(String username, String password){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://" + username + ":" + password + "@2522.ru0dahn.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        this.database = mongoClient.getDatabase("towerDefence");


        try {
            database.createCollection("highScores");
        } catch (Exception e) {
            System.out.println("Collection already in database");
        }

    }

    public void put(String key, String val, String collectionName){

        Document document = new Document();
        document.append(key, val);
        new Thread(()->database.getCollection(collectionName).insertOne(document)).start();

    }

    public void insertHighScore(String user, int score, String collectionName){

        Document document = new Document();
        document.append("user", user)
        .append("score",score);
        new Thread(()->database.getCollection(collectionName).insertOne(document)).start();

    }
    public static void main(String[] args) {

        DatabaseHandler dbh = new DatabaseHandler("testuser", "cake1234");

//        dbh.insertHighScore("cheryl", 1700, "highScores");
//        dbh.insertHighScore("cheryl", 2100, "highScores");



        Document find = dbh.database.getCollection("highScores").find(eq("user", "cheryl")).first();

        System.out.println(find);



    }


}