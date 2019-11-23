# String을 자바라

### StringBuffer

- StringBuffer클래스의 인스턴스는 그 값을 변경할 수 도 있고, 추가할 수도 있다.

- 덧셈(+) 연산자를 이용해 String 인스턴스의 문자열을 결합하면, 내용이 합쳐진 새로운 String 인스턴스를 생성한다. 따라서 문자열을 많이 결합하면 할수록 공간의 낭비뿐 아니라 속도 또한 매우 느려짐.

- 하지만 StringBuffer 인스턴스를 사용하면 문자열을 바로 추가할 수 있으므로 공간 낭비도 없으며 속도도 빠르다.

  ```java
  StringBuffer str = new StringBuffer("Java");
  System.out.println("원본 문자열 : " + str);
  System.out.println(str.append("수업"));
  System.out.println("append() 메소드 호출 후 원본 문자열 : " + str);
  ```

  ```java
  StringBuffer str = new StringBuffer("Java Oracle");
  System.out.println("원본 문자열 : " + str);
  
  System.out.println(str.delete(4, 8)); //인덱스 4-7
  System.out.println(str.deleteCharAt(1));
  System.out.println("deleteCharAt() 메소드 호출 후 원본 문자열 : " + str);
  ```

  ```java
  StringBuffer str01 = new StringBuffer();
  StringBuffer str02 = new StringBuffer("Java");
  
  System.out.println(str01.capacity()); //capacity()현재 버퍼 크기
  System.out.println(str02.capacity());
  ```

  ```java
  StringBuffer str = new StringBuffer("Java 만세!!");
  System.out.println("원본 문자열 : " + str);
  
  System.out.println(str.insert(4, "Script"));//JavaScript 만세!!
  System.out.println("insert() 메소드 호출 후 원본 문자열 : " + str);
  ```



### StringTokenizer

- 긴 문자열을 지정된 구분자를 기준으로 문자열을 슬라이싱하는데 사용된다.

### StringBuilder

- StringBuffer와 성격이 비슷
- StringBuffer는 멀티쓰레드 환경에서 synchronized키워드가 가능하므로 동기화가 가능하다. thread-safe
- 문자열 연산이 많을 때 멀티쓰레드환경에서는 STringBufferer, 싱글스레드 또는 스레드를 신경쓰지 않아도 되는 환경에서는 StringBuilder를 사용하는 것이 적절하다
- ***StringBuilder는 동기화를 고려하지 않기 때문에 싱글쓰레드 환경에서 StringBuffered보다 빠르다.***