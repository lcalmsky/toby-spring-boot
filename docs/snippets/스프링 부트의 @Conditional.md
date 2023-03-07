* `@Profile`도 `@Conditional` 애너테이션
    ```
    @Conditional(ProfileConditionl.class)
    public @interface Profile {
        
    }
    ```
* Class Conditions
  * `@ConditionalOnClass`
  * `@ConditionalOnMissingClass`
  * 지정한 클래스의 프로젝트 내 존재 확인하여 포함 여부 결정
  * 주로 클래스 레벨에서 사용하지만 @Bean 메서드에도 적용 가능
  * 클래스 레벨 검증 없이 적용하면 @Configuration 클래스가 빈으로 등록되기 때문에 클래스 레벨 사용을 우선시 해야 함
* Bean Conditions
  * `@ConditionalOnBean`
  * `@ConditionalOnMissingBean`
  * 빈의 존재 여부를 기준으로 포함 여부 결정
  * 빈의 타입 또는 이름 지정 가능
  * 지정된 빈 정보가 없으면 메서드 리턴 타입 기준으로 빈 존재 여부 체크
  * 커스텀 빈 구성정보가 자동 구성 정보 처리보다 우선하기 때문에 이 관계에 적용하는 것이 안전
* Property Conditions
  * `@ConditionalOnProperty`
  * 환경 프로퍼티 사용
  * 프로퍼티가 존재하고 값이 false가 아니면 포함 대상
  * 특정 값을 가진 경우를 확인하거나 존재하지 않을 때 조건을 만족하게 할 수도 있음
* Resource Conditions
  * `@ConditionalOnResource`
  * 지정된 리소스(파일)의 존재 확인
* Web Application Conditions
  * `@ConditionalOnWebApplication`
  * `@ConditionalOnNotWebApplication`
  * 웹 애플리케이션 여부 확인
* SpEL Expression Conditions
  * `@ConditionalOnExpression`
  * 스프링 표현식의 처리 결과를 기준으로 판단