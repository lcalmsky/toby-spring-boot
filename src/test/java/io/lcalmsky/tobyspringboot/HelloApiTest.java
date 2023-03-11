package io.lcalmsky.tobyspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HelloApiTest {

  @Test
  void helloApi() {
    // given
    TestRestTemplate testRestTemplate = new TestRestTemplate();
    // when
    ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
        "http://localhost:9090/app/hello?name={name}", String.class, "jaime");
    // then
    assertSame(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("*hello jaime*", responseEntity.getBody());
    assertTrue(
        Objects.requireNonNull(responseEntity.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE))
            .startsWith(MediaType.TEXT_PLAIN_VALUE));
  }

  @Test
  void failsHelloApi() {
    // given
    TestRestTemplate testRestTemplate = new TestRestTemplate();
    // when
    ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
        "http://localhost:9090/app/hello?name=", String.class);
    // then
    assertSame(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
  }
}
