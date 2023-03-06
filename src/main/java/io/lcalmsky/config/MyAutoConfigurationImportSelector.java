package io.lcalmsky.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigurationImportSelector implements DeferredImportSelector {

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[]{
        "io.lcalmsky.config.autoconfig.DispatcherServletConfiguration",
        "io.lcalmsky.config.autoconfig.TomcatWebServerConfiguration"
    };
  }
}
