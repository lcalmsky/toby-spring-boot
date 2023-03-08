package io.lcalmsky.tobyspringboot;

import io.lcalmsky.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class HelloBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloBootApplication.class, args);
  }
}
