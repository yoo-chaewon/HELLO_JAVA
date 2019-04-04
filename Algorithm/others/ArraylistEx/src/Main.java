import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
        //obj.ArrayListEx1();
        //obj.ArrayListEx2();
        //obj.ArrayListEx3();
        //obj.ArrayListEx4();
        obj.ArrayListEx5();
    }

    public void ArrayListEx1(){
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        ArrayList list2 = new ArrayList(list1.subList(1,4));
        print(list1, list2);

        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.containsall(list2):" + list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(2,"A");
        list2.add(3,"A");
        print(list1, list2);

        System.out.println("list1.retainAll(list2): " + list1.retainAll(list2));//겹치는 부분만 남기고 나머지 삭제
        print(list1, list2);

        for (int i = list2.size()-1; i >= 0; i--){
            if (list1.contains(list2.get(i)))
                list2.remove(i);
        }
        print(list1, list2);
    }

    public void ArrayListEx2(){//배열일 경우
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

    public void ArrayListEx4() {
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

    public void ArrayListEx5(){
        ArrayList<Singer2> singers = new ArrayList<Singer2>();

        singers.add(new Singer2("유채원", "보컬", 24));
        singers.add(new Singer2("유채투", "막내", 12));
        singers.add(new Singer2("유지은", "메인댄서", 24));
        singers.add(new Singer2("이준", "메인보컬", 30));
        singers.add(new Singer2("이소현", "머글담당", 21));
        singers.add(new Singer2("권예린", "작곡가", 20));
        singers.add(new Singer2("이은정", "회장님", 50));

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

        for (int i = 0; i <singers.size(); i++){
            System.out.println(singers.get(i).getName() + " " + singers.get(i).getAge());
        }
    }

    static void print(ArrayList list1, ArrayList list2){
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println();
    }
}


