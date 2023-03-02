package io.lcalmsky.tobyspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

  @Test
  void simpleHelloService() {
    SimpleHelloService simpleHelloService = new SimpleHelloService();
    String actual = simpleHelloService.hello("jaime");
    assertEquals("hello jaime", actual);
  }

}