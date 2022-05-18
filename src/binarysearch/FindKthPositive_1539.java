package binarysearch;

/**
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 *
 * 请你找到这个数组里第 k 个缺失的正整数。
 *
 *   arr = [2,3,4,7,11], k = 5
 *
 *   缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 *
 */
public class FindKthPositive_1539 {

    public int findKthPositive(int[] arr, int k) {
        int num = 1, count = 0, index = 0;
        while (count < k) {
            if (arr[index] == num) {
                index = (index + 1) >= arr.length ? index : index + 1;
            } else {
                count++;
            }
            num++;
        }

        return num-1;
    }

}
