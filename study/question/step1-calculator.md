- 빈 문자열 또는 null 값 입력에 대한 검증 방법 
    - StringUtils 이용
        - `StringUtils.isEmpty(text)`
        ```java
        public static boolean isEmpty(@Nullable Object str) {
            return (str == null || "".equals(str));
        }
        ```
    - String 객체
        - `text == null || text.isEmpty()`
        ```java
        public boolean isEmpty() {
                return value.length == 0;
            }
        ```
    - [Objects 이용](https://multifrontgarden.tistory.com/205)
        - `Objects.isNull(text)`
        ```java
        public static boolean isNull(Object obj) {
            return obj == null;
        }
        ```
    
- Stream 을 이용한 int 배열의 합 구하는 방법  
    - [참고](https://www.baeldung.com/java-stream-sum)
    - `Stream#reduce(BinaryOperator)`
    ```java
    numbers.stream()
      .map(Number::toInt)
      .reduce(0, Integer::sum);
    ```
    - `Stream#collect()`
    ```java
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
    integers.stream()
       .collect(Collectors.summingInt(Integer::intValue));
    ```
    - `IntStream.sum()`
    ```java
    numbers.stream()
      .mapToInt(Number::toInt)
      .sum();
    ```
    
- 메서드 레퍼런스 (method reference) 사용 예제
    - lambda 식을 사용하면 method reference 보다 참조가 한 번 더 일어난다.
    - [참고](https://softwareengineering.stackexchange.com/questions/277473/is-there-a-performance-benefit-to-using-the-method-reference-syntax-instead-of-l)
    - e.g.
    ```java
    .map(number -> new PositiveNumber(Integer.parseInt(number)))
    ```
    ```java
    .map(Integer::parseInt)
    .map(PositiveNumber::new)
    ```

- String.matches 와 Matcher.matches 의 차이
    - `Pattern.matches(regex, str)` 는 미리 컴파일된 정규표현식에서 작성된다.
        - 미리 `Pattern.compile(regex)` 이 매번 동일한 regex 로 생성된다면 미리 만들어두고 재활용하면 좋다.
    - `String.matches` 는 정규표현식이 실행될 때마다 다시 컴파일해야 하므로 낭비가 된다.

- private 생성자를 사용하면 클래스의 인스턴스화를 막을 수 있다.

- 인스턴스를 미리 만들어 놓거나 새로 생성한 인스턴스를 캐싱하여 재활용하면 불필요한 객체 생성을 피할 수 있다.

- `WeakHashMap` 이란 
    - [Guide to WeakHashMap in Java](https://www.baeldung.com/java-weakhashmap)
    - Key 에 해당하는 객체가 더 이상 사용되지 않는다(null)고 판단되면 제거한다. 

- null object 디자인 패턴
    - null 대신 사용할 클래스를 구현한다.
    - 해당 클래스는 상위 타입을 상속받으며 아무 기능도 수행하지 않는다.
    - null 을 return 하는 대신 해당 클래스의 객체를 리턴한다.
    - 장점: null 검사 코드가 최소화되므로 간단해진다.
    - 단점: 간단한 프로젝트에서는 복잡한 설계일 수 있다.

- 매직 넘버
    - 상수(static final)로 치환해서 사용하는 것이 좋다.
    - const 관리 방법
        - 가능하면 관련된 클래스에 상수를 구현한다.
        - https://www.slipp.net/questions/174 참고 
    
- `Arrays#asList(Object[])`는 `java.util.ArrayList`가 아닌 Arrays 의 내부 클래스인 ArrayList(`java.util.Arrays.ArrayList`)를 돌려준다.
    - 이 클래스는 set(), get(), contains() 매서드를 가지고 있지만 원소를 추가하는 메서드는 가지고 있지 않기 때문에 사이즈를 바꿀 수 없다. 
    - `java.util.ArrayList`을 받기 위해서는 아래와 같이 변환하자
        ```java
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));
        ```
    - [Arrays#asList(Object[]) 사용 시 주의할 점](https://bestalign.github.io/2015/08/31/top-10-mistakes-java-developers-make-1/)
    
- Stream 사용 이유
    - 성능 이슈가 큰 부분이 아니라면 스트림 사용이 가독성을 높여주는 장점이 있어 자주 활용하는 편이지만, 
    - for 문을 사용하는 경우와 가독성에 큰 차이가 안나고 위와 같이 스트림 사용을 위해 불필요한 객체를 생성해야 한다면 재고해봐야 한다.
    
- 정적 팩토리 메서드란
    - 보편적인 이름 설정 
        - e.g. toInt, of, valueOf, newInstance 등 
        
- Exception 처리 
    - [가능하면 표준 예외를 재사용하라.](https://jaehun2841.github.io/2019/03/10/effective-java-item72/#%EC%84%9C%EB%A1%A0)
        - 표준 예외를 사용하면 발생한 예외만 보고도 어떤 문제가 생긴건지 빠르게 대응 할 수 있지만 
        - RuntimeException 은(특히 아무 메시지도 없다면) 예외 발생시 stacktrace 을 확인하며 문제의 원인을 찾아봐야 하기 때문에 
        - 가능하면 표준 예외를 재사용하는 것이 좋다.
    - 예외 상황을 식별할 수 있는 로그를 남긴다.
    - 다른 예외를 catch 로 잡는 상황인 경우 아래처럼 exception changing 을 통해 예외를 연결해 정보를 추가할 수 있다.
        - `throw new RuntimeException("Invalid value", anotherException)`
    - RuntimeException 이 아닌 CustomException 을 만들어 사용할 수 있다.
    ```java
    class CustomException extends RuntimeException {
        public CustomException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    // e.g.
    throw new CustomException("Input negative value");
    ```
    - [Exception 처리 참고](https://www.slipp.net/questions/350) 

- equals 와 hashCode 오버라이딩

- Matcher 의 find() 와 matches() 의 차이
    - `find()`
        - 대상 문자열에서 해당 패턴을 검색하여 일치하는 패턴이 일부라도 존재하면 return true
    - `matches()`
        - 대상 문자열 전체가 해당 패턴과 일치하면 return true
        - 문자열의 처음부터 끝까지 정규식을 만족해야 한다.
    - debugging 에서 find() 값이 false 가 나오는 원인 찾기!!
        - 클래스 필드로 선언한 pattern 이용 시 return false
        - 내부 필드로 선언한 pattern 이용 시 return true
    - [Difference between matches() and find() in Java Regex](https://www.tutorialspoint.com/Difference-between-matches-and-find-in-Java-Regex)
    - [Matcher 클래스 메서드](https://enterkey.tistory.com/353)
    
- parameter 객체의 private field 에 대한 접근 
    - 동일한 클래스가 인자인 경우 private field 에 접근할 수 있다.
    ```java
    public class Number {
        private int value;
        public int toInt() {
            return this.value;
        }
        public Number plus(final Number number) {
            return new Number(this.value + number.value); // parameter 객체의 private field 값 사용
            // return new Number(this.value + number.toInt()); 
        }
    }
    ```

- Functional Interface 란
    - 단 하나의 추상 메소드(Single Abstract Method, SAM)를 가지는 인터페이스이다.
    - `@FunctionalInterface` annotation 을 안붙여도 되지만, 붙이는 것을 권장한다.
    - [Java8에서 제공하는 Functional Interface API](https://multifrontgarden.tistory.com/125)
    - 이런 인터페이스들은 모두 람다식을 이용해서 익명 구현 객체로 표현이 가능하다.
    - e.g. Predicate interface 
    ```java
    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }
    private static void example() {
        final Predicate<Integer> isPositive = i -> i > 0;
        final List<Integer> numbers = Arrays.asList(-1, 0, 1);
        for (final Integer num : numbers) {
          if (isPositive.test(num)) {
            System.out.println(num);  // 1
          }
        }
    }
    ```

- 참고
    - [좋은 객체의 7가지 덕목](https://codingnuri.com/seven-virtues-of-good-object/)
    - [styleguide](http://cr.openjdk.java.net/~alundblad/styleguide/index-v6.html#toc-modifiers)
    - [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html#s5.2.4-constant-names)
