package weeken.w307;


/**
 * 6166. 最大回文数字 显示英文描述
 *
 * 给你一个仅由数字（0 - 9）组成的字符串 num 。
 *
 * 请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。
 *
 * 注意：
 *
 * 你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。
 * 数字可以重新排序。
 *
 * 1 <= num.length <= 105
 * num 由数字（0 - 9）组成
 *
 *
 *
 */
public class largestPalindromic_6166 {

    // mou
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        char[] nc = num.toCharArray();
        for (int i = 0; i < nc.length; ++i) {
            count[nc[i] - '0']++;
        }

        // 求偶数的最大
        StringBuilder sb = new StringBuilder();
        int mid = 10;
        for (int i = 9; i > 0; --i) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i] / 2; ++j) {
                    sb.append(i);
                }
            }
            if (mid == 10 && count[i] > 0 && count[i] % 2 == 1) {
                mid = i;
            }
        }
        if (sb.length() != 0 && count[0] != 0) {
            for (int j = 0; j < count[0] / 2; ++j) {
                sb.append(0);
            }
        }

        if (mid == 10 && count[0] > 0 ) {
            if (count[0] % 2 == 1 || sb.length() == 0)
                mid = 0;
        }

        String first = sb.toString();
        if (mid != 10) {
            first += mid;
        }
        first += sb.reverse();
        return first;
    }

    // 优化
    public String largestPalindromic01(String num) {
        int[] count = new int[10];
        char[] nc = num.toCharArray();
        for (char c : nc) {
            count[c - '0']++;
        }

        // 考虑特殊情况 全是0的情况
        if (count[0] == num.length()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int mid = 10;
        for (int i = 9; i > 0; --i) {
            for (int j = 0; j < count[i] / 2; ++j) {
                sb.append(i);
            }
            if (mid == 10 && count[i] % 2 == 1) {
                mid = i;
            }
        }

        if (sb.length() != 0) {
            for (int j = 0; j < count[0] / 2; ++j) {
                sb.append(0);
            }
            if (mid == 10 && count[0] % 2 == 1) {
                mid = 0;
            }
        }

        String first = sb.toString();
        if (mid != 10) {
            first += mid;
        }
        return first + sb.reverse();
    }

    public static void main(String[] args) {
        largestPalindromic_6166 test = new largestPalindromic_6166();
        String s = test.largestPalindromic("00009");
        System.out.println(s);
    }
}
