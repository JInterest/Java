package leetcode.array_string;

import java.util.Arrays;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/07/22  16:26
 * @Description:
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res=new int[len][2];
        int idx=-1;
        for (int[] v:intervals
             ) {
            //判断是否为空（-1）或 第二个区间开头是否大于第一个区间,大于添加到结果数组，小于则合并
            if (idx==-1 || v[0]>res[idx][1]){
                res[++idx]=v;
            }else {
                res[idx][1]=Math.max(res[idx][1],v[1]);
            }
        }

        return Arrays.copyOf(res,idx+1);
    }

    static class Solution {
        public static int[][] merge(int[][] intervals) {
            int len = intervals.length;
            if (len < 2) return intervals;

            int cnt = 0; // 合并次数
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                        intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                        intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                        intervals[i] = null; // 清空前者
                        cnt++;
                        break;
                    }
                }
            }

            int[][] res = new int[len - cnt][2]; // len - cnt 合并后个数
            int ri = 0;
            for (int[] pair : intervals) {
                if (pair != null) res[ri++] = pair;
            }
            return res;
        }

        public static void main(String[] args) {
            //int[][] arr1 = new int[][]{{1,2}, {2, 3}, {4, 5}};
            int[][] ints=new int[][]{{10,13},{2,5},{3,5},{11,14}};
            int[][] merge = Solution.merge(ints);
            for (int[] a:merge
                 ) {
                System.out.print("["+a[0]+","+a[1]+"]"+",");
            }
        }
    }

}
