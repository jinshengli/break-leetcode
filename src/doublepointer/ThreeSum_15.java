package doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 输入：nums = []
 * 输出：[]
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 *
 */
public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {

            // 大于0之后不可能有满足的结果
            if (nums[i] > 0) {
                break;
            }

            // 去重
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 这个位置去重。很重要
                if (left > i+1 && nums[left-1] == nums[left]) {
                    left++;
                    continue;
                }

                // 去重。合选择后的比较
                if (right < nums.length - 1 && nums[right+1] == nums[right]) {
                    right--;
                    continue;
                }

                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    ans.add(tmp);

                    // 跑到下一次选择
                    right--;
                    left++;
                }
            }
        }
        return ans;
    }


    /**
     * 看注释容易犯的错
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum01(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            // 去重
            if (i != 0 && nums[i-1] == nums[i]) {
                continue;
            }

            // 大于0之后不可能有满足的结果
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                // 这个位置去重。很重要
                if (left != (i+1) && nums[left-1] == nums[left]) {
                    left++;
                    continue;
                }

                int sumRL = nums[left] + nums[right];
                if (nums[i] > -sumRL) {
                    right--;
                } else if (nums[i] < -sumRL) {
                    left++;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    ans.add(tmp);

                    // 跑到下一次选择
                    right--;
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum_15 threeSum_15 = new ThreeSum_15();
        int []num = {-2,0,0,2,2};
        List<List<Integer>> lists = threeSum_15.threeSum(num);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
