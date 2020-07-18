package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * create by ljs on 2020/7/12 17:15
 * description:
 *
 *  1003. 检查替换后的词是否有效
 *
 *  给定有效字符串 "abc"。
 *
 *      题目意思：   每次在给定字符串中删除 “abc”的子串；能否完全删除掉
 *
 *
 *
 */
public class IsValid_1003 {

    /**
     *
     *  从头开始遍历字符串； 每次遇到 ’c‘ 时，我们确定前两个字符必定是 'a', 'b'
     *
     *  如果不是那肯定该字符串无效。
     *
     *
     *  这个可以使用栈。
     *
     *      什么情况可以入栈：
     *          1. 遇到不是 ’c‘的字符 入栈
     *
     *      出栈：
     *          1. 遇到 'c'
     *
     *              pop 出 一个字符 是不是 'b'
     *              pop 是不是 ’c‘
     *
     * @param S
     * @return
     */
    public boolean isValid(String S) {

        Deque<Character> stack = new LinkedList<>();
        for ( int i = 0; i < S.length(); ++i ) {

            if ( S.charAt(i) != 'c' ) {
                stack.push(S.charAt(i));
            } else {
                // 该字符是’c‘
                // 栈是空； 或者 栈顶不是 ’b‘
                if ( stack.isEmpty() || stack.pop() != 'b' ) {
                    return false;
                }
                // 栈顶元素是 ’b‘
                // 判断第二个元素
                if ( stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

}
