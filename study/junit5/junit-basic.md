- `assertSame()` 과 `assertSame()` 의 차이 
    - `assertEqual`: 두 값이 같은지 비교하는 단정문
    - `assertSame`: 두 객체가 정말 동일한 객체인지 주소값으로 비교하는 단정문
    - 두 메서드보다 assertThat 사용을 권장한다. (좀 더 문맥적인 흐름을 만들기 위해)
        - `assertThat(100).isSameAs(100);`
        - `assertThat(10000).isEqualTo(10000);`
        
- `assertSame()` 에서 int 사용 시 범위에 대한 주의 사항 
    - e.g. `assertThat(calculator.add(text)).isSameAs(expected);`
        ```java
        assertThat(100).isSameAs(100); // true
        assertThat(10000).isSameAs(10000); // false
        ```
    - 자바에서 -128 ~ 127 사이의 값은 미리 저장된 값을 이용하기 때문에 새로운 객체를 생성하지 않고 사용하므로 위의 예제는 true 를 반환한다.
    - [https://syaku.tistory.com/344](https://syaku.tistory.com/344)
      
