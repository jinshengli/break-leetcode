package binarysearch;

/**
 * create by ljs on 2020/7/19 15:24
 * description:
 *
 *  统计一个数字在排序数组中出现的次数。
 *
 *
 */
public class Search_offer53 {


    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length -1;
        int index = -1;

        while ( left <= right ) {
            int mid = (left+right)/2;
            if (  target < nums[mid] ) {
                right = mid - 1;
            } else if ( nums[mid] < target ) {
                left = mid + 1;
            } else {  // 找到了一个等于target的下标，这时我还想往左边查查看。
                index = mid;
                right = mid - 1;
            }
        }
        if ( index == -1 ) {
            return 0;
        }
        // 这时的index是第一个等于target的开始下标
        int result = 0;
        for ( int i = index; i < nums.length && nums[i] == target; i ++ ) {
            result ++;
        }
        return result;
    }


    public static void main(String[] args) {

        int nums[] = {5,7,7,8,8,10};
        int target = 8;

        int search = search(nums, target);
        System.out.println(search);


    }




}
