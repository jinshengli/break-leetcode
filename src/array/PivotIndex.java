package array;

/**
 * create by ljs on 2020/7/18 23:44
 * description:
 *
 *      寻找数组的中心索引
 *    该索引的左边元素的 和 == 右边元素之和
 *
 *    关键词： 前缀和。
 *
 */
public class PivotIndex {


    // TODO 注意边界
    public int pivotIndex(int[] nums) {

        if ( nums.length <= 2) {  // 按理说这个条件不应该， [1,0]  [0]
            return -1;
        }

        int sum = 0;
        for ( int i = 0; i < nums.length; ++i )
            sum += nums[i];

        int index = 0;

        int leftSum = 0, rightSum = sum - nums[index];

        while ( index < nums.length ) {
            if ( leftSum == rightSum )
                return index;
            else {
                leftSum += nums[index];
                int toRight = index+1 >= nums.length ? 0 :nums[index+1];
                rightSum = rightSum - toRight;
                index++;
            }
        }
        return -1;
    }


    /**
     *      改进版
     *
     *      leftSum = a[-1], a[0], ...[i-1] 的和
     *      rightSum = sum - leftSum - a[i]
     *
     *      算出 ： leftSum == rightSum 时， i 位置的大小
     *
     * @param nums
     * @return
     */
    public int pivotIndex00(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for ( int i = 0; i < nums.length; ++i ) {
            if ( leftSum == sum-leftSum-nums[i] ) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }





}
