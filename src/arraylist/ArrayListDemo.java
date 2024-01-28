package arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListDemo {
    class User {
        int id;
        String name;
    }

    public static void main(String[] args) {
        // 如何构造声明ArrayList

        // (1) 不带类型的
        ArrayList list = new ArrayList();

        // (2) 带类型的 <>里面全部要引用类型 （基本类型要转化为包装类）
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

        // (3) 推荐写法
        List<Integer> integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<User> users = new ArrayList<>();

        List<Integer> integerList1 = new ArrayList<>(100);

        Collection<Integer> c = new ArrayList();
        c.add(1);
        c.add(3);
        c.add(2);
        c.add(3);
        c.add(1);
        List<Integer> integerList2 = new ArrayList<>(c);

        // size/isEmpty/contains
        System.out.println(integerList.size());
        integerList.add(100);
        System.out.println(integerList.size());
        System.out.println("Is empty: " + integerList.isEmpty());
        System.out.println("contains abc: " + integerList.contains("abc"));
        System.out.println("contains 100: " + integerList.contains(100));

        // indexOf/lastIndexOf
        System.out.println("Index of 100: " + integerList2.indexOf(100));
        System.out.println("Index of 2: " + integerList2.indexOf(2));
        System.out.println("Index of 3: " + integerList2.indexOf(3));
        System.out.println("Last index of 3: " + integerList2.lastIndexOf(3));

        // toArray
        Object[] arrays = integerList2.toArray();
        for (Object array : arrays) {
            int number = (int) array;
            System.out.println("number in arrays: " + number);
        }

        Integer[] ints = integerList2.toArray(new Integer[0]);
        for (int number : ints) {
            System.out.println("int number: " + number);
        }

        // get
        System.out.println("Element in index 0: "+ integerList2.get(0));
        for (Integer num: integerList2){
            System.out.println("get num: " + num);
        }
        integerList2.forEach(System.out::println);

        // set
        integerList2.set(1, 10);
        System.out.println("Element in index 1 after set: "+ integerList2.get(1));

        // add
        integerList2.add(5);
        System.out.println("Element in index 6 after add: "+ integerList2.get(5));
        integerList2.forEach(System.out::println);

        integerList2.add(2, 100);
        System.out.println("After add 100 at index2: ");
        integerList2.forEach(System.out::println);

        // remove
        int toRemoved = integerList2.remove(3);
        System.out.println("After remove at index 3: " + toRemoved);

        boolean isSuccess = integerList2.remove(new Integer(3));
        System.out.println("After remove 3: " + isSuccess);

        // clear
        System.out.println("Size: " + integerList2.size());
        integerList2.clear();
        System.out.println("Size: " + integerList2.size());
    }
}
