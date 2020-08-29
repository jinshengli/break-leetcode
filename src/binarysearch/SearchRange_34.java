package binarysearch;

/**
 * create by ljs on 2020/8/19 17:42
 * description:
 *      34. 在排序数组中查找元素的第一个和最后一个位置
 *
 *
 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。
 *
 *
 */
public class SearchRange_34 {


    public int[] searchRange(int[] nums, int target) {

        if ( nums == null || nums.length == 0 )
            return new int[] {-1,-1};

        int left = left_bound(nums, target);
        int right = rigth_bound(nums, target);

        return new int[] {left, right};
    }

    private int rigth_bound(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while ( left <= right ) {

            int mid = left + (right - left)/2;
            if ( nums[mid] < target ) {
                left = mid + 1;
            } else if ( nums[mid] > target ) {
                right = mid - 1;
            } else if ( nums[mid] == target ) {
                left = mid + 1;
            }
        }

        if ( right < 0 || nums[right] != target )
            return -1;

        return right;
    }

    private int left_bound(int[] nums, int target) {

        int left = 0, right = nums.length -1;
        while ( left <= right ) {

            int mid = left + (right-left)/2;
            if ( nums[mid] < target ) {
                left = mid + 1;
            } else if ( nums[mid] > target ) {
                right = mid - 1;
            } else if ( nums[mid] == target ) {
                right = mid - 1;
            }
        }

        if ( left == nums.length || nums[left] != target )
            return -1;
        return left;
    }


}
