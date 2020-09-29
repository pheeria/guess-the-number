package com.deliveryhero.console;

import com.deliveryhero.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        var context = new AnnotationConfigApplicationContext(GameConfig.class);
        context.close();
    }
}
