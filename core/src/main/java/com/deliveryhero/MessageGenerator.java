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
        return "This is the Main Message";
    }

    @Override
    public String getResultMessage() {
        return "You lost, apparently";
    }
}
