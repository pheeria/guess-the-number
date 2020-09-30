package com.deliveryhero.console;

import com.deliveryhero.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Guess The Number Game");

        var context = new AnnotationConfigApplicationContext(GameConfig.class);
        context.close();
    }
}
