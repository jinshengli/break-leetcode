package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CanPermutePalindrome04 {

    public boolean canPermutePalindrome(String s) {

        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (countMap.containsKey(ch)) {
                Integer integer = countMap.get(ch);
                countMap.put(ch, integer+1);
            } else {
                countMap.put(ch, 1);
            }
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry:countMap.entrySet()) {
            if (entry.getValue()%2 != 0) {
                count++;
            }
        }
        return count <= 1 ? true : false;
    }

    public boolean canPermutePalindrome01(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        HashSet<Character> set = new HashSet<>();
        for (Character character : s.toCharArray()) {
            if (set.contains(character)) {
                set.remove(character);
            } else {
                set.add(character);
            }
        }

        return set.size() <= 1;
    }
}
