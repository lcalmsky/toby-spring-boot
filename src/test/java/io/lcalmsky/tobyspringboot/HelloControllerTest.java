package io.lcalmsky.tobyspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class HelloControllerTest {

  @Test
  void helloController() {
    HelloController helloController = new HelloController(name -> name);
    String actual = helloController.hello("jaime");
    assertEquals("jaime", actual);
  }

  @Test
  void failsHelloController() {
    HelloController helloController = new HelloController(name -> name);
    assertThrows(IllegalArgumentException.class, () -> helloController.hello(null));
    assertThrows(IllegalArgumentException.class, () -> helloController.hello(""));
  }
}