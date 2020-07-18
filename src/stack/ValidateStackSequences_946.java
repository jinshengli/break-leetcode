package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * create by ljs on 2020/7/13 17:38
 * description:
 *
 *      946. 验证栈序列
 *
 *
 *    pushed = [1,2,3,4,5],
 *
 *    popped = [4,5,3,2,1]
 *
 *
 */
public class ValidateStackSequences_946 {

    /**
     *  未通过 测试
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int i = 0;
        int j = 0;
        Deque<Integer> stack = new LinkedList<>();
        while ( i < pushed.length ) {
            if ( stack.isEmpty() ) {
                stack.push(pushed[i]);
                i++;
                continue;
            }
            Integer peek = stack.peek();
            if ( peek == popped[j] ) {
                stack.pop();
                j++;
                continue;
            }
            if ( peek != popped[j] && i < pushed.length ) {
                stack.push(pushed[i]);
                i++;
            }
        }

        return i == j;
    }



    /*
        通过 ；
     */
    public boolean validateStackSequences1(int[] pushed, int[] popped) {


        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        int N = pushed.length;

        for ( int x : pushed) {
            stack.push(x);
            while ( !stack.isEmpty() && stack.peek() == popped[j] ) {
                stack.pop();
                j++;
            }
        }

        return j == N;

    }



}
