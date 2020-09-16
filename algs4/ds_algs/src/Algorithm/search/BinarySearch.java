package Algorithm.search;


import Algorithm.sort.Sort;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/08/26  16:43
 * @Description: 二分查找  *******要求数组是有序的*******
 */
public class BinarySearch {
    static int a=1;
    static int b=1;
    static int c=1;
    public static void main(String[] args) {
        Sort sort = new Sort();
        //数组容量
        int capacity = 80000;
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = (int) (Math.random() * 888888);
        }
        sort.mergeSort(array, 0, array.length - 1, new int[array.length]);

        int[] a = {1, 3, 5, 5, 7, 7, 9, 10};
        int k = simple(array, 6666);
        //int i = leftBound(a, 7);
        //int i = rightBound(a, 5);
        int j = recursion(array,0,array.length-1,6666);
        int i = insertValue(array, 0,array.length-1,6666);

        System.out.println((k != -1 ? "所在位置下标：" + k : "不存在！！！"));
        System.out.println((j != -1 ? "所在位置下标：" + j : "不存在！！！"));
        System.out.println((i != -1 ? "所在位置下标：" + i : "不存在！！！"));
    }

    /**
     * 最简二分查找
     */
    public static int simple(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        if ( target < array[0] || target > array[array.length - 1]) {
            return -1;
        }
        while (left <= right) {

            System.out.println("最简查找次数："+( a++ ));
            int mid = left + (right - left)/ 2;//防止溢出
            if (target < array[mid]) {
                right = mid - 1;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else if (target == array[mid]) {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归形式 二分查找
     */
    public static int recursion(int[] arr, int left, int right, int target) {
        System.out.println("递归最简查找次数："+(b++));

        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (target > midVal) { // 向右递归
            return recursion(arr, mid + 1, right, target);
        } else if (target < midVal) { // 向左递归
            return recursion(arr, left, mid - 1, target);
        } else {
            return mid;
        }

    }

    /**
     * 插值查找  改进的二分查找---适合数据量大的，关键字分布比较均匀的
     * int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]) 查找的目标距left的偏移量
     */
    public static int insertValue(int[] arr, int left, int right, int target) {
        System.out.println("插入查找次数："+(c++));

        if (left > right || target < arr[0] || target > arr[arr.length - 1]) {
            return -1;
        }

        // 求出mid, 自适应
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);

        int midVal = arr[mid];
        if (target > midVal) { // 说明应该向右边递归
            return insertValue(arr, mid + 1, right, target);
        } else if (target < midVal) { // 说明向左递归查找
            return insertValue(arr, left, mid - 1, target);
        } else {
            return mid;
        }

    }


    /**
     * 二分查找 左边第一个
     */
    public static int leftBound(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < array[mid]) {
                right = mid - 1;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else if (target == array[mid]) {
                //别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        //检查 left 是否越界
        if (left >= array.length || array[left] != target)
            return -1;
        return left;
    }

    /**
     * 二分查找 查找右边第一个
     */
    public static int rightBound(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/ 2;
            if (target < array[mid]) {
                right = mid - 1;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else if (target == array[mid]) {
                //别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        //检查 right 是否越界
        if (right < 0 || array[right] != target)
            return -1;
        return right;
    }
}
