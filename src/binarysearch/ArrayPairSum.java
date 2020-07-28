package binarysearch;

import java.util.Arrays;

/**
 * create by ljs on 2020/7/22 10:35
 * description:
 */
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for ( int i = 0; i < nums.length - 1;  i = i + 2 ) {
            sum += nums[i];
        }

        return sum;
    }



}
