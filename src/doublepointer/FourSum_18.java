package doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 *
 */
public class FourSum_18 {


    /**
     * 优化。 left。 right 去重的时机。
     *
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; ++i) {
            // 去重
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j <= nums.length - 3; ++j) {
                // 去重
                if (j > i + 1 && nums[j-1] == nums[j]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if ((long) (nums[i]  + nums[j] + nums[left] + nums[right]) < target) {
                        left++;
                    } else if ((long) (nums[i]  + nums[j] + nums[left] + nums[right]) > target) {
                        right--;
                    } else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]); tmp.add(nums[j]); tmp.add(nums[left]); tmp.add(nums[right]);
                        ans.add(tmp);
                        left++;
                        right--;
                        while (left < right && left > j + 1 && nums[left-1] == nums[left]) {
                            left++;
                        }
                        while (left < right && right < nums.length - 1 && nums[right] == nums[right+1]) {
                            right--;
                        }
                    }

                }
            }
        }
        return ans;
    }


    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum01(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; ++i) {
            // 去重
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j <= nums.length - 3; ++j) {
                // 去重
                if (j > i + 1 && nums[j-1] == nums[j]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // 去重
                    if (left > j + 1 && nums[left-1] == nums[left]) {
                        left++;
                        continue;
                    }

                    // 去重
                    if (right < nums.length - 1 && nums[right] == nums[right+1]) {
                        right--;
                        continue;
                    }

                    int sum = nums[i]  + nums[j] + nums[left] + nums[right]; // 有溢出的问题
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]); tmp.add(nums[j]); tmp.add(nums[left]); tmp.add(nums[right]);
                        ans.add(tmp);
                        left++;
                        right--;
                    }

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSum_18 fourSum_18 = new FourSum_18();
        int []num = {1,0,-1,0,-2,2};
        List<List<Integer>> lists = fourSum_18.fourSum(num, 0);


    }
}
