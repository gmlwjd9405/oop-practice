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