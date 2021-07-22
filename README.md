# BootJpaVue

__소개__

SpringBoot와 jpa, vue.js를 이용하여 로그인과 관련 기능을 구현하였습니다.(no security) 
개인적으로 진행한 기능으로써 많이 부족하지만 좋은 공부를 할 수 있는 시간이었고, 완성도 있는 구현을 위해 계속해서 노력하겠습니다 :)

__build절차__

Vue 프로젝트의 빌드 출력물을 SpringBoot의 static 폴더에 저장함으로써 웹 페이지가 로드됩니다. 
(Vue 프로젝트 수정시, 빌드 후) SpringBoot 실행을 합니다. 
http://localhost:8081로 접속함으로써 SpringBoot는 Static폴더 내 Vue 출력물을 실행합니다. 

 
__의존성__
+ Spring Data JPA
+ MariaDB Driver 
+ Spring Web 
+ Lombok 

```
npm "7.17.0"
node.js "v14.17.0"
java "11.0.11"
axios "0.21.1"
```

__yml 설정__
```
server:
  port: 8081
  servlet:
    context-path: /
    encoding:
      charset: utf-8
      enabled: true
    
spring:
  mvc:
    view:
      prefix: vue/src/
      suffix: .vue
      
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    url: jdbc:mariadb://localhost:3307/Autocrypt?serverTimezone=Asia/Seoul
    username: cos
    password: cos1234
    
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: update        #만약 update가 아닌 create라면 재실행 할 때마다 데이터가 리셋됨. update는 유지됨
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    show-sql: true
      
  servlet:
    multipart:
      enabled: true
      max-file-size: 2MB

file:
  path: C:/workspace/springbootwork/upload/
```
