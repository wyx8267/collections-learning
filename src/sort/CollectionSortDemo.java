package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSortDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(50);
        list.add(7);
        list.add(14);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(26);

        for (Integer element : list ) {
            System.out.println("before" + element);
        }
        Collections.sort(list);
        for (Integer element : list ) {
            System.out.println("after" + element);
        }

        Student[] students = new Student[5];
        students[0] = new Student(1, "xiaofang", 90);
        students[1] = new Student(2, "xiaoming", 86);
        students[2] = new Student(3, "xiaohong", 94);
        students[3] = new Student(4, "xiaoyuan", 78);
        students[4] = new Student(5, "xiaoxiao", 86);
        Arrays.sort(students);
        for (Student student : students) {
            System.out.println("Student: " + student.toString());
        }
    }
}
