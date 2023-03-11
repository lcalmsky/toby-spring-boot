package io.lcalmsky.tobyspringboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloDecorator implements HelloService {

  private final HelloService helloService;

  public HelloDecorator(HelloService helloService) {
    this.helloService = helloService;
  }

  @Override
  public String hello(String name) {
    return "*%s*".formatted(helloService.hello(name));
  }

  @Override
  public int countOf(String name) {
    return helloService.countOf(name);
  }
}
