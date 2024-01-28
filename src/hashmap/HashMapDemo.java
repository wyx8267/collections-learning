package hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        // 构造hashmap
        Map<String, Double> map = new HashMap<>();

        // size / isEmpty
        System.out.println("Size of map: " + map.size());
        System.out.println("IsEmpty result: " + map.isEmpty());

        // put / putAll / putIfAbsent
        // 1 put: 把键值对放入hashmap(增和改)
        Double value = map.put("abc", 2.3);
        System.out.println("value of abc: " + value);
        System.out.println("current value of abc: " + map.get("abc"));
        value = map.put("abcd", 2.56);
        System.out.println("value of abcd: " + value);
        // 覆盖原键值对
        value = map.put("abc", 2.5);
        System.out.println("2nd value of abc: " + value);
        System.out.println("current value of abc: " + map.get("abc"));

        // 特例
        value = map.put(null, null); // add
        System.out.println("value of null: " + value);
        value = map.put(null, null); // update
        System.out.println("2nd value of null: " + value);

        map.put("a", 0.11);

        // 2 putIfAbsent map.get(key)为null，就把值放入，否则返回之前的值
        value = map.putIfAbsent("abc", 10.2);
        System.out.println("putIfAbsent value of abc: " + value);
        System.out.println("current value of abc: " + map.get("abc"));

        // 3 putAll
        Map<String, Double> newMap = new HashMap<>();
        newMap.put("d", 100.12);
        newMap.put("e", 100.13);
        newMap.put("a", 0.1);
        map.putAll(newMap);
        System.out.println("value of map key d: " + map.get("d"));
        System.out.println("value of map key a: " + map.get("a"));

        // get / getOrDefault
        // 1 get:存在则返回该value，不存在则返回空
        Double valueOfAbc = map.get("abc");
        System.out.println("valueOfAbc: " + valueOfAbc);
        Double valueOfJava = map.get("java");
        System.out.println("valueOfJava: " + valueOfJava);

        // 2 getOrDefault
        Double getOrDefault = map.getOrDefault("a", 10.05);
        System.out.println("value getOrDefault a: " + getOrDefault);
        Double methodGetOrDefault = map.getOrDefault("method", 13.333333);
        System.out.println("value getOrDefault method: " + methodGetOrDefault);

        // containsKey / containsValue
        System.out.println("containsKey abc: " + map.containsKey("abc"));
        System.out.println("containsValue 3.27: " + map.containsValue(3.27));

        // remove
        Double valueRemove = map.remove("a");
        System.out.println("remove key a: " + valueRemove);
        valueRemove = map.remove("method");
        System.out.println("remove key method: " + valueRemove);

        //replace
        Double oldValue = map.replace("e", 0.55);
        System.out.println("new value: " + map.get("e"));
        System.out.println("old value: " + oldValue);

        //keySet/values/entrySet
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("The key in map: " + key);
        }

        Collection<Double> values = map.values();
        for (Double val : values) {
            System.out.println("The value in map: " + val);
        }

        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            String key = entry.getKey();
            Double val = entry.getValue();
            System.out.println("The entry in map: " + "key: " + key + " value: " + val);
        }

        //遍历HashMap
    }
}
