package com.deliveryhero.config;

import com.deliveryhero.GuessCount;
import com.deliveryhero.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    private int maxNumber = 42;
    private int guessCount = 8;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
