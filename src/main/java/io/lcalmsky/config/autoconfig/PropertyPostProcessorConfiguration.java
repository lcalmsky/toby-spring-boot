package io.lcalmsky.config.autoconfig;

import io.lcalmsky.config.MyAutoConfiguration;
import io.lcalmsky.config.MyConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class PropertyPostProcessorConfiguration {

  @Bean
  BeanPostProcessor postProcessor(Environment environment) {
    return new BeanPostProcessor() {
      @Override
      public Object postProcessAfterInitialization(Object bean, String beanName)
          throws BeansException {
        MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(),
            MyConfigurationProperties.class);
        if (annotation == null) {
          return bean;
        }
        return Binder.get(environment).bindOrCreate(annotation.prefix(), bean.getClass());
      }
    };
  }
}
