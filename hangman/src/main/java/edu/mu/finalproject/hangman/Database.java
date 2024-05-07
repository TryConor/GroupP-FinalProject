package edu.mu.finalproject.hangman;
import java.util.Set;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import edu.mu.Game.Observer;
import edu.mu.Game.Subject;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database implements Subject{
	private Map<String, Map<String, List<String>>> categories;
	private List<Observer> observers;
	
	public Database() {
        categories = new HashMap<>();
        observers = new ArrayList<>();
    }
	public Map<String, Map<String, List<String>>> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, Map<String, List<String>>> categories) {
        this.categories = categories;
    }

    public void addCategory(String category, Map<String, List<String>> levelWords) {
        categories.put(category, levelWords);
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void removeObserver(edu.mu.Game.Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}
}
