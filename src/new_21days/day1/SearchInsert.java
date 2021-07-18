package new_21days.day1;

/**
 * @author ljs
 * @since 2021/7/17 下午11:10
 *
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 **/
public class SearchInsert {


    public static void main(String[] args) {
        int []nums = {1,3};
        int i = searchInsert(nums, 2);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
