package array;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 1460. 通过翻转子数组使两个数组相等
 * 给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
 *
 * 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
 *
 *
 * target.length == arr.length
 * 1 <= target.length <= 1000
 * 1 <= target[i] <= 1000
 * 1 <= arr[i] <= 1000
 *
 *
 * 翻转任意非空子数组，= 交换任意相邻的两个元素 = 冒泡排序。
 *
 */
public class CanBeEqual_1406 {

    // hashMap
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cnt = new int[1001];
        for (int i = 0; i < target.length; ++i) {
            cnt[target[i]]++;
            cnt[arr[i]]--;
        }
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // 优化。排序
    public boolean canBeEqual2(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    public boolean canBeEqual01(int[] target, int[] arr) {
        for (int i = 0; i < target.length; ++i) {
            if (target[i] == arr[i]) {
                continue;
            }
            int j = i;
            while (j < arr.length && target[i] != arr[j]) {
                j++;
            }
            if (j >= arr.length) {
                return false;
            }
            reverse(arr, i, j);
        }
        return true;
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        CanBeEqual_1406 test = new CanBeEqual_1406();
        int[] tar = {1,2,3,4};
        int[] arr = {2,4,1,3};
        test.canBeEqual(tar, arr);
    }
}
