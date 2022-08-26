package binarysearch;


/**
 * 33. 搜索旋转排序数组
 *
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ...,
 *  nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
 *
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 */
public class Search_33 {

    public int search01(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[0] <= nums[mid]) {
                left = mid;
            } else {
                right = right - 1;
            }
        }

        if (nums[0] <= target) {
            left = 0;
        } else {
            left = right + 1;
            right = nums.length - 1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = left + 1;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        Search_33 test = new Search_33();
        int[] nums = {1,3};
        System.out.println(test.search01(nums, 0));
    }

    public int search(int[] nums, int target) {

        /**
         * 第一步将数组一分为二，其中一部分肯定是有序的，另外一部分部分有序。
         *
         * 区分有序的，num[0] <= num[mid]
         * 再看target是不是在有序的范围内。在的话，在有序的范围内查找，不是的话，查找区间是另外一半。
         */
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // [left, mid] 是有序的
            if (nums[left] <= nums[mid]) {
                // target是在有序的区域内
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // [mid+1, right] 是有序的

                if (nums[mid + 1] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }



}
