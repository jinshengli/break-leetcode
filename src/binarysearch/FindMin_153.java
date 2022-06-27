package binarysearch;

/**
 * create by ljs on 2020/7/22 9:20
 * description:
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 153. 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数 互不相同
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 */
public class FindMin_153 {



    public static int findMin01(int[] nums) {
        int left = 0, right = nums.length - 1;
        while ( left < right ) {
            int mid = left + (right - left) / 2;
            // 这个太他妈神了。
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 结束条件 left == right
        return nums[left];
    }

    public static void main(String[] args) {
        // int []nums = {3,4,5,1,2};
        int nums[] = {1, 2,3,4};
        int min01 = findMin01(nums);

        System.out.println(min01);
    }





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