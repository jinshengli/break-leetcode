package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 *
 * 给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 *  更小的优先。
 *
 *
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length<= 104
 * arr按 升序 排列
 * -10^4<= arr[i], x <= 10^4
 */
public class FindClosestElements_658 {

    /**
     * 二分查找 + 双指针。
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();
        int index = binarySearch(arr, x);
        int r = index;
        int l = index - 1;
        while (k > 0) {
            if (l < 0) {
                r++;
            } else if (r >= arr.length) {
                l--;
            } else if (x - arr[l] <= arr[r] - x) {
                l--;
            } else {
                r++;
            }

            k--;
        }
        for (int i = l + 1; i < r; ++i) {
            res.add(arr[i]);
        }
        return res;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0; int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 双指针排序法。
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements02(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();
        int left = 0; int right = arr.length - 1;
        int remove = arr.length - k;
        while (remove > 0 && left <= right) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                right--;
            } else {
                left++;
            }
            remove--;
        }
        for (int i = left; i <= right; ++i) {
            res.add(arr[i]);
        }
        return res;
    }


    /**
     * 二分 第一次做法  代码不简洁
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements01(int[] arr, int k, int x) {

        List<Integer> ans = new LinkedList<>();
        int left = 0; int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int r = left;
        int l = left - 1;

        while (k > 0 && l >= 0 && r < arr.length) {
            if (Math.abs(arr[l] - x ) <= Math.abs(arr[r] - x)) {
                ans.add(arr[l]);
                l--;
            } else {
                ans.add(arr[r]);
                r++;
            }
            k--;
        }

        while (k > 0 && l >= 0) {
            ans.add(arr[l]);
            k--;
            l--;
        }

        while (k > 0 && r < arr.length) {
            ans.add(arr[r]);
            k--;
            r++;
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        FindClosestElements_658 test = new FindClosestElements_658();
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        test.findClosestElements(arr, 3, 5);
    }
}