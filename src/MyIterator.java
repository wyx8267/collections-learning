import java.util.Iterator;

public class MyIterator implements Iterator {
    private final int[] nums;
    private int cursor;
    public MyIterator(int[] nums) {
        this.nums = nums;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return this.cursor < nums.length;
    }

    @Override
    public Object next() {
        int number = nums[cursor];
        cursor++;
        return number;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 6, 7, 9};
        Iterator iterator = new MyIterator(nums);
        while (iterator.hasNext()) {
            int num = (int) iterator.next();
            System.out.println("number of iterator: " + num);
        }
    }
}
