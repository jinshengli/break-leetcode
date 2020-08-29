package binarysearch;

/**
 * create by ljs on 2020/7/21 8:21
 * description:  二分查找模板1
 */
public class Search {

    // 一、寻找一个数（基本的二分搜索）
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


    // 查找目标数 第一次出现的下标
    int left_bound(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while ( left <= right ) {
            int mid = left + (right-left)/2;
            if ( nums[mid] < target ) {
                left = mid + 1;
            } else if ( nums[mid] > target ) {
                right = mid - 1;
            } else if ( nums[mid] == target ) {
                right = mid - 1; // 向左区间逼近
            }

        }

        if ( left >= nums.length || nums[left] != target ) // 判断目标数大于所有的元素；越界；元素不存在
            return -1;
        return left;
    }

    // 找到目标数的； 在最右的下标
    int right_bound(int[] nums, int target) {

        if ( nums == null || nums.length == 0 )
            return -1;

        int left = 0, right = nums.length -1;

        while ( left <= right ) {

            int mid = left + (right-left)/2;
            if ( nums[mid] < target ) {
                left = mid + 1;
            } else  if ( nums[mid] > target ) {
                right = mid - 1;
            } else if ( nums[mid] == target ) {
                left = mid + 1;  // 向右区间逼近、
            }
        }

        if ( right < 0 || nums[right] != target )
            return -1;
        return right;
    }

}
