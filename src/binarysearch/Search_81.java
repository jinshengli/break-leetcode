package binarysearch;


/**
 * 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * 你必须尽可能减少整个操作步骤。
 *
 *
 *  1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 */
public class Search_81 {

    public boolean search(int[] nums, int target) {

        if (nums.length == 1) {
            return target == nums[0];
        }

        int left = 0; int right = nums.length - 1;

        while (right > 0 && nums[right] == nums[0]) right--;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (nums[0] <= target) {
            left = 0;
        } else {
            left = right + 1;
            right = nums.length - 1;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == right && nums[left] == target;
    }

    public static void main(String[] args) {
        Search_81 test = new Search_81();
        // int[] nums = {2,5,6,0,0,1,2};
        int[] nums = {1, 1};
        System.out.println(test.search(nums, 1));
    }

}
