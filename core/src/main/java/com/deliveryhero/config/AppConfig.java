package com.deliveryhero.config;

import com.deliveryhero.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "com.deliveryhero")
public class AppConfig {

    @Bean
    public INumberGenerator numberGenerator() {
        return new NumberGenerator();
    }

    @Bean
    public IGame game() {
        return new Game();
    }

    @Bean
    public IMessageGenerator messageGenerator() {
        return new MessageGenerator();
    }
}
