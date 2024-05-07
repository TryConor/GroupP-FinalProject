package edu.mu.finalproject.hangman;

public interface Subject {
	void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
