package binarysearch;

import javax.print.attribute.standard.PrinterURI;

/**
 * create by ljs on 2020/8/19 17:42
 * description:
 *      34. 在排序数组中查找元素的第一个和最后一个位置
 *
 *
 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。


 我们总结出来一个小技巧，当左边界要更新为l = midl=mid时，我们就令 mid =(l + r + 1)/2mid=(l+r+1)/2，上取整，此时就不会因为rr取特殊值r = l + 1r=l+1而陷入死循环了。

 作者：lin-shen-shi-jian-lu-k
 todo：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solution/tu-jie-er-fen-zui-qing-xi-yi-dong-de-jia-ddvc/
 你的算法时间复杂度必须是 O(log n) 级别。
 *
 *
 */
public class SearchRange_34 {


    public int[] searchRange(int[] nums, int target) {

        if ( nums == null || nums.length == 0 )
            return new int[] {-1,-1};

        int left = left_bound(nums, target);
        int right = rigth_bound(nums, target);

        return new int[] {left, right};
    }

    public static void main(String[] args) {
        SearchRange_34 searchRange_34 = new SearchRange_34();

        int [] arr = {5,7,7,8,8,10};

        int[] ints = searchRange_34.searchRange01(arr, 8);

        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    public int[] searchRange01(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int l = findFirstPosition(nums, target);
        if (l == -1) {
            return new int[] {-1, -1};
        }
        int r = findLastPosition(nums, target);
        return new int[] {l, r};
    }

    // 最好的方式。 max
    public int[] searchRange02(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int left = 0, right = nums.length - 1;

        // 找第一个出现target的位置
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] != target) {
            return new int[] {-1, -1};
        }

        int L = left;

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int R = right;
        return new int[] {L, R};
    }



    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // TODO 需要向上取整，否则死循环。
            int mid = left + (right - left + 1) / 2;

            System.out.println("l=" + left + ", mid=" + mid + ", right=" + right);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid; // 这里确定了mid需要向上取整
            } else {
                // num[mid] > num[target]
                right = mid - 1;
            }
        }
        return nums[right] == target ? right : -1;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 下一次搜索区间 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 下一次搜索区间 [left, mid]
                right = mid;
            } else {
                // 下一次搜索区间 [left, mid - 1]
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }


    private int rigth_bound(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while ( left <= right ) {

            int mid = left + (right - left)/2;
            if ( nums[mid] < target ) {
                left = mid + 1;
            } else if ( nums[mid] > target ) {
                right = mid - 1;
            } else if ( nums[mid] == target ) {
                left = mid + 1;
            }
        }

        if ( right < 0 || nums[right] != target )
            return -1;

        return right;
    }

    private int left_bound(int[] nums, int target) {

        int left = 0, right = nums.length -1;
        while ( left <= right ) {

            int mid = left + (right-left)/2;
            if ( nums[mid] < target ) {
                left = mid + 1;
            } else if ( nums[mid] > target ) {
                right = mid - 1;
            } else if ( nums[mid] == target ) {
                right = mid - 1;
            }
        }

        if ( left == nums.length || nums[left] != target )
            return -1;
        return left;
    }


}
