package monotonic_stack;


import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 496. 下一个更大元素 I
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 *
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 */
public class NextGreaterElement_496 {

    //[1,3,5,2,4]
    //[6,5,4,3,2,1,7]
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // nums, next big nums
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; ++i) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peekLast()]) {
                int index = stack.pollLast();
                map.put(nums2[index], nums2[i]);
            }
            stack.addLast(i);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    public static int[] nextGreaterElement01(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            int j = 0;
            while (j < nums2.length && nums1[i] != nums2[j]) {
                j++;
            }
            while (j < nums2.length && nums1[i] < nums2[j]) {
                j++;
            }
            ans[i] = j >= nums2.length ? -1 : nums2[j];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        int[] ints = nextGreaterElement(nums1, nums2);

        System.out.println(ints);
    }

}
