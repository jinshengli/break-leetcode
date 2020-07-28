package binarysearch;

/**
 * create by ljs on 2020/7/21 8:21
 * description:  二分查找模板1
 */
public class Search {


    public int search(int[] nums, int target) {

        int left = 0, right = nums.length-1;
        while ( left <= right ) {
            int mid = (left+right)/2;
            if ( nums[mid] < target ) {
                left = mid + 1;
            } else if ( nums[mid] > target ) {
                right = mid -1;
            } else {
                return mid;
            }
        }
        return -1;

    }


    /**
     *      二分查找的第二个模板
     *
     *      起始条件： left = 0, right = nums.length
     *
     *      结束条件： left == right
     *
     *      满足条件： nums[mid] == target
     *
     *      向左查询： right = mid
     *      向右查询： left = mid + 1
     *
     *      每次查询范围至少保证有两个元素以上 left < right
     *
     *      保持正解的范围是在 [left,right)
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySeach(int[] nums, int target) {

        // 判断参数
        if ( nums == null || nums.length == 0 ) {
            return -1;
        }

        int left = 0, right = nums.length;
        while ( left < right ) {
            int mid = left + (right-left)/2;
            if ( nums[mid] == target ) {
                return mid;
            } else if ( nums[mid] < target ) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 终止条件 left == right;
        // 存在情况 left 未到末尾 nums[left] == target
        if ( left != nums.length && nums[left] == target )
            return left;
        return -1;
    }


}
