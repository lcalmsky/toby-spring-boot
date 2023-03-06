package io.lcalmsky.config;

import io.lcalmsky.config.autoconfig.DispatcherServletConfiguration;
import io.lcalmsky.config.autoconfig.TomcatWebServerConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({TomcatWebServerConfiguration.class, DispatcherServletConfiguration.class})
public @interface EnableMyAutoConfiguration {

}
