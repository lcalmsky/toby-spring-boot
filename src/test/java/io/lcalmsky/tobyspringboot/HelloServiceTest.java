package io.lcalmsky.tobyspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

  @Test
  void simpleHelloService() {
    SimpleHelloService simpleHelloService = new SimpleHelloService(helloRepository());
    String actual = simpleHelloService.hello("jaime");
    assertEquals("hello jaime", actual);
  }

  @Test
  void helloDecorator() {
    HelloDecorator helloDecorator = new HelloDecorator(new SimpleHelloService(helloRepository()));
    String actual = helloDecorator.hello("jaime");
    assertEquals("*hello jaime*", actual);
  }

  private HelloRepository helloRepository() {
    return new HelloRepository() {
      @Override
      public Hello findHello(String name) {
        return null;
      }

      @Override
      public void increaseCount(String name) {

      }
    };
  }
}