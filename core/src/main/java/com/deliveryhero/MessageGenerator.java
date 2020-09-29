package com.deliveryhero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGenerator implements IMessageGenerator {
    private static final Logger log = LoggerFactory.getLogger(MessageGenerator.class);

    private final IGame game;

    public MessageGenerator(IGame game) {
        this.game = game;
    }

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
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
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
