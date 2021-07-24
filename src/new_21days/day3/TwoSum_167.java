package new_21days.day3;

/**
 *
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * @author ljs
 * @since 2021/7/21 下午10:52
 **/
public class TwoSum_167 {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while (left < right) {
            int ans = numbers[left] + numbers[right];
            if (ans == target) {
                return new int[]{left+1, right+1};
            } else if (target > ans) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }

}
