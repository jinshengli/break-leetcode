package stack;

import java.util.Stack;

/**
 * create by ljs on 2020/7/12 19:45
 * description:
 *
 *          s = "(u(love)i)"
 *                "iloveu"
 */
public class ReverseParentheses_1190 {

    public String reverseParentheses(String s) {

        Stack<Integer> stack = new Stack<>();  //使用栈记录 “（” 的下标

        char[] chars = s.toCharArray();

        for ( int i = 0; i < chars.length; ++i ) {

            if ( chars[i] == '(' ) {
                stack.push(i);
            }

            if ( chars[i] == ')' ) {
                // 反转 一个 ’（‘ 到 ’）‘ 之间的字符
                reverse(chars, stack.pop()+1, i-1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for ( int i=0; i < chars.length; ++i ) {
            if ( chars[i] != '(' && chars[i] != ')' ) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    private void reverse(char[] chars, int first, int last) {

        char tmp;
        while (first < last) {
            tmp = chars[first];
            chars[first] = chars[last];
            chars[last] = tmp;
            first++;
            last--;
        }
    }


}
