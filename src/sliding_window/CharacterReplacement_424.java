package sliding_window;


/**
 * 424. 替换后的最长重复字符
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 *
 * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
 *
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 *
 * 1 <= s.length <= 10^5
 * s 仅由大写英文字母组成
 * 0 <= k <= s.length
 */
public class CharacterReplacement_424 {

    // 记录每个字符出现次数， 最多字符出现次数 max_freq
    // len - max_freq <= k  ++right
    public int characterReplacement(String s, int k) {
        char[] sc = s.toCharArray();
        int[] freq = new int[26];
        int left = 0; int right = 0;
        int maxCount = 0;
        int ans = 0;
        while (right < sc.length) {
            freq[sc[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[sc[right] - 'A']);
            if (right - left + 1 > maxCount + k) {
                freq[sc[left] - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        CharacterReplacement_424 test = new CharacterReplacement_424();
        System.out.println(test.characterReplacement("AABABBA", 1));
    }
}
