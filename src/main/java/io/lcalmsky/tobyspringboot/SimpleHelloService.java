package io.lcalmsky.tobyspringboot;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService {

  private final HelloRepository helloRepository;

  public SimpleHelloService(HelloRepository helloRepository) {
    this.helloRepository = helloRepository;
  }

  @Override
  public String hello(String name) {
    helloRepository.increaseCount(name);
    return "hello " + name;
  }

  @Override
  public int countOf(String name) {
    return helloRepository.countOf(name);
  }
}
