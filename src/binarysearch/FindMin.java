package binarysearch;

/**
 * create by ljs on 2020/7/22 9:20
 * description:
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。 ==== 变成有重复元素
 *
 *
 */
public class FindMin {


    public int findMin(int[] nums) {

        int left = 0, right = nums.length -1;
        while ( left < right ) {
            int mid = (left + right) / 2;
            if ( nums[mid] > nums[right] ) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 结束条件 left == right
        return nums[left];
    }


    public int findMinSameNums(int[] nums) {

        int left = 0, right = nums.length -1;
        while ( left < right ) {
            int mid = (left + right) / 2;
            if ( nums[mid] > nums[right] ) {
                left = mid + 1;
            } else if ( nums[mid] < nums[mid] ){
                right = mid;
            } else {
                right--; // 去重。  nums[mid] == nums[right]
            }
        }
        // 结束条件 left == right
        return nums[left];
    }


}

//
// if ( nums[left] < nums[mid] && nums[mid] > nums[right] ) {
//        // 在第一个大的区间内。
//        left = mid + 1;
//        } else {
//        // 在后半部分小区间内
//        right = mid;
//        }