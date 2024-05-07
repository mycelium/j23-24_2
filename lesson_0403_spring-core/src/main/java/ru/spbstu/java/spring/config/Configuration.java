package ru.spbstu.java.spring.config;

import org.springframework.context.annotation.Bean;
import ru.spbstu.java.spring.components.Cat;
import ru.spbstu.java.spring.components.Tail;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Tail publicTail(){
        return new Tail(10000);
    }
    @Bean
    public Cat redCat() {
        return new Cat("Kesha", 5, "Red");
    }

    @Bean
    public Cat greyCat() {
        return new Cat("Vasya", 2, "Grey");
    }

    @Bean
    public Cat blackCat() {
        return new Cat("Boris", 1, "Black");
    }
}
