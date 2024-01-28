package generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureDemo {
    public void transform(List<String> list) {

    }

//    public void transform(List<Integer> list) {
//
//    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> stringArrayList = new ArrayList<>();
        // ArrayList<Integer> -> ArrayList 裸类型 Raw Type
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        arrayList = stringArrayList;
        arrayList = integerArrayList;
        arrayList.add("abc");
        arrayList.add(true);
    }
}
