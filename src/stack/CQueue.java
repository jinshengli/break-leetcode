package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * create by ljs on 2020/7/11 19:02
 * description:
 */
public class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {

        stack1 = new LinkedList<>(); // 往这个stack添加数据
        stack2 = new LinkedList<>(); // 从这个stack 取数据

    }

    public void appendTail(int value) {

        stack1.push(value);

    }

    public int deleteHead() {

        if ( stack2.isEmpty() ) {
            // 往 添加数据
            while ( !stack1.isEmpty() ) {
                stack2.push(stack1.pop());
            }
        }

        if ( stack2.isEmpty() )
            return -1;

        return stack2.pop();

    }




}
