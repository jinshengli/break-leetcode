package offer;

/**
 *     剑指 Offer 57. 和为s的两个数字
 *
 *     输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 *     如果有多对数字的和等于s，则输出任意一对即可。
 *
 *     特殊情况：
 *          1) nums == null ; nums.length < 2
 *          2) 不存在两个数之和等于target
 *
 */
@SuppressWarnings("DuplicatedCode")
public class TwoSum_57 {

    /**
     *     暴力求解。 O(n^2)  [超时]
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for ( int i = 0; i < nums.length-1; ++i ) {
            for ( int j = i+1; j < nums.length; ++j ) {
                if ( nums[i] + nums[j] == target ) {
                    return new int[] {nums[i],nums[j]};
                }
            }
        }
        return new int[] {-1,-1};
    }

    /**
     *  因为数组是有序的，可以使用双指针；
     *      前、后指针往中间紧闭； 不断缩小搜索范围。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum01(int[] nums, int target) {
        if ( nums == null || nums.length < 2 )
            return new int[]{ -1, -1};
        int i = 0, j = nums.length -1;
        while ( i < j ) {
            if ( nums[i] + nums[j] > target )
                j--; // 缩小
            else if ( nums[i] + nums[j] < target )
                i++; // 增大
            else
                return new int[] {nums[i], nums[j]};
        }
        return new int[]{ -1,-1};
    }

    /**
     *  再次优化一下；和官方答案差不多。 代码好看一些。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum02(int[] nums, int target) {
        if ( nums == null || nums.length < 2 )
            return new int[0];
        int i = 0, j = nums.length -1;
        while ( i < j ) {
            int ans = nums[i] + nums[j];
            if ( ans > target )
                j--; // 缩小
            else if ( ans < target )
                i++; // 增大
            else
                return new int[] {nums[i], nums[j]};
        }
        return new int[0];
    }

}
