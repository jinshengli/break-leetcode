package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * create by ljs on 2020/7/25 23:33
 * description:
 *      451. 根据字符出现频率排序
 *
 *   输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 *
 *  练习优先队列
 *  map
 */
public class FrequencySort_451 {

    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for ( char c: s.toCharArray() ) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> heap =
                new PriorityQueue<>((v1,v2) -> v2.getValue()-v1.getValue());

        heap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder(s.length());
        while ( !heap.isEmpty()) {
            Map.Entry<Character, Integer> top = heap.poll();
            int c = top.getValue();
            while ( c  > 0 ) {
                sb.append(top.getKey());
                c--;
            }
        }
        return sb.toString();
    }


}
