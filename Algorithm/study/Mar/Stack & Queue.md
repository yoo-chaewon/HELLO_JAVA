## Stack & Queue

#### Queue<E> 인터페이스

- 스택은 클래스 형태로 구현 되어 있음
- 그러나 큐 메모리 구조는 별도의 인터페이스 형태로 제공이 됨

- Queue인터페이스를 상속받는 하위 인터페이스는
  - Deque<E>
  - BlockingDeque<E>
  - BlockingQueue<E>
  - TransferQueue<E>
  - 

#### Queue

따라서 Queue 인터페이스를 직간접적으로 구현한 클래스는 많다. 그중에서도 Deque 인터페이스를 구현한 LinkedList클래스가 큐 메모리구조를 구현하는 데 가장 많이 사용ehlsek.



- 큐 메모리 구조는 선형 메모리 공간에 데이터를 저장하면서 선입선출(FIFO)의 시멘틱을 따르는 자료 구조임.
- 즉, 가장 먼저 PUSH된 데이터가 가장 먼저 인출POP되는 구조
  		

```java
	LinkedList<String> queue_basic = new LinkedList<String>();

	switch (mCommand[0]) {
            case "push":
                queue_basic.add(mCommand[1]);
                break;
            case "pop":
                if (queue_basic.isEmpty() == true) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue_basic.pollFirst());
                }
                break;
            case "size":
                System.out.println(queue_basic.size());
                break;
            case "empty":
                if (queue_basic.isEmpty() == true) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                break;
            case "front":
                if (queue_basic.isEmpty() == true) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue_basic.peekFirst());
                }
                break;
            case "back":
                if (queue_basic.isEmpty() == true) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue_basic.peekLast());
                }
                break;
        }
```










 