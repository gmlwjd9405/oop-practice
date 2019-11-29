# oop-practice

### [step0] JUnit5 사용하기
- racingcar 의 테스트 코드를 작성한다.

### [step1] 문자열 덧셈 계산기 
#### 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다. 
    - e.g. “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6) 
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 
    - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
    - e.g. “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다. 
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 ​RuntimeException​ 예외를 throw 한다. 

---
    
### ddd-kitchenpos
#### 요구 사항
- 간단한 포스 프로그램을 구현한다.

#### 용어 사전
| 한글명 | 영문명 | 설명  |
| --- | --- | --- |
| 포스 | POS | 판매 시점 정보 관리. 판매와 관련한 데이터를 일괄적으로 관리하고, 고객정보를 수집하여 부가가치를 향상시키는 시스템이다. |

#### 모델링

