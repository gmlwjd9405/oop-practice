- 일급 컬렉션 이란
    - Collection 을 Wrapping 하면서, 그 외 다른 멤버 변수가 없는 상태를 말한다.
    - [일급 컬렉션 (First Class Collection)의 소개와 써야할 이유](https://jojoldu.tistory.com/412)
    
- 테스트하기 좋은 코드
    - 순수 함수로 구현한다.
        1. 불확실성이 없어야 한다.
            - e.g. 랜덤 수, 임의 시간, 전역 변수, DB의 특정 레코드, http의 get 방식
        2. side effect를 없애야 한다.
            - e.g. 전역 변수, 로컬 머신에 존재하는 파일 내용(e.g. Scanner, System.out.println), DB의 특정 레코드를 수정하는 작업, http의 post 방식 
    - void 보다는 반환 값이 존재하는 함수로 구현하는 것이 좋다.
        - 그래야 테스트 코드를 통해 값을 확인할 수 있기 때문이다.
    - 테스트 하기 위운 코드와 테스트 하기 어려운 코드로 메서드를 최대한 분리해야 한다.
    - [https://hyeooona825.tistory.com/68?category=790626](https://hyeooona825.tistory.com/68?category=790626)
    
- `public String[] split(String regex)` 할 때 주의 사항
    - `@param regex`(the delimiting regular expression) 으로 자바 정규식 특수문자를 사용하는 경우 주의해야 한다.
    - 일반적인 특수문자 (자바 정규식 특수문자가 아닌 경우)
        - 종류: ; : & @ # % 등 
        ```java
        @Test
        void test() {
            assertThat("1;2;3".split(";")).isEqualTo(new java.lang.String[]{"1", "2", "3"});
            assertThat("1;2;3".split("\\;")).isEqualTo(new java.lang.String[]{"1", "2", "3"}); 
        }
        ```
    - 자바 정규식 특수문자(Java Regex Meta Char) 의 종류 
        - 종류: ( [ { \ ^ - = $ ! | ] } ) ? * + .
        1. '=' '-' '!' ']' '}' 
            - 정규식이 아닌 문자와 동일하게 동작한다. 
            ```java
            @Test
            void test() {
                // Success  
                assertThat("1=2=3".split("=")).isEqualTo(new java.lang.String[]{"1", "2", "3"});
                // Success: 문자를 escape 처리 
                assertThat("1=2=3".split("\\=")).isEqualTo(new java.lang.String[]{"1", "2", "3"}); 
            }
            ```
        2. '.' 
            - 의미: 임의의 한 문자 
            - 모든 문자를 token 으로 사용한다는 것을 의미하므로 split 했을 때 빈 String 배열을 반환한다.
            ```java
            @Test
            void test() {
                // Fail: 빈 String 배열을 반환 
                assertThat("1.2.3".split(".")).isEqualTo(new java.lang.String[]{}); 
                // Success: 문자를 escape 처리 
                assertThat("1.2.3".split("\\.")).isEqualTo(new java.lang.String[]{"1", "2", "3"}); 
            }
            ```
        3. '|' 
            - 의미: 패턴에 대한 OR 연산 
            - | 를 delimiter 로 인식하지 못하기 때문에 ""를 delimiter 로 사용하는 것과 동일하게 동작한다.
            ```java
            @Test
            void test() {
                // Fail: 모든 문자를 split 
                assertThat("1|2|3".split("|")).isEqualTo(new java.lang.String[]{"1", "|", "2", "|", "3"});
                assertThat("1|2|3".split("")).isEqualTo(new java.lang.String[]{"1", "|", "2", "|", "3"}); // 위와 동일한 결과 
                // Success: 문자를 escape 처리 
                assertThat("1|2|3".split("\\|")).isEqualTo(new java.lang.String[]{"1", "2", "3"}); 
            }
            ```
        4. '^' '$' 
            - 의미: 문자의 시작과 끝
            - 문자열을 split 하지 못하기 때문에 입력한 그대로의 문자열을 반환한다.
            ```java
            @Test
            void test() {
                // Fail: 문자열 그대로 반환 
                assertThat("1^2^3".split("^")).isEqualTo(new java.lang.String[]{"1^2^3"}); 
                assertThat("1$2$3".split("$")).isEqualTo(new java.lang.String[]{"1$2$3"}); 
                // Success: 문자를 escape 처리 
                assertThat("1^2^3".split("\\^")).isEqualTo(new java.lang.String[]{"1", "2", "3"}); 
                assertThat("1$2$3".split("\\$")).isEqualTo(new java.lang.String[]{"1", "2", "3"}); 
                         }
            ```
        5. '*' '+' '(' '[' '{' '\' ')' '?'
            - 각각의 문자가 모두 정규식에서 의미를 갖기 때문에 delimiter 로 사용할 수 없다.
            - `java.util.regex.PatternSyntaxException: Dangling meta character '*'` 와 같은 Compile Error 가 발생한다. 
            ```java
            @Test
            void test() {
                // Fail: 컴파일 에러 
                // assertThat("1*2*3".split("*")).isEqualTo(new java.lang.String[]{"1", "2", "3"});
                // Success: 문자를 escape 처리 
                assertThat("1*2*3".split("\\*")).isEqualTo(new java.lang.String[]{"1", "2", "3"});
            }
            ```
    - 해결 방법
        - 자바 정규식 특수문자(Java Regex Meta Char)을 split 의 구분자(delimiter)로 사용하는 경우, 앞에 double back-slashes 를 붙여 해당 문자를 escape 처리해야 한다. 
        - 또 다른 해결 방법으로는 `StringTokenizer` 를 사용하는 것이다.
            - [](https://m.blog.naver.com/pgh7092/221080752099)
            - [](https://hunit.tistory.com/166)
