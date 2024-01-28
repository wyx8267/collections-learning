package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTraversalDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        map.put(4, 400);
        map.put(5, 500);

        // 遍历HashMap

        // 1. 遍历Entry
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println("Entry Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        // 2. 通过keySet()遍历key，然后利用map.get(key)获取value
        for (Integer key: map.keySet()) {
            System.out.println("KeySet: " + key + " value: " + map.get(key));
        }

        // 3.利用迭代器 set的迭代器
        // (1) entrySet迭代器
        Iterator<Map.Entry<Integer, Integer>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Integer, Integer> entry = entryIterator.next();
            System.out.println("entryset iterator: " + entry.getKey() + " Value: " + entry.getValue());
        }

        // (2) keySet迭代器
        Iterator<Integer> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()){
            Integer key = keyIterator.next();
            System.out.println("keyset iterator: " + key + " value: " + map.get(key));
        }

        // 4. lambda Java 8
        map.forEach((k, v) -> System.out.println("Lambda Foreach Key: " + k + " Value: " + v));

        map.entrySet().forEach(entry ->
                System.out.println("entryset forEach: " + entry.getKey() + " Value: " + entry.getValue())
                );
        map.keySet().forEach(k -> System.out.println("Key: " + k + " Value: " + map.get(k)));
    }
}
