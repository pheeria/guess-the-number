package com.deliveryhero.config;

import com.deliveryhero.GuessCount;
import com.deliveryhero.MaxNumber;
import com.deliveryhero.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.deliveryhero")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    @Value("${game.maxNumber:20}")
    private int maxNumber;
    @Value("${game.minNumber:0}")
    private int minNumber;
    @Value("${game.guessCount:4}")
    private int guessCount;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
