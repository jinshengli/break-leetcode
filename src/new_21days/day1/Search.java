package new_21days.day1;

/**
 * @author ljs
 * @since 2021/7/17 下午10:02
 **/
public class Search {

    public static void main(String[] args) {
        int []nums = {5};
        int search = search(nums, 5);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
