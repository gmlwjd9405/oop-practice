## Junit 5 사용법 2

### Maven Dependencies
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.4.2</version>
    <scope>test</scope>
</dependency>
```
```xml
testCompile("org.junit.jupiter:junit-jupiter-params:5.4.2")
```

---

### Parameterized Tests
- **@ParameterizedTest**
    - 이 annotation 을 추가하는 것을 제외하고는 다른 테스트와 동일하다.
- e.g.
    ```java
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(Numbers.isOdd(number));
    }
    ```
    - 6번의 isOdd 메서드를 실행한다.
    - *a source of arguments*: an int array
    - *a way to access them*: the number parameter
    
#### Simple Value
- **@ValueSource**
    - 해당 annotation 에 지정한 배열을 파라미터 값으로 순서대로 넘겨준다.
    - test method 실행 당 **하나의 인수(argument)** 만을 전달할 때 사용할 수 있다.
    - 리터럴 값의 배열을 테스트 메서드에 전달한다.
    - c.f. *literal values* 종류
        - short, byte, int, long, float, double, char, java.lang.String, java.lang.Class 
- e.g.
    ```java
    public class Strings {
        public static boolean isBlank(String input) {
            return input == null || input.trim().isEmpty();
        }
    }
    ```
    ```java
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(Strings.isBlank(input));
    }
    ```
    
#### Null and Empty Values
- **@NullSource**
    - primitive data 는 널(null) 값을 허용할 수 없으므로 primitive 인수에 `@NullSource` 를 사용할 수 없다.
- **@EmptySource**
    - 이 annotation 을 사용하여 빈 값을 인수에 전달할 수 있다. 
    - String 인수의 경우 ""(empty string), Collection types 과 Arrays 에도 빈 값을 넣을 수 있다. 
- **@NullAndEmptySource**
    - null 값과 empty value 모두 전달하기 위해 해당 annotation 을 사용할 수 있다. 
    - `@EmptySource`와 마찬가지로 문자열, 컬렉션 및 배열에서 동작한다.
    - 몇 가지 빈 문자열 변형을 parameterized test 로 전달하기 위해 **@ValueSource, @NullSource 및 @EmptySource**를 함께 결합할 수 있다.
    ```java
    @ParameterizedTest
    @NullAndEmptySource
    void isBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
        assertTrue(Strings.isBlank(input));
    }
    ```
    
#### Enum
- **@EnumSource**
    - enumeration(열겨형) 값의 배열을 테스트 메서드에 전달한다.
    - test method 실행 당 **하나의 인수(argument)** 만을 전달할 때 사용할 수 있다.
    - *names* 속성
        - 리터럴 문자열 외에도 정규 표현식(regular expression)을 *names* 속성에 전달할 수 있다.
        - 기본적으로 *names* 속성은 일치하는 enum 값을 가진다. 
        - mode 속성을 **EXCLUDE** 로 설정하면 제외하는 enum 값을 가질 수 있다. 
- e.g. 모든 월(Month enum)을 확인하여 월 숫자가 1과 12 사이에 있는지 확인하는 경우 
    ```java
    @ParameterizedTest
    @EnumSource(Month.class) // passing all 12 months
    void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
        int monthNumber = month.getValue();
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }
    ```
- e.g. 월의 '이름' 속성을 사용하여 특정 개월은 제외하는 경우 (4, 6, 9, 11월의 기간이 30일인지 확인)
    ```java
    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void someMonths_Are30DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }
    ```
- e.g. 2, 4, 6, 9, 11월을 제외한 월의 기간이 31일인지 확인하는 경우 
    ```java
    @ParameterizedTest
    @EnumSource(
      value = Month.class,
      names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"},
      mode = EnumSource.Mode.EXCLUDE)
    void exceptFourMonths_OthersAre31DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(31, month.length(isALeapYear));
    }
    ```

#### Method
- **@MethodSource**
    - 위의 argument sources 들은 복잡한 object 를 사용하여 전달하는 것이 어렵거나 불가능하다.
    - 보다 복잡한 인수를 제공하는 방법 중 한 가지는 method 를 argument source 로 사용하는 것이다.
    - 즉, `@MethodSource`는 test method 실행 당 **복잡한 인수(argument)** 를 전달할 때 사용하는 방법이다.
        - test method 호출 당 하나의 인수(argument)를 전달하는 경우는 `<Arguments>` 추상화를 사용하지 않아도 된다. 
    - `@MethodSource` 에 설정하는 이름은 존재하는 메서드 이름이어야 한다.
        - 이름은 설정하지 않으면 JUnit 은 test method 와 이름이 같은 source method 를 찾는다.
    - argument source method 조건
        - `Stream<Arguments>` (혹은 Iterable, Iterator) 또는 `List 와 같은 컬렉션`과 유사한 interface 를 반환할 수 있다.
        - 클래스 단위 생명 주기가 아닌 경우, static method 여야 한다.
    - `@MethodSource`를 이용하면 다른 테스트 클래스 간에 인수를 공유하는 것이 유용하다.
        - 이 경우 정규화된 이름 (*FQN#methodName format*)으로 현재 클래스 외부의 source method 를 참조할 수 있다.
- e.g. 기본 사용 예제 - isBlank method 테스트 
    ```java
    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank") // needs to match an existing method.
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, Strings.isBlank(input));
    }
    ```
    ```java
    // a static method that returns a Stream of Arguments
    private static Stream<Arguments> provideStringsForIsBlank() { // argument source method
        return Stream.of(
          Arguments.of(null, true),
          Arguments.of("", true),
          Arguments.of("  ", true),
          Arguments.of("not blank", false)
        );
    }
    ```
- e.g. 외부 source method 참조 예제 
    ```java
    class StringsUnitTest {
        @ParameterizedTest
        @MethodSource("com.baeldung.parameterized.StringParams#blankStrings") // 클래스 외부의 source method
        void isBlank_ShouldReturnTrueForNullOrBlankStringsExternalSource(String input) {
            assertTrue(Strings.isBlank(input));
        }
    }
    ``` 
    ```java
    public class StringParams {
        static Stream<String> blankStrings() {
            return Stream.of(null, "", "  ");
        }
    }
    ```
    
#### CSV Literals
- **@CsvSource**
    - `@CsvSource`는 쉼표로 구분된 값의 배열을 허용하며, 각 배열 항목은 CSV 파일의 행에 해당한다.
        - input value 와 expected value 를 test method 에 전달
        - input value 로 실제 결과 계산
        - 실제 값을 expected value 으로 가정
- e.g. 문자열을 대문자로 변경
    ```java
    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }
    ```
- e.g. 매번 하나의 배열 항목을 가져와서 delimiter (기본: ,) 로 나누고 test method 에 매개변수로 전달한다.
    ```java
    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        String actualValue = input.toLowerCase();
        assertEquals(expected, actualValue);
    }
    ```
    
--- 

# References
- [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

