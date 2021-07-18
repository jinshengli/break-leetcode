package interview;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class CheckPermutation02 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] result1 = new int[26];
        int[] result2 = new int[26];

        for (int i = 0; i < s1.length(); ++i) {
            result1[s1.charAt(i) - 'a']++;
            result2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            if (result1[i] != result2[i]) {
                return false;
            }
        }
        return true;
    }

}
