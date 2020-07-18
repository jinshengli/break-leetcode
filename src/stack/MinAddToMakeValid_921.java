package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * create by ljs on 2020/7/11 20:24
 * description:
 *
 * 921. 使括号有效的最少添加
 *
 */
public class MinAddToMakeValid_921 {




    public int minAddToMakeValid(String S) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        Deque<Character> stack = new LinkedList<>();

        for ( int i=0; i < S.length(); ++i ) {

            if ( map.containsKey(S.charAt(i)) ) { // 该 字符是 （
                stack.push(S.charAt(i));
            } else { // ')'

                if ( stack.isEmpty() ) {
                    stack.push(S.charAt(i));
                } else {

                    Character peek = stack.peek();

                    if ( '(' == peek ) {
                        stack.pop();
                    } else {
                        stack.push(')');
                    }

                }

            }

        }

        return stack.size();
    }


    public int minAddToMakeValid1(String S) {


        Deque<Character> stack = new LinkedList<>();


        for ( int i=0; i < S.length(); ++i ) {


            // push 字符的情况； 1. 栈是空的； 2. 加入的字符是 (;  3. 栈顶字符 是')'

            // pop 的情况 1 栈不空 && 栈顶元素是‘（’ && 加入元素是 ‘）’

            if (!stack.isEmpty() && stack.peek() == '(' && S.charAt(i) == ')') stack.pop();
            else stack.push(S.charAt(i));
        }

        return stack.size();
    }


}
