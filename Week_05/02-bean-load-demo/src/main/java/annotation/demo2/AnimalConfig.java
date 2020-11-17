package annotation.demo2;

import annotation.demo1.Dog;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AnimalConfig {

    @Bean
    @ConditionalOnProperty(prefix = "animal", name = "dog")
    public Dog getDog(){
        return  new Dog();
    }


    @Bean
    @ConditionalOnProperty(prefix = "animal", name = "cat")
    public Cat getCat(){
        return new Cat();
    }
}
