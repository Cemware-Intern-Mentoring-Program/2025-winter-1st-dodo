(작성 중)
### API는 무엇이고 왜 사용할까요? 또, API를 문서화 하는 방법은 무엇이 있을까요?
#### API란 무엇인가요?
응용 프로그램에서 사용할 수 있도록, 운영 체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있게 만든 인터페이스.
<br> (개발 관점) 개발자가 프로그램을 만드는데 필요한 어떤 기능을 직접 구현하지 않고 API 제공자들이 제공하는 데이터와 모듈 등을 갖다쓸 수 있게 해주는 게 API와 API 문서이다.

#### API 명세서란 무엇인가요?
API를 설명하는 문서.
<br> 다음과 같은 항목들이 포함된다.
- API 개요(용도 및 유형)
- 엔드포인트
- 매개변수와 요청 바디
- 응답 설명
- 예제
- 에러 처리 설명
- 인증과 권한 부여
- 자원 모델 설명
#### API를 명세하기 위해 어떤 도구를 사용할 수 있나요?
Swagger, Springdoc, Postman 등



### REST API는 뭘까요? RESTful한 설계는 무엇일까요?
REST API: REST의 원리를 따르는 API / RESTful: REST의 원리를 따르는 시스템
웹 서비스를 구축할 때 REST(Representational State Transfer) 아키텍처 스타일을 자주 접하게 된다. **REST**는 웹 서비스의 핵심으로, 자원(Resource)을 중심으로 설계되며,
이 자원에 대해 Http 메서드를 활용한 CRUD(Create, Read, Update, Delete) 연산을 수행한다.

### 객체의 직렬화와 역직렬화는 무엇이고 @RequestBody과 @ModelAttribute의 값 매핑은 어떻게 이뤄지나요?
직렬화:객체의 상태를 JSON 형태의 문자으로 변환하는 과정
<br> 역직렬화를 통해 다시 원래의 객체 상태로 복원 가능

#### Controller의 메소드 내 아무런 어노테이션이 없을 때 스프링은 이 값들을 어떻게 처리하나요?
요청 처리 불가: @GetMapping, @PostMapping, @RequestMapping 등 HTTP 요청을 컨트롤러 메소드에 매핑해주는 어노테이션이 없으면, 해당 메소드는 특정 URL 경로와 연결되지 않는다.


#### 스프링에서 객체의 직렬화와 역직렬화는 어떻게 이뤄질까요?
Spring에서는 jackson 모듈의 ObjectMapper라는 클래스가 직렬화를 처리
##### ObjectMapper의 작동방식
objectMapper의 writeValue() 와 writeValueAsString() 메소드를 사용하여 직렬화 처리
<br> 두 메소드는 자바 객체를 각각 파일(.JSON)과 문자열({"id": 1, ...})로 변환
<br> 이때 직렬화 하고자 하는 클래스에 Getter가 존재 해야함 →
Jackson 라이브러리는 직렬화할 때, Getter의 prefix를 제거하고 소문자로 만들어서 식별하기 때문에 가져올 Getter가 없다면 오류를 내보내게 된다.

##### @RequestBody와 @ModelAttribute 차이
@ModelAttribute는 클라이언트가 전달하는 multipart/form-data 형태의 HTTP BODY를 Java Object로 맵핑해주는 역할을 한다. HTTP Body 데이터 혹은 HTTP 파라미터를 주입하는데, 이때 생성자나 Setter로 주입하기 때문에 Setter혹은 생성자가 있어야 한다.
<br> @RequestBody는 클라이언트가 요청하는 Json(application/json) 형태의 HTTP Body를 Java Object로 변환시키는 역할을 한다. @RequestBody로 받은 데이터는 Spring의 MessageConverter 중 하나인 MappingJackson2HttpMessageConverte를 통해 Java Object 객체로 변환된다.


### Spring Framework의 ResponseEntity는 무엇이고 어떻게 활용할 수 있을까요?
스프링 프레임워크가 제공하는 클래스로, HttpEntity 클래스를 상속받음 → 사용자의 Http Request에 대한 응답 데이터를 반환하고자 할 때 사용
<br> HTTP 상태 코드, 헤더, 바디(본문)를 함께 제어할 수 있어 유연하고 명확한 응답 관리가 가능

#### 요청과 응답이란 무엇일까요?
요청: 웹 서비스 등에서 클라리언트가 서버에게 정보를 요구
응답: 클라이언트 요청에 응하는 정보를 담아 데이터를 보내는 것

#### 응답에는 무슨 값이 담길 수 있을까요?
-HTTP 상태코드
- 헤더
- 바디(JSON)

왜 ResponseEntity를 사용하면 좋을까요?
(위에서 기술)
