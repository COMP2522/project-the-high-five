package org.bcit.comp2522.project;

import java.io.*;
import org.json.JSONObject;

/**
 * Responsible for reading and writing game data from/to local file.
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class FileManager {


    /**
     * Writes the game state to a file name "saveData.json".
     *
     * @param gameState The game state to be written to the file.
     */
    public static void writeToFile(GameState gameState) {
        JSONObject jsonObject = getGameStateAsJson(gameState);
        try (FileWriter file = new FileWriter("saveData.json")) {
            file.write(jsonObject.toString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads the game state from a file named "saveData.json".
     *
     * @return The game state in a JSON object.
     */
    public static JSONObject readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("saveData.json"))) {
            String json = reader.readLine();
            JSONObject jsonObject = new JSONObject(json);
            return jsonObject;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads the game state from a file and loads it into the game.
     */
    public static void readAndLoadFromFile() {

        loadGameStateFromJsonObject(readFromFile());
    }


    /**
     * Loads the game state from a JSONObject and updates the game accordingly.
     *
     * @param jsonObject the JSONObject containing the game state.
     */
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


    /**
     * Converts the game state to a JSONObject.
     *
     * @param gameState The game state to be convereted to a JSONObject.
     * @return The game state as a JSONObject.
     */
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


