(작성 중)

### REST API는 뭘까요? RESTful한 설계는 무엇일까요?
웹 서비스를 구축할 때 REST(Representational State Transfer) 아키텍처 스타일을 자주 접하게 된다. REST는 웹 서비스의 핵심으로, 자원(Resource)을 중심으로 설계되며,
이 자원에 대해 Http 메서드를 활용한 CRUD(Create, Read, Update, Delete) 연산을 수행한다.

직렬화:객체의 상태를 바이트 스트림으로 변환하는 과정
<br> 역직렬화를 통해 다시 원래의 객체 상태로 복원 가능
<br> @RestController 어노테이션을 사용한 클래스에서는 메서드가 반환하는 객체가 자동으로 JSON 으로 직렬화되어 HTTP 응답에 포함된다.
<br> @RequestBody 어노테이션을 사용하면, HTTP 요청의 JSON 본문이 지정된 자바 타입의 객체로 자동으로 역직렬화된다.

### @RequestBody와 @ModelAttribute 차이
@ModelAttribute는 클라이언트가 전달하는 multipart/form-data 형태의 HTTP BODY를 Java Object로 맵핑해주는 역할을 한다. HTTP Body 데이터 혹은 HTTP 파라미터를 주입하는데, 이때 생성자나 Setter로 주입하기 때문에 Setter혹은 생성자가 있어야 한다.
<br> @RequestBody는 클라이언트가 요청하는 Json(application/json) 형태의 HTTP Body를 Java Object로 변환시키는 역할을 한다. @RequestBody로 받은 데이터는 Spring의 MessageConverter 중 하나인 MappingJackson2HttpMessageConverte를 통해 Java Object 객체로 변환된다.

API는 무엇이고 왜 사용할까요? 또, API를 문서화 하는 방법은 무엇이 있을까요?
API란 무엇인가요?
API 명세서란 무엇인가요?
API를 명세하기 위해 어떤 도구를 사용할 수 있나요?
REST API는 뭘까요? RESTful한 설계는 무엇일까요?
객체의 직렬화와 역직렬화는 무엇이고 @RequestBody과 @ModelAttribute의 값 매핑은 어떻게 이뤄지나요?
Controller의 메소드 내 아무런 어노테이션이 없을 때 스프링은 이 값들을 어떻게 처리하나요?

스프링에서 객체의 직렬화와 역직렬화는 어떻게 이뤄질까요?

ObjectMapper의 작동방식
@RequestBody와 @ModelAttribute는 어떤 차이가 있을까요?
Spring Framework의 ResponseEntity는 무엇이고 어떻게 활용할 수 있을까요?
요청과 응답이란 무엇일까요?
응답에는 무슨 값이 담길 수 있을까요?
왜 ResponseEntity를 사용하면 좋을까요?
