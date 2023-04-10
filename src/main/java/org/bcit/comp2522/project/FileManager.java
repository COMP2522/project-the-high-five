package org.bcit.comp2522.project;

import java.io.*;
import org.json.JSONObject;




/**
 * Write game data to local file.
 *
 * @author Cheryl Lau version 1.0 2023
 */
public class FileManager {


    public static void writeToFile(GameState gameState) {
        JSONObject jsonObject = getGameStateAsJson(gameState);
        try (FileWriter file = new FileWriter("saveData.json")) {
            file.write(jsonObject.toString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("saveData.json"))) {
            String json = reader.readLine();
            JSONObject jsonObject = new JSONObject(json);
            return jsonObject;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readAndLoadFromFile() {

        loadGameStateFromJsonObject(readFromFile());
    }




    public static void loadGameStateFromJsonObject(JSONObject jsonObject) {
        int currentLevel = jsonObject.getInt("currentLevel");
        int numCoins = jsonObject.getInt("numCoins");
        int playerHealth = jsonObject.getInt("playerHealth");
        int currentScore = jsonObject.getInt("currentScore");
        int enemiesKilled = jsonObject.getInt("killed");

        LevelManager.setCurrentLevel(currentLevel);
        Player.setCoins(numCoins);
        Player.setHealth(playerHealth);
        Player.setCurrentScore(currentScore);
        EnemyManager.setEnemiesKilled(enemiesKilled);
    }


    public static JSONObject getGameStateAsJson(GameState gameState) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("playerHealth", gameState.getPlayerHealth());
        jsonObject.put("numCoins", gameState.getCoins());
        jsonObject.put("currentScore", gameState.getCurrentScore());
        jsonObject.put("currentLevel", gameState.getCurrentLevel());
        jsonObject.put("killed", gameState.getEnemiesKilled());
        return jsonObject;
    }


}


