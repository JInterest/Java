package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/08/29  0:02
 * @Description: 数组的常用方法
 */
public class ArrayTest {

    public static void main(String[] args) {
        System.out.println("------1.  声明一个数组-------");
        String[] aArray = new String[5];
        String[] bArray = {"a", "b", "c", "d", "e"};
        String[] cArray = new String[]{"a", "b", "c", "d", "e"};
        int[][] arrays = new int[][]{{1, 2, 3}, {4, 5, 6}};


        System.out.println("------2.  输出一个数组-------");
        int[] intArray = { 1, 2, 3, 4, 5 };
        // 直接打印 输出的是该数组的地址
        System.out.println(intArray);// [I@1e643faf
        // 使用Arrays的toString
        String intArrayString = Arrays.toString(intArray);
        System.out.println(intArrayString);// [1, 2, 3, 4, 5]


        System.out.println("------3. 从一个数组创建数组列表-------");
        String[] stringArray = { "a", "b", "c", "d", "e" };
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArray));
        System.out.println(arrayList);// [a, b, c, d, e]


        System.out.println("------4.  将一个数组列表转换为数组-------");
        String[] stringArr = new String[arrayList.size()];
        arrayList.toArray(stringArr);
        for (String s : stringArr)
            System.out.print(s);


        System.out.println("------5.  检查一个数组是否包含某个值-------");
        String[] stringArray2 = { "a", "b", "c", "d", "e" };
        boolean b = Arrays.asList(stringArray2).contains("a");
        System.out.println(b); // true


        System.out.println("------6.  数组的复制-------");
        String[] copyOf = Arrays.copyOf(bArray, bArray.length);
        System.out.println(Arrays.toString(copyOf));

    }

}