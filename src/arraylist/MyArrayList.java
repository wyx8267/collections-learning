package arraylist;

import java.util.AbstractList;

/**
 * The generic array list.
 */
@SuppressWarnings("unchecked")
public class MyArrayList<E> extends AbstractList<E> {
    private final static int DEFAULT_CAPACITY = 10;
    // 属性 field

    /**
     * The data storage of array list.
     */
    private Object[] elementData;

    /**
     * The size of array list.
     */
    private int size;

    /**
     * The capacity of array list.
     */
    private int capacity;

    // 构造器 constructor
    public MyArrayList(){
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public MyArrayList(int capacity){
        if (capacity < 0) {
            throw new RuntimeException("Capacity must be positive.");
        } else if (capacity < DEFAULT_CAPACITY) {
            this.elementData = new Object[DEFAULT_CAPACITY];
            this.capacity = DEFAULT_CAPACITY;
            this.size = 0;
        } else {
            this.elementData = new Object[capacity];
            this.capacity = capacity;
            this.size = 0;
        }
    }

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
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    /**
     * Get the index of first occurrence of the specific element
     * @param element the specific element
     * @return The index
     */
    public int indexOf(Object element) {
        for (int i = 0; i < elementData.length; i++) {
            if(elementData[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Add element to this array list.
     * @param element element to add
     * @return operation result
     */
//    public boolean add(E element) {
//        add(size(), element);
//        return true;
//    }

    /**
     * Add element to specific index this array list.
     * @param index the index position to add
     * @param element the element to add
     */
    public void add(int index, E element) {
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
        elementData = newElementData;
        // 4. update capacity
        this.capacity = newCapacity;
    }

    /**
     * Remove the element for specific index
     * @param index the index position to remove
     * @return the removed element
     */
    public E remove(int index) {
        rangeCheck(index);

        // 1. Get old value by index
        E oldValue = (E) elementData[index];

        // 2. copy and shift
        int numToMoved = size - index - 1;
        if (numToMoved > 0){
            System.arraycopy(elementData, index + 1, elementData, index, numToMoved);
        }

        // 3. update size and clear
        elementData[--size] = 0;

        return oldValue;
    }

    /**
     * Removes the first occurrence of the specified element from this list.
     * @param element the specified element to remove
     * @return true if remove successfully
     */
    public boolean remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                int numToMoved = size - i - 1;
                if (numToMoved > 0){
                    System.arraycopy(elementData, i + 1, elementData, i, numToMoved);
                }
                elementData[--size] = 0;
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
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    /**
     * Get element by index.
     * @param index the index to get
     * @return the element to get
     */
    public E get(int index){
        rangeCheck(index);
        return (E) elementData[index];
    }

    private void rangeCheck(int index) {
        if(index < 0 || index >= size) {
            throw new RuntimeException(String.format("Index is invalid, index: [%d]", index));
        }
    }

    public static void main(String[] args) {
        MyArrayList list1 = new MyArrayList();
        System.out.println("The size of list 1: " + list1.size());
        System.out.println("Empty of list 1: " + list1.isEmpty());

        for (int i = 10; i < 30; i++) {
            list1.add(i);
            System.out.println("The size of list 1: " + list1.size());
        }
        list1.add(1, 100);

        System.out.println("Contains 100: " + list1.contains(100));
        System.out.println("Number to remove: " + list1.remove(1));
        System.out.println("The size of list 1: " + list1.size());

        System.out.println("Element of index 5: " + list1.get(5));

        MyArrayList list2 = new MyArrayList(20);
    }
}
