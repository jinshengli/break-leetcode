package heap;

import java.util.*;

/**
 * create by ljs on 2020/7/26 10:26
 * description:
 *      692. 前K个高频单词
 *
 *      给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 *      返回的答案应该按单词出现频率由高到低排序。
 *      如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class TopKFrequent_692 {


    /**
     *      根据 单词出现频率排序，相同频率，
     *      
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {

        if ( words == null || words.length == 0 || k <= 0)
            return null;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        ArrayList<String> result = new ArrayList(map.keySet());
        
        Collections.sort(result, (o1, o2) -> map.get(o1).equals(map.get(o2)) ?
                        o2.compareTo(o1) : map.get(o2) - map.get(o1)
                );

        return result.subList(0,k);
    }

    public List<String> topKFrequent01(String[] words, int k) {

        if (words == null || words.length == 0 || k <= 0) return null;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 最小堆，每次剔除最小出现频率的单词;  // todo 注意最小堆比较的条件。
        // 如果在堆中，频率一样，字符先的会剔除。
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2)
                -> map.get(o1).equals(map.get(o2)) ? o2.compareTo(o1) : map.get(o1) - map.get(o2));

        for (String s : map.keySet()) {
            pq.offer(s);
            if ( pq.size() > k )
                pq.poll();
        }

        LinkedList<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.addFirst(pq.poll());
        }
        return result;
    }

}

// a b c d e f g h i j k l m n o p q s y z