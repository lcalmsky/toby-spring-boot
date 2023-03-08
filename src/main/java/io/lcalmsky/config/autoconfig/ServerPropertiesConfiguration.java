package io.lcalmsky.config.autoconfig;

import io.lcalmsky.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfiguration {

  @Bean
  ServerProperties serverProperties(Environment environment) {
    ServerProperties serverProperties = new ServerProperties();
    serverProperties.setContextPath(environment.getProperty("context-path"));
    serverProperties.setPort(Integer.parseInt(environment.getProperty("port")));
    return serverProperties;
  }
}
