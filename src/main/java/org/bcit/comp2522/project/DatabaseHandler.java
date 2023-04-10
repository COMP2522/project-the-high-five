package org.bcit.comp2522.project;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

/**
 * This class represents a handler for a MongoDB database.
 */
public class DatabaseHandler {

    private MongoDatabase database;

    private String username = "testuser";
    private String password = "cake1234";

    /**
     * Constructs a new instance of DatabaseHandler and establishes a connection to the MongoDB database.
     * The connection string used to connect includes the username and password of the database user and the name
     * of the database to connect to.
     */
    public DatabaseHandler(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://" + username + ":" + password
                + "@2522.ru0dahn.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        this.database = mongoClient.getDatabase("towerDefence");




    }

    /**
     * Inserts a new high score record into the "highScores" collection in the database. The insertion
     * is performed asynchronously in a separate thread.
     * @param user the user who acheived the high score.
     * @param score the value of the high score achieved.
     */
    public void insertHighScore(String user, int score){

        Document document = new Document();
        document.append("user", user)
                .append("score",score);
        new Thread(()->database.getCollection("highScores").insertOne(document)).start();

    }

    /**
     * Retrieves the top 8 high scores from the "highScores" collection in the database, sorted in descending order by
     * score, then in ascending order by user name.
     * @return an ArrayList of HighScore objects representing the top 8 high scores
     */
    public ArrayList<Highscore> retrieveHighScores() {
        FindIterable<Document> cursor = this.database.getCollection("highScores")
                .find()
                .sort(new Document("score", -1).append("user", 1))
                .limit(8);

        ArrayList<Highscore> highscores = new ArrayList<Highscore>();
        for (Document document : cursor) {
            Highscore highscore = new Highscore();
            highscore.setUser(document.getString("user"));
            highscore.setHighscore(document.getInteger("score"));
            highscores.add(highscore);
        }
        return highscores;
    }

    /**
     * Writes the current state of the game to the "gamestate" collection in the database.
     * If the
     * @param gameState
     */
    public void writeGameState(JSONObject jsonObject){

        try {
            database.createCollection("gamestate");
        } catch (Exception e) {
        }

        UpdateOptions options = new UpdateOptions().upsert(true);
        Document gamestateDocument = new Document();
        gamestateDocument.append("player", "player");
        gamestateDocument.append("health",jsonObject.getInt("playerHealth"));
        gamestateDocument.append("coins", jsonObject.getInt("numCoins"));
        gamestateDocument.append("score", jsonObject.getInt("currentScore"));
        gamestateDocument.append("currentLevel", jsonObject.getInt(("currentLevel")));
        gamestateDocument.append("killed", jsonObject.getInt("killed"));
        database.getCollection("gamestate").updateOne(
                eq("player", "player"),
                new Document("$set", gamestateDocument),
                options
        );

    }

    /**
     * Retrieves the current game state from the database and creates a new GameGate object with the retrieved data.
     *
     * @param window the current game window
     * @return a GameState object with the current game state data, or null if the game state not found in the database.
     */
    public GameState getGameState(Window window) {
        Document gamestateDocument = database.getCollection("gamestate")
                .find(eq("player", "player")).first();
        if (gamestateDocument == null) {
            return null;
        }
        int health = gamestateDocument.getInteger("health");
        int coins = gamestateDocument.getInteger("coins");
        int score = gamestateDocument.getInteger("score");
        int currentLevel = gamestateDocument.getInteger("currentLevel");
        int killed = gamestateDocument.getInteger("killed");
        GameState gameState = new GameState(Player.getInstance(), window);
        gameState.setHealth(health);
        gameState.setCoins(coins);
        gameState.setScore(score);
        gameState.setCurrentLevel(currentLevel);
        gameState.setEnemiesKilled(killed);
        return gameState;
    }



}