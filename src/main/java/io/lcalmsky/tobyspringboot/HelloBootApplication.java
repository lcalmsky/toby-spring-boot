package io.lcalmsky.tobyspringboot;

import io.lcalmsky.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
public class HelloBootApplication {

  @Bean
  ApplicationRunner applicationRunner(Environment environment) {
    return args -> {
      String name = environment.getProperty("my.name");
      System.out.println("name = " + name);
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(HelloBootApplication.class, args);
  }
}
