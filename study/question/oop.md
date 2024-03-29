#### 객체지향과 관련된 개념 및 내용 요약 

- 클래스가 아닌 **객체에 초점**을 맞추자
    1. 어떤 객체들이 필요한지 고민하라.
    2. 객체를 독립적인 존재가 아니라 기능을 구현하기 위해 협력하는 공동체의 일원으로 봐야 한다.

- 모듈이란
    - 크기와 상관 없이 클래스나 패키지, 라이브러리와 같이 프로그램을 구성하는 임의의 요소를 의미한다.
    - 모듈의 세 가지 목적
        1. 실행 중에 제대로 동작한다.
        2. 변경을 위해 존재한다.
        3. 코드를 읽는 사람과 의사소통한다. 
    - 모든 모듈은 제대로 실행돼야 하고, 변경이 용이해야 하며, 이해하기 쉬워야 한다.
    
- 객체지향 프로그래밍
    - 데이터와 프로세스가 동일한 모듈 내부에 위치하도록 프로그래밍하는 방식 

- 객체지향 설계란
    - 올바른 책임을 할당하면서 낮은 결합도와 높은 응집도를 가진 구조를 창조하는 활동
    - 훌륭한 설계란 
        - 합리적인 비용 안에서 변경을 수용할 수 있는 구조를 만드는 것
        - 캡슐화를 이용해 의존성을 적절히 관리함으로써 객체 사이의 결합도를 낮추는 것이다. 
    - 방법
        1. 데이터 중심의 관점에서의 설계
            - 데이터를 조작하는 데 필요한 오퍼레이션을 정의한다.
            - 객체의 상태에 초점 (객체는 독립된 데이터 덩어리)
            - 변경에 취약한 이유
                1. 본질적으로 너무 이름 시기에 데이터에 관해 결정하도록 강요한다.
                2. 협력이라는 문맥을 고려하지 않고 객체를 고립시킨 채 오퍼레이션을 결정한다.
        2. 책임 중심의 관점에서의 설계
            - 객체는 다른 객체가 요청할 수 있는 오퍼레이션을 위해 필요한 상태를 보관한다.  
            - 객체의 행동에 초점 (객체는 협력하는 공동체의 일원)
            - 두 가지 원칙
                1. 데이터보다 행동을 먼저 결정하라
                2. 협력이라는 문맥 안에서 책임을 결정하라 
    - 좋은 설계란
        - 오늘 요구하는 기능을 온전히 수행하면서 내일의 변경을 매끄럽게 수용할 수 있는 설계 
        - 높은 응집도와 낮은 결합도를 가진 모듈로 구성된 설계
        - 응집도
            - 모듈에 포함된 내부 요소들이 연관돼 있는 정도
            - 변경이 발생할 때 모듈 내부에서 발생하는 변경의 정도  
            - 응집도가 높은 클래스는 인스턴스를 생성할 때 모든 속성을 함께 초기화한다. 
            - e.g. 하나의 변경을 수용하기 위해 모듈 전체가 함께 변경된다면 응집도가 높다.
            - e.g. 하나의 변경에 대해 하나의 모듈만 변경된다면 응집도가 높다. 
        - 결합도
            - 의존성의 정도를 나타내며 다른 모듈에 대해 얼마나 많은 지식을 갖고 있는지
            - 한 모듈이 변경되기 위해서 다른 모듈의 변경을 요구하는 정도
            - e.g. 하나의 모듈을 수정할 때 수정해야 되는 모듈이 많을수록 결합도가 높다.
    - 응집도와 결합도를 고려하기 전에 먼저 캡슐화를 향상시키기 위해 노력하라. 
    
- 객체란
    - 상태와 행동을 함께 캡슐화하는 실행 단위
        - 상태: 객체가 행동하는 데 필요한 정보에 의해 결정
        - 행동: 협력 안에서 객체가 처리할 메시지로 결정
    - 객체는 자신의 데이터를 스스로 처리하는 자율적인 존재여야 한다. 
    
- 도메인이란
    - 문제를 해결하기 위해 사용자가 프로그램을 사용하는 분야를 말한다.
    - 올바른 도메인 모델이란 존재하지 않는다.
        - 실제 코드를 구현하면서 얻게 되는 통찰이 역으로 도메인에 대한 개념을 바꾸기 때문
    - 즉, 도메인 개념을 정리하는 데 너무 많은 시간을 들이지 말고 빠르게 설계와 구현을 진행하라. 
     
- 훌륭한 클래스를 설계하기 위한 핵심
    - 어떤 부분을 외부에 공개하고 어떤 부분을 감출지를 결정하는 것
        - **퍼블릭 인터페이스와 구현의 분리 원칙**
        - 불안정한 구현 세부사항을 안정적인 퍼블릭 인터페이스 뒤로 캡슐화하는 것
    - Q. 클래스의 내부와 외부를 구분해야 하는 이유?
        1. 경계의 명확성이 객체의 자율성을 보장하기 때문 
        2. 프로그래머에게 구현의 자유를 제공하기 때문
    - Q. 설계가 필요한 이유?
        - 변경을 관리하기 위해서 

- 트레이드오프
    - 항상 유연성과 가독성 사이에서 고민해야 한다.
    - 설계가 유연해질수록 코드를 이해하고 디버깅하기는 점점 더 어려워진다. 
    - 의존성의 양면성  
        - 컴파일 시간에는 부모 인스턴스에 의존하고, 실행 시에는 구체적인 자식 인스턴스에 의존한다.
    - 구현과 관련된 모든 것들이 트레이드오프의 대상이 될 수 있다. 
        
- 캡슐화와 접근 제어는 객체를 두 부분으로 나눈다.
    - 캡슐화: 데이터와 기능을 객체 내부로 함께 묶는 것
        - 변경 가능성이 높은 부분을 객체 내부로 숨기는 추상화 기법
        - 캡슐화의 목적: 변경하기 쉬운 객체를 만드는 것 
    - 접근 제어: 외부에서의 접근을 통제하는 것
    - 객체
        1. **퍼블릭 인터페이스(public interface)**: 외부에서 접근 가능 
            - 상대적으로 안정적인 부분  
        2. **구현(implementation)**: 오직 내부에서만 접근 가능
            - 변경될 가능성이 높은 부분
            
- 캡슐화 위반 예시
    - 객체 내부에 어떤 인스턴스 변수를 포함하고 있는지 노출하는 경우
        - e.g. `public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {...}`
        - e.g. `public boolean isDiscountable(int sequence) {...}`
    - 객체 내부의 구현 방법을 메서드명으로 노출하는 경우
        - e.g. `public Money calculateAmountDiscountedFee() {...}`
        - e.g. `public Money calculatePercentDiscountedFee() {...}`

- 추상화의 장점
    1. 추상화의 계층만 따로 보면 요구사항의 정책을 높은 수준에서 서술할 수 있다. (중요한 정책을 상위 수준에서 단순화)
    2. 설계가 좀 더 유연해진다.
    
- 메시지와 메서드를 구분하는 것은 매우 중요하다.
    - 이 구분으로부터 '다형성(polymorphism)'의 개념이 나온다.
        - 메서드: 수신된 메서드를 처리하기 위한 자신만의 방법
        - 메시지: 다른 객체의 (퍼블릭) 인터페이스에 공개된 행동을 수행하도록 요청하는 내용
    - "메서드를 호출한다."는 말보다 **"메시지를 전송한다."** 라고 말하는 것이 더 적절한 표현이다.
    
- 다형성(polymorphism)이란
    - 동일한 메시지를 전송하지만, 실제로 어떤 메서드가 실행될 것인지는 메시지를 수신하는 객체의 클래스가 무엇이냐에 따라 달라지는 것
        - 즉, 동일한 메시지를 수신했을 때 객체의 타입에 따라 다르게 응답할 수 있는 능력
    - 다형적인 협력에 참여하는 객체들은 (퍼블릭) 인터페이스가 동일해야 한다. 
    - 다형성은 지연 바인딩이라는 메커니즘을 통해 구현된다. (메시지와 메서드를 실행 시점에 바인딩)    
    - 다형성을 구현하는 방법은 다양하다.
        - e.g. 상속 

- 상속 
    - 외부 객체는 자식 클래스를 부모 클래스와 동일한 타입으로 간주할 수 있다.
        - 객체가 이해할 수 있는 메시지의 목록을 정의한다. 
    - 업캐스팅
        - 자식 클래스가 부모 클래스를 대신하는 것 
        - e.g. `ParentInstance instance = new ChildrenInstance();`

- 상속의 종류
    1. 구현 상속(implementation inheritance) = 서브클래싱(subclassing)
        - 순수하게 코드를 재사용하기 위한 목적으로 상속을 사용하는 것
        - 코드의 재사용을 위해서는 상속보다는 합성(composition)이 더 좋은 방법이다.
        - 코드를 재사용하기 위한 상속의 문제점
            1. 캡슐화를 위반한다. (부모 클래스의 구현이 자식 클래스에게 노출되기 때문)
            2. 설계를 유연하지 못하게 만든다. (실행 시점에 객체의 종류를 변경하는 것이 불가능하기 때문)
    2. 인터페이스 상속(interface inheritance) = 서브타이핑(subtyping) 
        - 다형적인 협력을 위해 부모 클래스와 자식 클래스가 (퍼블릭) 인터페이스를 공유할 수 있도록 상속을 이용하는 것이다.
        - 상속은 구현 상속이 아니라 (퍼블릭) 인터페이스 상속을 위해 사용해야 한다.
    - 즉, 코드를 재사용하는 경우에는 상속보다 합성을 선호하는 것이 옳지만 
    - 다형성을 위해 (퍼블릭) 인터페이스를 재사용하는 경우에는 상속과 합성을 함께 조합해서 사용할 수 밖에 없다. 

- 합성(composition)이란
    - 다른 객체의 인스턴스를 자신의 인스턴스 변수로 포함해서 재사용하는 방법
    - 인터페이스에 정의된 메시지를 통해서만 코드를 재사용하는 방법

- 추상 클래스 vs 자바 인터페이스 / 자바 인터페이스 vs (퍼블릭) 인터페이스 
    - 추상 클래스: 역할을 수행할 수 있는 모든 객체들이 공유하는 상태와 행동의 기본 구현이 존재하는 경우 
    - 자바 인터페이스: 공통의 구현이 필요없고 단지 책임의 목록만 정의하면 되는 경우
    - (퍼블릭) 인터페이스: 외부에서 접근 가능한 상대적으로 안정적인 부분  
    - 구현: 오직 내부에서만 접근 가능한 변경될 가능성이 높은 부분
    
- 항상 예외 케이스를 최소화하고 일관성을 유지할 수 있는 방법을 선택하라.
    - 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설꼐 측면에서 대부분의 경우 좋지 않은 선택이다.
    ```java
    public class NoneDiscountPolicy extends DiscountPolicy {
      @Override
      protected Money getDiscountAmount(Screening screening) {
          return Money.ZERO;
      }
    }
    ```

- 리팩토링
    - 변경의 이유에 따라 클래스를 분리해야 한다.
    - 코드를 통해 변경의 이유를 파악할 수 있는 방법 
        1. 인스턴스 변수가 초기화되는 시점을 살핀다.
            - 함께 초기화되는 속성으로 코드를 분리해야 한다.
            - 응집도가 높은 클래스는 인스턴스를 생성할 때 모든 속성을 함께 초기화한다. 
        2. 메서드들이 인스턴스 변수를 사용하는 방식을 살핀다.
            - 모든 메서드가 객체의 모든 속성을 사용한다면 클래스의 응집도는 높다.
            - 속성 그룹과 해당 그룹에 접근하는 메서드 그룹을 기준으로 코드를 분리해야 한다.
    
- TEMPLATE METHOD 패턴 (템플릿 메서드 패턴)
    - 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 패턴 
    
- INFORMATION EXPERT 패턴 (정보 전문가 패턴 )
    - 책임을 수행할 정보를 알고 있는 객체에게 책임을 할당하라.
    - 정보와 행동을 최대한 가까운 곳에 위치시키기 때문에 캡슐화를 유지할 수 있다.
    - 책임을 수행하는 객체(정보 전문가)가 정보를 '알고' 있다고 해서 그 정보를 '저장'하고 있을 필요는 없다.
    - e.g. 예매하라 -> Screening -> 가격을 계산하라 -> Movie -> 할인 여부를 판단하라 -> DiscountCondition 
    
- CREATOR 패턴 (창조자 패턴)
    - 어떤 방식으로든 생성되는 객체와 연결돠거나 관련될 필요가 있는 객체에 해당 객체를 생성할 책임을 맡겨라.
    - 이미 존재하는 객체 사이의 관계를 이용하기 때문에 설계가 낮은 결합도를 유지할 수 있게 한다. 
    - 어떤 객체에 대해 잘 알고 있거나, 긴밀하게 사용하거나, 초기화에 필요한 데이터를 가지고 있는 객체에서 해당 객체를 생성한다. 

- POLYMORPHISM 패턴 (다형성 패턴)
    - 객체의 타입에 따라 변하는 로직이 있을 때 타입을 명시적으로 전의하고 각 타입에 다형적으로 행동하는 책임을 할당하라.
    - 객체의 타입을 검사해서 타입에 따라 여러 대안들을 수행하는 조건적인 논리를 사용하지 마라.
    - 다형성을 이용해 새로운 변화를 다루기 쉽게 확장하라고 권고한다. 
    - 하나의 클래스가 여러 타입의 행동을 구현하고 있는 것처럼 보이는 경우에 해당 패턴에 따라 책임을 분산시킬 수 있다.
   
- 협력, 책임, 역할의 개념 
    - 협력(Collaboration)
        - 시스템의 어떤 기능을 구현하기 위해 객체들 사이에 이뤄지는 상호작용
        - 객체를 설계하는 데 필요한 일종의 문맥(context)를 제공한다.
    - 책임(Responsibility)
        - 협력에 참여(객체가 다른 객체와 협력하기 위해)하기 위해 객체가 수행하는 행동
        - 협력 안에서 객체에게 할당한 책임이 외부의 인터페이스와 내부의 속성을 결정한다.
        - 객체지향 설계에서 가장 중요한 것!
        - 책임을 할당할 때 고려할 요소 
            1. 메시지가 객체를 결정한다.
            2. 행동이 상태를 결정한다.
    - 역할(Role)
        - 객체가 어떤 특정한 협력 안에서 수행하는 책임의 집합 (대체 가능한 책임의 집합)
        - 다양한 종류의 객체를 수용(객체를 교대로 바꿔 끼울 수 있는)할 수 있는 일종의 슬롯이자 구체적인 객체들의 타입을 캡슐화하는 추상화 
        - 역할을 구현하는 가장 일반적인 방법
            1. 추상 클래스: 역할을 수행할 수 있는 모든 객체들이 공유하는 상태와 행동의 기본 구현이 존재하는 경우 
            2. 인터페이스: 공통의 구현이 필요없고 단지 책임의 목록만 정의하면 되는 경우
            
