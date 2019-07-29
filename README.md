### 개발 프레임워크
1. Spring Boot 2.1.6
2. Gradle Project
3. Java Language

### 문제해결 전략
샘플로 주어진 csv를 분석해보면 내용중에 ,(comma)를 포함한 문자열이 있어 단순하게 text를 split해보니 제대로 값을 읽을 수 없었고, Line별로 Read하니 줄바뀜 문자열로 인해 역시 제대로된 값을 읽을 수 없었다. 문자열을 전부 읽어와 csv포맷을 지원하는 opencsv를 이용하여 문제를 해결하였다.

 테마별 분류, 서비스 지역은 내부적으로 또 ,(coomma)로 나뉘어 지는데 이 값들은 따로 table을 만들어 관리할 필요가 있다.
 
 지역은 고유값으로 관리되어야 하는데 예제를 참고하자면 reg + id(AUTO_INCREMENT)를 사용하면 될 것으로 보인다. 굳이 reg를 붙이지 않는다면 PK로 사용할 수 있는 정수형 수를 사용해도 되겠다.
 
 지역명과 관광 키워드를 입력받아 프로그램 코드를 출력하는 API를 위해서는 일단 프로그램에도 PK를 가지도록 table을 따로 만들어 주는 게 좋겠다. 
 가중치는 각각의 필드에서 keyword를 count하여 테마에서 찾은 수 x3, 프로그램 소개 컬럼에서 찾은 수 x2, 프로그램 상세 소개 컬럼에서 찾은 수를 합하여 가장 큰수에 해당하는 프로그램 코드를 출력하면 되겠다.


### 빌드
Gradle, Lombok을 지원하는 환경 필요

### 실행 방법
1. MySQL 또는 MariaDB Server 환경 필요.
2. 편의상 id/pw는 root/root로 설정되어 있으나 application.properties의
<code>
spring.datasource.username=root
spring.datasource.password=root
</code>
설정 변경으로 이용 가능. 
3. 아래 주소로 접속이 가능하도록 database인 ecology를 생성필요.
> spring.datasource.url=jdbc:mysql://localhost/ecology?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false&useUnicode=true&charaterEncoding=utf-8
