package com.deliveryhero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGenerator implements IMessageGenerator {
    private static final Logger log = LoggerFactory.getLogger(MessageGenerator.class);

    @Autowired
    private IGame game;
    private int guessCount = 10;

    @PostConstruct
    public void init() {
        log.info("The Game was created - {}", game != null);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest()
                + " and " + game.getBiggest()
                + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        } else if (game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        } else if (game.getRemainingGuesses() == guessCount) {
            return "What is your first guess?";
        } else {
            var direction = "Lower";

            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }

            return direction + "! You have " + game.getRemainingGuesses() + " guesses left.";
        }
    }
}
