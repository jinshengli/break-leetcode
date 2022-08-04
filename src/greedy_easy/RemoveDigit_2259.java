package greedy_easy;


/**
 * 2259. 移除指定数字得到的最大结果
 * 给你一个表示某个正整数的字符串 number 和一个字符 digit 。
 *
 * 从 number 中 恰好 移除 一个 等于 digit 的字符后，找出并返回按 十进制 表示 最大 的结果字符串。生成的测试用例满足 digit 在 number 中出现至少一次。
 *
 * 2 <= number.length <= 100
 * number 由数字 '1' 到 '9' 组成
 * digit 是 '1' 到 '9' 中的一个数字
 * digit 在 number 中出现至少一次
 *
 */
public class RemoveDigit_2259 {


    /**
     * 1、找到第一个 number[i] == digit && number[i] < number[i+1]的， 删除number[i]为结果
     * 2、没有找到一个 number[i] == digit && number[i] < number[i+1]; 则删除最后一个 number[i], number[i] == digit
     */
    public static String removeDigit(String number, char digit) {
        char[] chars = number.toCharArray();
        int pre = -1;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == digit) {
                pre = i;
                if ((i + 1) < chars.length && chars[i+1] > chars[i]) {
                    break;
                }
            }
        }

        // pre <= chars.length - 1
        return number.substring(0, pre) + number.substring(pre+1);
    }


    /**
     *
     * 失败的答题
     *
     * 没用想到 number[i] < number[i+1] 的情况在number的中间位置。 前面有number[i] > number[i+1].  number[i] == digit
     */
    public static String removeDigit01(String number, char digit) {

        if (number == null || number.length() <= 0) {
            return number;
        }

        int left = 0, right = number.length() - 1;

        while (left < number.length()) {
            if (number.charAt(left) == digit) {
                break;
            }
            left++;
        }

        while (right >= 0) {
            if (number.charAt(right) == digit) {
                break;
            }
            right--;
        }

        if (left == right) {
            StringBuilder sb = new StringBuilder(number).deleteCharAt(left);
            return sb.toString();
        }

        StringBuilder sb = new StringBuilder(number);
        if (number.charAt(left) < number.charAt(left+1)) {
            sb.deleteCharAt(left);
        } else {
            sb.deleteCharAt(right);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = removeDigit("925", '5');
        System.out.println(s);

        String substring = "123".substring(3);
        System.out.println(substring);
    }


}