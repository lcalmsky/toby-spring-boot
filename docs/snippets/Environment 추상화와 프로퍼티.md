### Environment Abstraction - Properties

1. StandardEnvironment
   1. System Properties
   2. System Environment Variables
2. StandardServletEnvironment
   1. ServletConfig Parameters
   2. ServletContext Parameters
   3. JNDI
3. `@PropertySource`
4. SpringBoot
   1. application.properties, xml, yml

```
Environment.getProperty("property.name")
```

* property.name
* property_name
* PROPERTY.NAME
* PROPERTY_NAME

우선순위 1 -> 4로 갈수록 높음