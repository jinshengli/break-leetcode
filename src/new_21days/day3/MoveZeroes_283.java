package new_21days.day3;

import java.util.Arrays;

/**
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @author ljs
 * @since 2021/7/21 下午10:37
 **/
public class MoveZeroes_283 {

    /**
     * 这种是后面补0
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /**
     * 将0和非零的位置交换。
     * @param nums
     */
    public static void moveZeroes01(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                // left、right ; swap
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        int num[] = {0,1,2,0,5,30,0};
        // moveZeroes(num);
        moveZeroes01(num);
        Arrays.stream(num).forEach(e -> System.out.println(e));
    }
}
