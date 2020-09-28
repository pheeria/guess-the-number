package com.deliveryhero.console;

import com.deliveryhero.AppConfig;
import com.deliveryhero.IGame;
import com.deliveryhero.IMessageGenerator;
import com.deliveryhero.INumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var numberGenerator = context.getBean(INumberGenerator.class);

        log.info("Number {}",numberGenerator.next());

        var game = context.getBean(IGame.class);
        var messageGenerator = context.getBean(IMessageGenerator.class);
        log.info(messageGenerator.getMainMessage());
        log.info(messageGenerator.getResultMessage());

        context.close();
    }
}
