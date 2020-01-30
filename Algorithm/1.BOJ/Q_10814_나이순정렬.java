import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        LinkedList<Person> people = new LinkedList<>();

        for (int i = 0; i < N; i++){
            String[] input = bufferedReader.readLine().split(" ");
            people.add(new Person(Integer.parseInt(input[0]), input[1]));

        }
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        for (Person a : people){
            System.out.println(a.age + " " + a.name);
        }

    }
}
class Person{
    int age;
    String name;
    Person(int age, String name){
        this.age = age;
        this. name = name;
    }
}
