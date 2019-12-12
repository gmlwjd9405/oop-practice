### racingcar2
- 간단한 자동차 경주 게임 구현하기

#### Step1 [기능 요구사항](https://github.com/gmlwjd9405/oop-practice/tree/master/src/main/java/camp/nextstep/edu/racingcar2/docs/step1.md)
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

#### Step2 [기능 요구사항](https://github.com/gmlwjd9405/oop-practice/tree/master/src/main/java/camp/nextstep/edu/racingcar2/docs/step2.md)
- 각 자동차에 이름을 부여할 수 있다. 
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 
    - 우승자는 한 명 이상일 수 있다.

#### 프로그래밍 요구사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView 와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - [참고문서 1](https://google.github.io/styleguide/javaguide.html) 또는 [참고문서 2](https://myeonguni.tistory.com/1596)
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else 를 사용하지 않아도 된다.
    - switch/case 도 허용하지 않는다.
 - indent(인덴트, 들여쓰기) depth 를 2를 넘지 않도록 구현한다. 
     - 1까지만 허용한다.
     - e.g. while 문 안에 if 문이 있으면 들여쓰기는 2이다.
     - 힌트: indent(인덴트, 들여쓰기) depth 를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
 - 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
 - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
    
---

### :house: [Go Home](https://github.com/gmlwjd9405/oop-practice)
