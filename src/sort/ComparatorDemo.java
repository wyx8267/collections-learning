package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("zba");
        stringList.add("z");
        stringList.add("yx");
        stringList.add("abc");
        stringList.add("a");

        // 1. 写Comparator实现类，实例化
        Comparator<String> comparator = new StringComparator();
        stringList.sort(comparator);

        stringList.forEach(System.out::println);

        // 2. 匿名类
        Student[] students = new Student[5];
        students[0] = new Student(1, "xiaofang", 90);
        students[1] = new Student(2, "xiaoming", 86);
        students[2] = new Student(3, "xiaohong", 94);
        students[3] = new Student(4, "xiaoyuan", 78);
        students[4] = new Student(5, "xiaoxiao", 86);

//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getScore() - o2.getScore();
//            }
//        });

        // lambda 表示法
//        Arrays.sort(students, (o1, o2) -> o1.getScore() - o2.getScore());
        // comparingInt
        Arrays.sort(students, Comparator.comparingInt(Student::getScore));
        for (Student student : students) {
            System.out.println("Student: " + student.toString());
        }
    }
}
