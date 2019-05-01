## Java Comparable & Comparator

배열이나 Collection framework 등에서 sort()를 사용하면 컴퓨터가 알아서 정렬을 해준다. 여기서 sort()는 Comparable 구현에 의해 정렬 된 것.



배열일 경우

```java
public void ArrayListEx2(){
    String[] eng = new String[]{"banana", "baseball", "ball", "pen", "sleep", "table", "good", "zoo"};
    String[] kor = new String[]{"유채원", "김미진", "이은정", "유지은", "허영진", "옥수현", "후크", "권예린", "이소현"};

    Arrays.sort(eng);
    Arrays.sort(kor);

    for (String s: eng){
        System.out.print(s);
    }
    for (String s: kor){
        System.out.print(s);
    }
}

static void print(ArrayList list1, ArrayList list2){
    System.out.println("list1: " + list1);
    System.out.println("list2: " + list2);
    System.out.println();
}
```

Arrays.sort()를 사용하여, 영어는 abc순서대로, 한글은 가나다 순서대로 정렬이 된 것을 볼 수 있다.



- Comparable- 기본 정렬기준을 구현하는데 사용
- Comparator- 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용

위에 코드에서는 String의 Comparable 구현에 의해 정렬 된 것.

Comparable을 구현하고 있는 클래스들은 같은 타입의 인스턴스끼리 서로 비교 할 수 있는 클래스들, String, Integer, Date, File등이 있음.

그리고 기본적으로 오름차순 형태로 구현되어 있다.



##### ArrayList일 경우

```java
public void ArrayListEx3(){//ArrayList일 경우
    ArrayList<String> eng = new ArrayList<String>();
    eng.add("banana");
    eng.add("apple");
    eng.add("snack");
    eng.add("pen");
    eng.add("sleep");
    eng.add("zoo");
    eng.add("mac");
    eng.add("macbook");

    Collections.sort(eng);

    for (String s:eng)
        System.out.print(s + " ");
}
```

String타입의 배열을 ArrayList로 바꾼 경우.

Arrays.sort()  --> Collections.sort()로 바뀜.



##### 다른 정렬 기준 일 경우(comparable 을 implements하기)

```java
public class Singer {
    private String name;
    private String position;
    private int age;

    public Singer(String name, String position, int age) {
        this.name = name;
        this.position = position;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

singer라는 클래스를 만들고, 가수의 객체 배열을 이용해 sort를 해보려 한다.

여기서 singer라는 객체를 생성하고, 배열이나 ArrayList형태로 만들었을 경우 Arrays.sort()나 Collections.sort()가 작동할까???????????

**오류가 발생함**

<u>이유? 정렬을 시도했지만, 객체내의 어떤 변수를 기준으로 할 지 정해지지 않았기 때문!!!!</u>

따라서 객체를 정렬할 경우 객체 내의 어떤 변수로 정렬할지 만들어 줘야 함.

이때 Comparable을 implements 한 뒤 CompareTo메소드를 구현하면 해결 할 수 있음

```java
@Override
public int compareTo(Singer singer) {
    return name.compareTo(singer.getName());
}
```

```java
public void ArrayListEx4(){
    ArrayList<Singer> singers = new ArrayList<Singer>();

    singers.add(new Singer("유채원", "보컬", 24));
    singers.add(new Singer("유채원", "보컬", 24));
    singers.add(new Singer("유지은", "메인댄서", 24));
    singers.add(new Singer("이준", "메인보컬", 24));
    singers.add(new Singer("이소현", "머글담당", 24));
    singers.add(new Singer("권예린", "작곡가", 24));
    singers.add(new Singer("이은정", "회장님", 24));

    Collections.sort(singers);

    for (int i = 0; i <singers.size(); i++){
        System.out.println(singers.get(i).getName());
    }
}
```



##### Comparator사용(Comparable을 implements하는 것 사용x)

Comparator를 사용하면 정렬 기준을 본인이 원하는 대로 바꾸는 것이 가능

```java
Collections.sort(singers, new Comparator<Singer2>() {
    @Override
    public int compare(Singer2 o1, Singer2 o2) {
        if (o1.getAge() > o2.getAge())
            return 1;
        else if(o1.getAge() < o2.getAge())
            return -1;
        else
            return 0;
    }
});
```

singer2클래스에 Comparable을 implements하지 않은 상태로 메인 함수 내에서 Collectiions.sort()를 만들었음.

