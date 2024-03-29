### calculator
- 문자열 사칙 연산 계산기 구현하기 

#### 기능 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 
    - 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

#### 프로그래밍 요구사항
- 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
- 규칙 2: else 예약어를 쓰지 않는다.

#### 힌트
- 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
    - 덧셈
    - 뺄셈
    - 곱셈
    - 나눗셈
    - 입력 값이 null 이거나 빈 공백 문자일 경우 에러 처리 (IllegalArgumentException)
    - 사칙연산 기호가 아닌 경우 에러 처리 (IllegalArgumentException)
    - 등등...
- 값을 입력 받는 API 는 Scanner 를 이용한다.
    - Scanner scanner = new Scanner(System.in);
    - String value = scanner.nextLine();
    - int number = scanner.nextInt();
- 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메서드를 활용한다.
- 반복적인 패턴을 찾아 반복문으로 구현한다.

---

### :house: [Go Home](https://github.com/gmlwjd9405/oop-practice)
