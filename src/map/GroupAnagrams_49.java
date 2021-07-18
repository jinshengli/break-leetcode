package map;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ljs
 * @since 2021/7/18 上午10:36
 **/
public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resultMap = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            byte[] bytes = strs[i].getBytes();
            Arrays.sort(bytes);
            String key = new String(bytes);
            List<String> stringList = resultMap.getOrDefault(key, new ArrayList<>());
            stringList.add(strs[i]);
            resultMap.put(key, stringList);
        }
        return new ArrayList<>(resultMap.values());
    }

    public List<List<String>> groupAnagrams02(String[] strs) {
        Map<String, List<String>> listMap = Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            return new String(array);
        }));
        return new ArrayList<>(listMap.values());
    }

    public List<List<String>> groupAnagrams03(String[] strs) {
        Map<String, List<String>> listMap = Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            int count[] = new int[26];
            for (int i = 0; i < str.length(); ++i) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < count.length; ++i) {
                if (count[i] != 0) {
                    key.append((char) (i + 'a'));
                    key.append(count[i]);
                }
            }
            return key.toString();
        }));
        return new ArrayList<>(listMap.values());
    }

}
