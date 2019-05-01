# JAVA를 자바라^__^



## final

- 자바에서 final 제어자는 '변경할 수 없다'는 의미로 사용됨.
- 필드나 지역변수에 사용하면 값을 변경할 수 없는 상수가 된다.
- 클래스에 사용하면 해당 클래스는 다른 클래스가 상속받을 수 없게 된다.
- 메소드에 사용하면 해당 메소드는 오버라이딩(overriding)을 통한 재정의를 할 수 없다.
  - 메소드 오버라이딩이란 상속받은 부모 클래스의 메소드를 재정의 하여 사용하는 것을 의미

```java
final class Car { 
    // 이 클래스는 상속을 통해 서브 클래스를 생성할 수 없음.
    final int VAR;   // 이 필드는 상수화되어 값을 변경할 수 없음.
    final void brake() { // 이 메소드는 오버라이딩을 통해 재정의할 수 없음.
    final double MAX_NUM = 10.2; // 이 지역 변수는 상수화되어 값을 변경할 수 없음.
    }
}
```

## static 

- 자바에서 static 제어자는 '공통적인'이라는 의미로 사용됩니다.

- class의 모든 객체가 공유할 수 있음.
- static제어자를 변수에 사용하면 해당 변수를 **클래스 변수**로 만들어줌.



## interface

- 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 다른 클래스 사이의 중간 매개 역할까지 담당하는 일종의 추상 클래스

```java
interface Animal { public abstract void cry(); }

class Cat implements Animal {
    public void cry() {
        System.out.println("냐옹냐옹!");
    }
}
 
class Dog implements Animal {
    public void cry() {
        System.out.println("멍멍!");
    }
}

public class Polymorphism03 {
    public static void main(String[] args) {
        Cat c = new Cat();
        Dog d = new Dog();

        c.cry();
        d.cry();
    }
}
```

