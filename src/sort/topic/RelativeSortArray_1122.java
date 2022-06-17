package sort.topic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 *
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2中的元素arr2[i]各不相同
 * arr2 中的每个元素arr2[i]都出现在arr1
 *
 */
public class RelativeSortArray_1122 {

    public int[] relativeSortArray01(int[] arr1, int[] arr2) {
        int count[] = new int[1001];
        int ans[] = new int[arr1.length];
        for (int i = 0; i < arr1.length; ++i) {
            count[arr1[i]]++;
        }

        int k = 0;
        for (int i = 0; i < arr2.length; ++i) {
            while (count[arr2[i]] > 0) {
                ans[k++] = arr2[i];
                count[arr2[i]]--;
            }
        }

        for (int i = 0; i < count.length; ++i) {
            while (count[i] > 0) {
                ans[k++] = i;
                count[i]--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        RelativeSortArray_1122 relativeSortArray_1122 = new RelativeSortArray_1122();
        int arr1[] = {28,6,22,8,44,17};
        int arr2[] = {22,28,8,6};
        relativeSortArray_1122.relativeSortArray01(arr1, arr2);
    }


    /**
     * 25.68%
     * 8.84%
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int []result = new int[arr1.length];
        int index = 0;
        for ( int i = 0; i < arr1.length; ++i ) {
            map.put(arr1[i], map.getOrDefault(arr1[i],0) + 1);
        }

        for ( int i = 0; i < arr2.length; ++i ) {
            int n = map.get(arr2[i]);
            for (int j = 0; j < n; ++j) {
                result[index++] = arr2[i];
            }
            map.remove(arr2[i]);
        }

        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer n = map.get(key);
            for (int j = 0; j < n; ++j) {
                result[index++] = key;
            }
        }
        return result;
    }



}
