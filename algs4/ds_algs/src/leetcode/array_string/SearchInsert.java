package leetcode.array_string;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/07/21  14:16
 * @Description:
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 特判
        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();
        int i = s.searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(i);

    }
}

