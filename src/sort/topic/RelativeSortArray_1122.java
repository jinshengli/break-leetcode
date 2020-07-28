package sort.topic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * create by ljs on 2020/7/18 22:48
 * description:
 */
public class RelativeSortArray_1122 {



    //TODO 没完成
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int []result = new int[arr1.length];
        int index = 0;
        for ( int i = 0; i < arr1.length; ++i ) {
            map.put(arr1[i], map.getOrDefault(arr1[i],0) + 1);
        }

        for ( int i = 0; i < arr2.length; ++i ) {
            int n = map.get(arr2[i]);
            while ( n > 0 ) {
                result[index++] = arr2[i];
                n--;
            }
            map.remove(arr2[i]);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator =
                map.entrySet().iterator();

        while ( iterator.hasNext() ) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int n = entry.getKey();
            while ( n > 0 ) {
                result[index++] = entry.getValue();
                n--;
            }
        }

        return result;

    }



}
