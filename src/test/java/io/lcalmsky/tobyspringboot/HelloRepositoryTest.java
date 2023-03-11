package io.lcalmsky.tobyspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
class HelloRepositoryTest {

  @Autowired
  HelloRepository helloRepository;

  @Test
  void findHelloFailed() {
    Hello hello = helloRepository.findHello("foo");
    assertNull(hello);
  }

  @Test
  void increaseCount() {
    assertEquals(0, helloRepository.countOf("jaime"));
    helloRepository.increaseCount("jaime");
    assertEquals(1, helloRepository.countOf("jaime"));
    helloRepository.increaseCount("jaime");
    assertEquals(2, helloRepository.countOf("jaime"));
  }

}