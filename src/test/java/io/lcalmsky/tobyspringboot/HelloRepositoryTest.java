package io.lcalmsky.tobyspringboot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HellobootTest
class HelloRepositoryTest {
  @Autowired
  HelloRepository helloRepository;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @BeforeEach
  void setup() {
    jdbcTemplate.execute(
        "create table if not exists hello(name varchar(50) primary key, count int)");
  }

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