package com.deliveryhero;

public interface IGame {
    int getSmallest();
    int getBiggest();
    int getRemainingGuesses();
    int getNumber();
    int getGuess();
    void setGuess(int guess);
    void check();
    void reset();
    boolean isGameWon();
    boolean isGameLost();
    boolean isValidNumber();
}
