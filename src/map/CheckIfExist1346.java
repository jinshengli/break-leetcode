package map;


import java.util.Arrays;
import java.util.HashSet;

/**
 * 1346. 检查整数及其两倍数是否存在
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 *
 *
 *
 */
public class CheckIfExist1346 {


    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i) {
            if (set.contains(2*arr[i]) || (arr[i] % 2 == 0 && set.contains(arr[i] % 2))) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public boolean checkIfExist01(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; ++i) {
            int j = i + 1;
            while (j < arr.length) {
                if (2*arr[i] == arr[j] || arr[j]*2 == arr[i]) return true;
                // if (2*arr[i] < arr[j]) break;
                j++;
            }
        }
        return false;
    }

}
