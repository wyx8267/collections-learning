package arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBulkDemo {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("A");
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("A");
        stringList2.add("a");
        stringList2.add("z");

        // containsAll
        boolean containsAllResult = stringList.containsAll(stringList2);
        System.out.println("Containsall result: " + containsAllResult);

        // addAll
//        stringList.addAll(stringList2);
//        for (String str: stringList){
//            System.out.println("String: "+str);
//        }

        stringList.addAll(1, stringList2);
        // a A a z b A
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("Index: " + i + " String: " + stringList.get(i));
        }

        // removeAll
        List<String> stringList3 = new ArrayList<>();
        stringList3.add("a");
        stringList3.add("Y");

        boolean removeAllResult = stringList.removeAll(stringList3);
        System.out.println("Removeall Result: "+ removeAllResult);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("removeall Index: " + i + " String: " + stringList.get(i));
        }

        // retainAll
        List<String> stringList4 = new ArrayList<>();
        stringList4.add("a");
        stringList4.add("b");
        stringList4.add("A");
        List<String> stringList5 = new ArrayList<>();
        stringList5.add("A");
        stringList5.add("a");
        stringList5.add("z");
        boolean retainAllResult = stringList4.retainAll(stringList5);
        System.out.println("Retainall result: " + retainAllResult);
        for (int i = 0; i < stringList4.size(); i++) {
            System.out.println("retain Index: " + i + " String: " + stringList4.get(i));
        }
    }
}
