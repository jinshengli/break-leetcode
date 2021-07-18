package new_21days.day2;

/**
 * @author ljs
 * @since 2021/7/18 上午8:18
 *
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *
 **/
public class Rotate {

    public void rotate(int[] nums, int k) {
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(ans, 0, nums, 0, nums.length);
    }


}
