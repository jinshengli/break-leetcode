package offer2;

import java.util.HashMap;
import java.util.Map;

public class oo4_SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            Integer aDefault = count.getOrDefault(num, 0);
            count.put(num, aDefault + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
