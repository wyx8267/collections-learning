package hashmap;

public class MyHashMap<K, V> {
    // java底层中数组长度必须2的幂次
    private static final int DEFAULT_INIT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;

    // Fields
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    // 底层数组初始化容量
    private int initCapacity;

    // 装填因子LF
    private float loadFactor;

    // hashmap元素个数
    private int size;

    // 采用数组 + 链表作为底层存储结构
    private Node<K, V>[] table;

    // Constructor
    public MyHashMap() {
        this(DEFAULT_INIT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initCapacity, float loadFactor) {
        this.initCapacity = initCapacity;
        this.loadFactor = loadFactor;
        this.table = new Node[initCapacity];
    }

    // Methods - put/get/remove
    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * Put key-value entry into my hash map.
     *
     * @param key   specific key
     * @param value value
     * @return null if add new entry, old value if key exists(update)
     */
    public V put(K key, V value) {
        if(size() >= initCapacity * loadFactor) {
            resize(initCapacity * 2);
        }
        int index = hash(key);
        Node<K, V> node = table[index];
        if (node == null) {
            // 哈希桶为空，直接插入新节点
            table[index] = new Node<>(key, value, null);
            size++;
        }
        // 哈希桶不为空，两种情况：
        // 1.key存在，更新value
        // 2.key不存在，新增key-value
        while (node != null) {
            if (node.key == key) {
                V oldValue = node.getValue();
                node.setValue(value);
                return oldValue;
            }
            if (node.getNext() == null) {
                // 尾插法
                node.setNext(new Node<>(key, value, null));
                size++;
            }
            node = node.getNext();
        }
        return null;
    }

    private int hash(K key) {
        return Math.max(key.hashCode() % this.initCapacity, 0);
    }

    private void resize(int newCapacity) {
        Node<K, V>[] newTable = new Node[newCapacity];
        this.initCapacity = newCapacity;
        // rehashing重哈希：遍历旧哈希表的哈希桶
        for (Node<K, V> node: this.table) {
            // 遍历链表
            while(node != null){
                // 在新哈希表的位置
                int index = hash(node.getKey());
                Node<K, V> newNode = new Node<>(node.getKey(), node.getValue(), null);
                if(newTable[index] != null){
                    // 找到合适插入的位置
                    Node<K, V> head = newTable[index];
                    while (head.getNext() != null) {
                        head = head.getNext();
                    }
                    // head.next == null
                    head.setNext(newNode);
                }else{
                    // 直接插入头结点
                    newTable[index] = newNode;
                }
                node = node.getNext();
            }
        }
        // 建议：把旧table中元素设置为空，帮助垃圾回收
        // 替换为新哈希表
        this.table = newTable;
    }

    /**
     * Get related value by key
     *
     * @param key specific key
     * @return null if key not exists, value with the specific key
     */
    public V get(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while(node != null){
            if(node.getKey() == key){
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * Remove related value by specific key
     *
     * @param key specific key
     * @return null if key not exists, value to be removed with the specific key
     */
    public V remove(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];

        // 针对链表头节点
        if(node == null){
            return null;
        }

        if(node.getKey() == key){
            // 保存被删node的next
            Node<K, V> temp = node.getNext();
            // node.next设置为null
            node.setNext(null);
            table[index] = temp;
            size--;
            return node.getValue();
        }

        // 针对非头节点
        Node<K, V> prevNode = node;
        Node<K, V> curNode = node.next;
        while(curNode != null){
            if(curNode.getKey() == key){
                prevNode.setNext(curNode.getNext());
                curNode.setNext(null);
                size--;
                return curNode.getValue();
            }
            prevNode = curNode;
            curNode = curNode.getNext();
        }
        return null;
    }

    public static void main(String[] args) {
//        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
//        System.out.println("hashmap is empty: " + hashMap.isEmpty());
//        MyHashMap<String, String> stringMap = new MyHashMap<>(10, 0.5F);
//
//        hashMap.put(10, "apple");
//        hashMap.put(22, "cat");
//        hashMap.put(6, "dog");
//        System.out.println("The size: " + hashMap.size());
//        for (Node<Integer, String> node: hashMap.table) {
//            System.out.println(node);
//        }
//        System.out.println("The value of key 10: " + hashMap.get(10));
//        System.out.println("The value of key 22: " + hashMap.get(22));
//        System.out.println("The value of key 6: " + hashMap.get(6));
//        System.out.println("The value of key 54: " + hashMap.get(54));
//
//        hashMap.put(54, "cow");
//        System.out.println("The value of key 6: " + hashMap.remove(6));
//        System.out.println("The value of key 10: " + hashMap.remove(10));
//        System.out.println("The value of key 166: " + hashMap.remove(166));
//        for (Node<Integer, String> node: hashMap.table) {
//            System.out.println(node);
//        }
//        System.out.println("The size: " + hashMap.size());
//        System.out.println("hashmap is empty: " + hashMap.isEmpty());

        MyHashMap<Integer, Integer> intHM = new MyHashMap<>(5, 0.75F);
        intHM.put(10, 3);
        intHM.put(3, 30);
        intHM.put(5, 12);
        intHM.put(4, 988);
        intHM.put(9, 12);
        intHM.put(2, 3);
        intHM.put(8, 30);
        intHM.put(7, 12);
        intHM.put(11, 988);
        intHM.put(12, 12);
        for (Node<Integer, Integer> node: intHM.table) {
            System.out.println(node);
        }

        System.out.println("---------------");
        MyHashMap<String, String> stringMap = new MyHashMap<>(5, 0.5F);
        stringMap.put("aa", "cat");
        stringMap.put("ab", "dog");
        stringMap.put("ac", "cow");
        stringMap.put("bb", "bird");
        stringMap.put("aaaaaa", "apple");
        for (Node<String, String> node: stringMap.table) {
            System.out.println(node);
        }
    }
}
