* 자바 코드와 스프링 빈으로 등록된 코드는 서로 다르게 동작함
* proxy object가 빈으로 등록됨
* @Configuration 애노테이션이 추가된 클래스는 Proxy를 만들어 기능을 확장해 줌
  * spring boot 3.0 이후(spring 5.2 이후)부터는 Proxy 생성 방식을 사용하지 않을 수 있게 함
  * `@Configuration(proxyBeanMethods = false)`
    * 자바 코드 방식으로 동작하도록
    * `@EnableScheduling` -> `SchedulingConfiguration`
  * Bean의 의존관계가 없거나 명확하게 구분할 수 있는 경우 proxyBeanMethods = false로 사용 