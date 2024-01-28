package sort;

import java.util.Arrays;

public class ArraySortDemo {
    public static void main(String[] args) {
        int[] nums = {100, 3, 4, 5, 2, 2, 1, 3, 7, 9, 9};
//        for (int num: nums) {
//            System.out.println("before:" + num);
//        }

        //从小到大排序，原址排序（改动原数组
        Arrays.sort(nums);
//        for (int num: nums) {
//            System.out.println("after:" + num);
//        }

        char[] chars = {'a', 'z', 'y', 'v', 'v', 'n', 'm', 'b', 'c', 'a'};

        Arrays.sort(chars, 1, 5);
        for (char ch: chars) {
            System.out.println("after:" + ch);
        }
    }
}
