package com.deliveryhero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Game implements IGame {
    @Autowired
    private INumberGenerator numberGenerator;
    private int smallest;
    private int biggest;
    private int number;
    private int guess;
    private int guessCount = 10;
    private int remainingGuesses;
    private static final Logger log = LoggerFactory.getLogger(Game.class);

    public Game(INumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    @PostConstruct
    public void reset() {
        smallest = 0;
        biggest = numberGenerator.getMaxNumber();
        remainingGuesses = guessCount;
        guess = 0;
        number = numberGenerator.next();
        log.debug("New number is {}", number);
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public void check() {
        if (isValidNumber()) {
            if (guess > number) {
                biggest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    @Override
    public boolean isValidNumber() {
        return smallest <= guess && guess <= biggest;
    }
}
