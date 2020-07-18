package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * create by ljs on 2020/7/12 16:16
 * description:
 *
 * 1047. 删除字符串中的所有相邻重复项
 *
 *
 */


public class RemoveDuplicates_1047 {



    public String removeDuplicates(String S) {

        Deque<Character> stack =  new LinkedList<>();
        for ( int i = 0; i < S.length(); ++i ) {
            if ( stack.isEmpty() ) {
                stack.push(S.charAt(i));
            } else {
                char c = S.charAt(i);
                Character peekC = stack.peek();
                if ( c == peekC ) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        String res = "";
        while ( !stack.isEmpty() ) {
            Character pop = stack.pop();
            res = pop + res;
        }
        return res;
    }


    /**
     *   往栈添加元素的情况
     *
     *      1） 栈空
     *      2） 栈定元素和当前字符不相等。
     *
     *   弹出栈元素
     *
     *      1）栈顶元素和当前字符相等，
     *
     * @param S
     * @return
     */


    public String removeDuplicates1(String S) {

        Deque<Character> stack =  new LinkedList<>();  // 这是定义一个栈
        char[] chars = S.toCharArray();
        for ( int i=0; i < chars.length; ++i ) {
            if ( stack.isEmpty() || stack.peek() != chars[i] ) {
                stack.push(chars[i]);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while ( !stack.isEmpty() ) {
            sb.append(stack.removeLast());  // removeLast 代表移除栈底部第一个元素。
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Deque<Character> stack = new LinkedList<>();

        stack.push('a');
        stack.push('c');
        stack.push('d');
        stack.push('e');

        while ( ! stack.isEmpty() ) {
            System.out.println(stack.removeLast());
        }


        RemoveDuplicates_1047 removeDuplicates_1047 = new RemoveDuplicates_1047();
        String s = removeDuplicates_1047.removeDuplicates("aaabc");
        System.out.println("s = "  + s);
    }





}
