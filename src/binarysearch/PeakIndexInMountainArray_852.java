package binarysearch;


/**
 * 852. 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 */
public class PeakIndexInMountainArray_852 {


    // 二分。
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid -1 ] < arr[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }



    // 二分。
    public int peakIndexInMountainArray02(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == right) {
                return mid;
            }
            if (arr[mid] <= arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public int peakIndexInMountainArray01(int[] arr) {
        int ans = -1;
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] > arr[i+1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
