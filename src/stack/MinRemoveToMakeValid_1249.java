package stack;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * create by ljs on 2020/7/12 18:51
 * description:
 *
 *  1249. 移除无效的括号
 *
 *  使用 stack + set 记录无效字符的位置 + stringBuilder
 *
 *
 *
 */
public class MinRemoveToMakeValid_1249 {

    public String minRemoveToMakeValid(String s) {

        Deque<Integer> stack = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();  // 保存无效字符的下标

        for ( int i = 0; i < s.length(); ++i ) {

            if ( s.charAt(i) == '(' ) {
                stack.push(i);
            }

            if (s.charAt(i) == ')') {
                if ( stack.isEmpty() ) {
                    // 这个位置的字符是 不生效的 )
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        // 栈中还有多少个 无效的（ ；
        while ( !stack.isEmpty() ) {
            Integer pop = stack.pop();
            set.add(pop);
        }

        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < s.length(); ++i ) {
            if ( set.contains(i) )
                continue;
            sb.append(s.charAt(i));
        }

        return sb.toString();

    }
}
