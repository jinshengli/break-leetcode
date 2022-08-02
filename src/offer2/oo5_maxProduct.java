package offer2;


/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
 * 假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 *  给你一个字符串数组words ，找出并返回 length(words[i]) * length(words[j])的最大值，并且这两个单词不含有公共字母。
 *  如果不存在这样的两个单词，返回 0 。
 *
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 *
 */
public class oo5_maxProduct {

    public int maxProduct(String[] words) {
        int[] hash = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            hash[i] = generateHashCode(words[i]);
        }

        int ans = 0;
        for (int i = 0; i < hash.length; ++i) {
            for (int j = i + 1; j < hash.length; ++j) {
                if ((hash[i] & hash[j]) == 0) {
                    int alen = words[i].length();
                    int blen = words[j].length();
                    ans = Math.max(ans, alen * blen);
                }
            }
        }
        return ans;
    }

    private int generateHashCode(String word) {
        char[] cs = word.toCharArray();
        int code = 0;
        for (int i = 0; i < cs.length; ++i) {
            code = code | 1 << (cs[i] - 'a');
        }
        return code;
    }
}
