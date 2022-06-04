package dynamic_programming;

/**
 * create by ljs on 2020/8/4 8:53
 * description:
 *
 *  213. 打家劫舍 II
 *
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

 *
 */
public class Rob_213 {


    /**
     *  和198相比，这个是成环了。
     *
     *  确保偷第一家，不偷最后一家。
     *
     *  偷盗计划可以划分成两部分。
     *  [0, n-1] 或者 [1, n].  计算这两部分的最大值。
     *
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int max1 = robSome(nums, 0, nums.length - 2);
        int max2 = robSome(nums, 1, nums.length - 1);
        return Math.max(max1, max2);
    }

    private int robSome(int[] nums, int start, int end) {
        int firstPoint = nums[start];
        int secondPoint = Math.max(nums[start], nums[start+1]);
        for (int i = start + 2; i <= end; ++i) {
            int tmp = Math.max(firstPoint + nums[i], secondPoint);
            firstPoint = secondPoint;
            secondPoint = tmp;
        }
        return secondPoint;
    }

}
