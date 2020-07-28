package doublepointer;

/**
 * create by ljs on 2020/7/22 10:45
 * description:     移除数组中值为val的元素。\\
 *
 * return 新数组的长度
 */
public class RemoveElement {


    public int removeElement(int[] nums, int val) {

        int fast = 0, slow = 0;
        for ( int length = nums.length; fast < length; ++ fast ) {
            if ( nums[fast] == val ) {
                continue;
            }
            nums[slow++] = nums[fast];
        }
        return slow;
    }



    public int removeElement01(int[] nums, int val) {

        int fast = 0, slow = 0;
        for ( int length = nums.length; fast < length; ++ fast ) {
            if ( nums[fast] != val ) {
                nums[slow++] = fast;
            }
        }
        return slow;
    }



}
