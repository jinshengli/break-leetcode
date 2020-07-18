package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * create by ljs on 2020/7/13 15:50
 * description:     、
 *
 *  394. 字符串解码
 *
 *  输入：s = "3[a2[c]]"
 *  输出："accaccacc"
 *
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 *
 *  一个字符栈  stringStack
 *
 *  一个数字栈  numberStack
 *
 *  遇到数字 进栈； 特殊： 123 这种。
 *
 *  遇到字符
 *
 *          非 ‘]’ 字符，进栈
 *
 *          是 ] 字符， 字符串出栈，知道遇到 [ ; 做个逆序，拼接成新的字符串入栈。
 *
 *
 *
 *
 */
public class RecodeString {


    /**
     *  执行用时：5 ms, 在所有 Java 提交中击败22.45%的用户
     * 内存消耗：
     * 37.8 Mb, 在所有 Java 提交中击败了7.69%的用户
     *
     *
     * @param s
     * @return
     *
     * 第一版代码太啰嗦了。
     *
     *
     */
    public String decodeString(String s) {

        Deque<String> stringStack = new LinkedList<>();
        Deque<Integer> numberStack = new LinkedList<>();

        char[] chars = s.toCharArray();
        int k = 0;

        for (int i = 0; i < chars.length; ++i) {

            if (Character.isDigit(chars[i])) {
                k = k * 10 + Integer.parseInt(chars[i] + "");
            } else if ('[' == chars[i]) {  //遇到这个[ ; 说明前面的 数字大小确定了，
                stringStack.push(chars[i] + "");
                numberStack.push(k);
                k = 0;
            } else if (']' == chars[i]) { // 遇到 ];
                // pop
                LinkedList<String> rv = new LinkedList<>();
                while (!stringStack.isEmpty() && !stringStack.peek().equals("[")) {
                    rv.addFirst(stringStack.pop());
                }
                // pop [
                stringStack.pop();

                // list --> string
                StringBuilder sb = new StringBuilder();
                for (String s1 : rv) {
                    sb.append(s1);
                }

                //  sb 重复 x 次
                String tmp = new String(sb.toString());
                Integer x = numberStack.pop(); // 对应的 【】 次数。
                while (x-- > 1) {
                    sb.append(tmp);
                }
                // sb 入栈
                stringStack.push(sb.toString());
            } else {  // 遇到普通字符
                stringStack.push(chars[i] + "");
            }


        }

        // 遍历 stringStack
        StringBuilder sb = new StringBuilder();
        while (!stringStack.isEmpty()) {
            sb.append(stringStack.removeLast());
        }
        return sb.toString();
    }


    /**
     *      改进版；
     *
     *      3[avcd2[xcdefg]]
     *
     *      k[abc]  []之间的元素先不要入栈，可以使用一个字符串保存。
     *
     * @param s
     * @return
     */

    public String decodeString01(String s) {

        Deque<String> stringStack = new LinkedList<>();
        Deque<Integer> numberStack = new LinkedList<>();

        StringBuilder res = new StringBuilder();
        int k = 0;
        for ( char s1:s.toCharArray() ) {

            if ( s1 >= '0' && s1 <= '9' ) {
                k = k*10 + s1-'0';
            } else if ( s1 == '[' ) {
                // 之前的中间字符串入栈
                stringStack.push(res.toString());
                // stringStack.push(s1 + "");
                numberStack.push(k);
                k = 0;
                res = new StringBuilder();

            } else if ( s1 == ']' ) {

                String tmp = stringStack.pop();
                // 重复 k 次 res
                StringBuilder sb = new StringBuilder(tmp);
                Integer k1 = numberStack.pop();
                while ( k1-- > 0 ) {
                    sb.append(res);
                }
                res = new StringBuilder(sb);
            } else { // 普通的字符，保存到中间字符串中，
                res.append(s1);
            }
        }

        return res.toString();
    }



    public static void main(String[] args) {
        String string = new RecodeString().decodeString("3[a2[c]]");
        System.out.println(string);
    }


}
