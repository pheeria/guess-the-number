package com.deliveryhero;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Getter
@Component
public class Game implements IGame {
    @Getter(AccessLevel.NONE)
    private final INumberGenerator numberGenerator;
    private final int guessCount;
    private int smallest;
    private int biggest;
    private int number;
    private int remainingGuesses;
    @Setter
    private int guess;

    @Autowired
    public Game(INumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    @Override
    @PostConstruct
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        biggest = numberGenerator.getMaxNumber();
        remainingGuesses = guessCount;
        guess = smallest;
        number = numberGenerator.next();
        log.debug("New number is {}", number);
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
