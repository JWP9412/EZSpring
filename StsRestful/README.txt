[StsRestful]

(RESTful)
REST(Representational State Transfer)는 월드 와이드 웹과 같은 분산 하이퍼미디어 시스템을 위한 
소프트웨어 아키텍처의 한 형식이다. 이 용어는 로이 필딩(Roy Fielding)의 2000년 박사학위 논문에서 소개되었다. 
필딩은 HTTP의 주요 저자 중 한 사람이다. 이 개념은 네트워킹 문화에 널리 퍼졌다.

엄격한 의미로 REST는 네트워크 아키텍처 원리의 모음이다. 여기서 '네트워크 아키텍처 원리'란 자원을 정의하고 
자원에 대한 주소를 지정하는 방법 전반을 일컫는다. 간단한 의미로는, 웹 상의 자료를 HTTP위에서 
SOAP이나 쿠키를 통한 세션 트랙킹 같은 별도의 전송 계층 없이 전송하기 위한 아주 간단한 인터페이스를 말한다.



(JSON)
JSON(제이슨[1], JavaScript Object Notation)은 
속성-값 쌍( attribute–value pairs and array data types (or any other serializable value)) 또는 
"키-값 쌍"으로 이루어진 데이터 오브젝트를 전달하기 위해 인간이 읽을 수 있는 텍스트를 사용하는 개방형 표준 포맷이다. 
비동기 브라우저/서버 통신 (AJAX)을 위해, 넓게는 XML(AJAX가 사용)을 대체하는 주요 데이터 포맷이다. 
특히, 인터넷에서 자료를 주고 받을 때 그 자료를 표현하는 방법으로 알려져 있다. 자료의 종류에 큰 제한은 없으며, 
특히 컴퓨터 프로그램의 변수값을 표현하는 데 적합하다.

[예제]
 {
    "이름": "홍길동",
    "나이": 25,
    "성별": "여",
    "주소": "서울특별시 양천구 목동",
    "특기": ["농구", "도술"],
    "가족관계": {"#": 2, "아버지": "홍판서", "어머니": "춘섬"},
    "회사": "경기 수원시 팔달구 우만동"
 }
 
 (AJAX)
- 표현 정보를 위한 HTML (또는 XHTML) 과 CSS
- 동적인 화면 출력 및 표시 정보와의 상호작용을 위한 DOM, 자바스크립트
- 웹 서버와 비동기적으로 데이터를 교환하고 조작하기 위한 XML, XSLT, XMLHttpRequest 
	(Ajax 애플리케이션은 XML/XSLT 대신 미리 정의된 HTML이나 일반 텍스트, JSON, JSON-RPC를 이용할 수 있다).

(REST에서 URI)
HTTP 메소드 : 
	- GET 	 : 조회(Select)
	- POST 	 : 추가(Create)
	- PUT 	 : 수정(Update)
	- DELETE : 삭제(Delete)