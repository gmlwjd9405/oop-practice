### racingcar2 - Step1
- 간단한 자동차 경주 게임 구현하기

#### 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- e.g. **실행 결과**
```
자동차 대수는 몇 대 인가요?
3
시도할 횟수는 몇 회 인가요?
5

실행 결과
-
-
-

--
-
--

---
--
---

----
---
----

----
----
-----
```

#### 프로그래밍 요구사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView 와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - [참고문서 1](https://google.github.io/styleguide/javaguide.html) 또는 [참고문서 2](https://myeonguni.tistory.com/1596)
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else 를 사용하지 않아도 된다.
    - switch/case 도 허용하지 않는다.

#### 힌트
- 값을 입력 받는 API 는 Scanner 를 이용한다.
    - `Scanner scanner = new Scanner(System.in);`
    - `String value = scanner.nextLine();`
    - `int number = scanner.nextInt();`
- 랜덤 값은 자바 `java.util.Random` 클래스의 nextInt(10) 메소드를 활용한다.
- 기본 뼈대 클래스는 아래의 코드로부터 시작할 수 있다. 
    - 배열을 사용하는 것이 싫다면 ArrayList 를 사용하는 것도 좋은 방법이다.
    ```java
    public class RacingGame {
        private int time;
        private int[] carPositions = {0, 0, 0};
        public int[] move() {
          // TODO 구현
        }
    }
    ```

---

### :house: [Go Home](https://github.com/gmlwjd9405/oop-practice)
