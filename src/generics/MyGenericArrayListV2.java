package generics;

public class MyGenericArrayListV2<T> {
    private final static int DEFAULT_CAPACITY = 10;
    // 属性 field

    /**
     * The data storage of array list.
     */
    private T[] elementData;

    /**
     * The size of array list.
     */
    private int size;

    /**
     * The capacity of array list.
     */
    private int capacity;

    // 构造器 constructor
//    public MyGenericArrayListV2(){
//        this.elementData = new T[DEFAULT_CAPACITY];
//        this.capacity = DEFAULT_CAPACITY;
//        this.size = 0;
//    }

//    public MyGenericArrayListV2(int capacity){
//        if (capacity < 0) {
//            throw new RuntimeException("Capacity must be positive.");
//        } else if (capacity < DEFAULT_CAPACITY) {
//            this.elementData = new T[DEFAULT_CAPACITY];
//            this.capacity = DEFAULT_CAPACITY;
//            this.size = 0;
//        } else {
//            this.elementData = new T[capacity];
//            this.capacity = capacity;
//            this.size = 0;
//        }
//    }

    // Method

    /**
     * get size of array list.
     * @return the size of array list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Determine whether array list contains the specific element
     * @param element Specific element
     * @return true if this array list contains the specific element
     */
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    /**
     * Get the index of first occurrence of the specific element
     * @param element the specific element
     * @return The index
     */
    public int indexOf(T element) {
        for (int i = 0; i < elementData.length; i++) {
            if(elementData[i] == element){
                return i;
            }
        }
        return -1;
    }

    /**
     * Add element to this array list.
     * @param element element to add
     */
    public void add(T element) {

        add(size, element);
    }

    /**
     * Add element to specific index this array list.
     * @param index the index position to add
     * @param element the element to add
     */
    public void add(int index, T element) {
        // System.out.println("index: " + index);
        if(index < 0 || index > size) {
            throw new RuntimeException(String.format("Index is invalid, index: [%d]", index));
        }

        // 判断capacity, size
        if(size == capacity){
            // new_capacity = old_capacity * 2
            resize(size * 2);
        }

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }

        elementData[index] = element;
        size++;
    }

    /**
     * Dynamic grow
     * @param newCapacity new aim capacity
     */
    private void resize(int newCapacity) {
        // 1. Create new array
        Object[] newElementData = new Object[newCapacity];
        // 2. Copy data from element data array to new element data array
        // System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }
        // 3. elementData point to new array
        elementData = (T[]) newElementData;
        // 4. update capacity
        this.capacity = newCapacity;
    }

    /**
     * Remove the element for specific index
     * @param index the index position to remove
     * @return the removed element
     */
    public T remove(int index) {
        rangeCheck(index);

        // 1. Get old value by index
        T oldValue = elementData[index];

        // 2. copy and shift
        int numToMoved = size - index - 1;
        if (numToMoved > 0){
            System.arraycopy(elementData, index + 1, elementData, index, numToMoved);
        }

        // 3. update size and clear
        elementData[--size] = null;

        return oldValue;
    }

    /**
     * Removes the first occurrence of the specified element from this list.
     * @param element the specified element to remove
     * @return true if remove successfully
     */
    public boolean removeByValue(T element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == element) {
                int numToMoved = size - i - 1;
                if (numToMoved > 0){
                    System.arraycopy(elementData, i + 1, elementData, i, numToMoved);
                }
                elementData[--size] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Set element with the specific index
     * @param index the index to set
     * @param element the element to set
     * @return The old element
     */
    public T set(int index, T element) {
        rangeCheck(index);
        T oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    /**
     * Get element by index.
     * @param index the index to get
     * @return the element to get
     */
    public T get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    private void rangeCheck(int index) {
        if(index < 0 || index >= size) {
            throw new RuntimeException(String.format("Index is invalid, index: [%d]", index));
        }
    }

    public static void main(String[] args) {
        MyGenericArrayListV2<String> stringList = new MyGenericArrayListV2<>();
        stringList.add("mirai");

        MyGenericArrayListV2<Customer> customerList = new MyGenericArrayListV2<>();
        customerList.add(new Customer());
    }
}

class Customer {
    String customerId;
    String name;
}