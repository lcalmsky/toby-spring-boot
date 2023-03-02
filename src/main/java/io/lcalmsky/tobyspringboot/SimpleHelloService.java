package io.lcalmsky.tobyspringboot;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService {

  @Override
  public String hello(String name) {
    return "hello " + name;
  }
}
