package edu.mu.finalproject.hangman;
import java.util.Set;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Database {
	
	public void addCategory(String category, Map<String, List<String>> levelWords) {
        categories.put(category, levelWords);
        notifyObservers();
    }
}
