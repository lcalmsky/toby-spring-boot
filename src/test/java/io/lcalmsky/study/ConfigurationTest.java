package io.lcalmsky.study;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {

  @Test
  void configuration() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(MyConfig.class);
    context.refresh();
    Bean1 bean1 = context.getBean(Bean1.class);
    Bean2 bean2 = context.getBean(Bean2.class);
    assertSame(bean1.common, bean2.common);
  }

  @Test
  void proxyCommonMethod() {
    MyConfigProxy myConfigProxy = new MyConfigProxy();
    Bean1 bean1 = myConfigProxy.bean1();
    Bean2 bean2 = myConfigProxy.bean2();
    assertSame(bean1.common, bean2.common);
  }

  static class MyConfigProxy extends MyConfig {

    private Common common;

    @Override
    Common common() {
      if (this.common == null) {
        this.common = super.common();
      }
      return this.common;
    }
  }

  @Configuration
  static class MyConfig {

    @Bean
    Common common() {
      return new Common();
    }

    @Bean
    Bean1 bean1() {
      return new Bean1(common());
    }

    @Bean
    Bean2 bean2() {
      return new Bean2(common());
    }
  }

  static class Bean1 {

    private final Common common;

    Bean1(Common common) {
      this.common = common;
    }
  }

  static class Bean2 {

    private final Common common;

    Bean2(Common common) {
      this.common = common;
    }
  }

  static class Common {

  }

}
