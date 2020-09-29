package com.deliveryhero.console;

import com.deliveryhero.IGame;
import com.deliveryhero.IMessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class NumberGuess {
    private static final Logger log = LoggerFactory.getLogger(NumberGuess.class);
    private final IGame game;
    private final IMessageGenerator messageGenerator;

    public NumberGuess(IGame game, IMessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onStart() {
        log.info("Everything is ready.");

        var scanner = new Scanner(System.in);

        while (true) {

            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            var guess = scanner.nextInt();
            scanner.nextLine();

            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");
                var answer = scanner.nextLine().trim();

                if (answer.equalsIgnoreCase("n")) {
                    break;
                } else {
                    game.reset();
                }

            }
        }
    }
}
