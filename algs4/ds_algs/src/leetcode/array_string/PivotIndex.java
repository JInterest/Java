package leetcode.array_string;


/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/07/20  14:47
 * @Description: 找mid
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {

        if (nums == null || nums.length == 0)
            return -1;

        int sum=0,sumLeft = 0,sumRight = 0;
        for (int n:nums){
            sum = sum + n;
        }

        for (int i=0;i<nums.length;i++){
            if (i==0){
                sumLeft = 0;
            }else {
                sumLeft = sumLeft + nums[i-1];
            }
            sumRight = sum - sumLeft - nums[i];
            if (sumLeft==sumRight){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1, 7, 3, 6, 5, 6};
        PivotIndex p = new PivotIndex();
        System.out.println(p.pivotIndex(nums));
    }

}
