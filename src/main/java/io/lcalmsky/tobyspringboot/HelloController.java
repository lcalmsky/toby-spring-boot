package io.lcalmsky.tobyspringboot;

import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  @GetMapping
  public String hello(String name) {
    return helloService.hello(Objects.requireNonNull(name));
  }
}
