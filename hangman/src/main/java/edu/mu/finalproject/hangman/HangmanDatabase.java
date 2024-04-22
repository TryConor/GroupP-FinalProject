package edu.mu.finalproject.hangman;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HangmanDatabase {
    private JsonObject database;

    public HangmanDatabase() {
        try {
            Gson gson = new Gson();
            String filePath = Paths.get("files", "hangman_database.json").toString();
            FileReader reader = new FileReader(filePath);
            database = gson.fromJson(reader, JsonObject.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getWordsForLevel(String category, String level) {
        JsonObject categoryObject = database.getAsJsonObject("categories").getAsJsonObject(category);
        JsonArray jsonArray = categoryObject.getAsJsonArray(level);
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            wordList.add(jsonArray.get(i).getAsString());
        }
        return wordList.toArray(new String[0]);
    }
}
