package io.lcalmsky.tobyspringboot;

public interface HelloService {

  String hello(String name);

  default int countOf(String name) {
    return 0;
  };
}
