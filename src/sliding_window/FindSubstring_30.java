package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i]由小写英文字母组成

 *
 */
public class FindSubstring_30 {


    /**
     * 优化代码
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        Map<String, Integer> countWordsMap = new HashMap<>();
        for (String word : words) {
            countWordsMap.put(word, countWordsMap.getOrDefault(word, 0) + 1);
        }

        int wc = words.length;
        int wLen = words[0].length();
        HashMap<String, Integer> curWordMap = new HashMap<>();
        for (int i = 0; i + wc * wLen <= s.length(); ++i) {
            String subStr = s.substring(i, i + wc * wLen);
            for (int j = 0; j + wLen <= subStr.length(); j = j + wLen) {
                String word = subStr.substring(j, j + wLen);
                if (!countWordsMap.containsKey(word)) {
                    break;
                }
                curWordMap.put(word, curWordMap.getOrDefault(word, 0) + 1);
            }

            if (countWordsMap.equals(curWordMap)) {
                resultList.add(i);
            }
            curWordMap.clear();
        }
        return resultList;
    }


    /**
     * 滑动窗口 改进。 双5%。 代码还是很垃圾
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring02(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        Map<String, Integer> countWordsMap = new HashMap<>();
        for (String word : words) {
            countWordsMap.put(word, countWordsMap.getOrDefault(word, 0) + 1);
        }
        int wordsCount = words.length;
        int wordLen = words[0].length();

        // 注意结束条件， i <= s.length() - wordLen
        for (int i = 0; i <= s.length() - wordLen; ++i) {
            String startWord = s.substring(i, i + wordLen);
            if (!countWordsMap.containsKey(startWord)) {
                continue;
            }

            int cnt = 1;
            int j = i + wordLen;
            HashMap<String, Integer> curCountMap = new HashMap<>();
            curCountMap.put(startWord, 1);

            // 注意边界处理
            while (j <= s.length() - wordLen && cnt < wordsCount) {
                String word = s.substring(j, j + wordLen);  // 防止空指针
                if (!countWordsMap.containsKey(word)) {
                    break;
                }

                Integer curCnt = curCountMap.getOrDefault(word, 0);
                if (curCnt >= countWordsMap.get(word)) {
                    break;
                }

                // add windows
                cnt++;
                j = j + wordLen;
                curCountMap.put(word, curCnt + 1);
            }

            if (cnt == wordsCount) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        FindSubstring_30 findSubstring_30 = new FindSubstring_30();
        String []cnt = new String[] {"ababa", "babab"};
        findSubstring_30.findSubstring("ababababab", cnt);

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map1.put("e", 1);
        map2.put("e", 1);

        System.out.println(map1.equals(map2));
    }

    /**
     * "ababababab"
     * ["ababa","babab"]
     * @param s
     * @param words
     * @return
     */


    /**
     *  这个效率还高点，比上一个方法
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring01(String s, String[] words) {

        List<Integer> resultList = new ArrayList<>();
        if (s == null || words.length == 0) {
            return resultList;
        }

        Map<String, Integer> countWordsMap = new HashMap<>();
        for (String word : words) {
            Integer orDefault = countWordsMap.getOrDefault(word, 0);
            countWordsMap.put(word, orDefault + 1);
        }
        int wordsCount = words.length;
        int wordLen = words[0].length();
        for (int i = 0; i < s.length() - wordLen*wordsCount +1;  ++i) {  // 为啥这个循环条件是  + 1
            Map<String, Integer> subStringCountMap = new HashMap<>();
            int num = 0;
            while (num < wordsCount) {
                String sub = s.substring(i + num*wordLen, i + (num+1)*wordLen);
                if (countWordsMap.containsKey(sub)) {
                    Integer orDefault = subStringCountMap.getOrDefault(sub, 0);
                    if (orDefault + 1 > countWordsMap.get(sub)) {
                        break;
                    }
                    subStringCountMap.put(sub, orDefault + 1);
                } else {
                    break;
                }
                num++;
            }
            if (num == wordsCount) {
                resultList.add(i);
            }
        }
        return resultList;
    }
}
