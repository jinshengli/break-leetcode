import java.util.Stack;

/**
 * create by ljs on 2020/6/7 22:20
 *
 *  155 最小栈；
 *
 *  重点是维护一个最小栈； 参数时间内就可以获取栈中的最小元素。
 *
 *  封装 peek; pop 前确保stack 不空。
 *
 *  这里用到了
 *  1） 辅助栈不同步。
 *
 */
public class MinStack {

    /** initialize your data structure here. */

    private Stack<Integer> stack ;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {

        stack.add(x);

        if ( minStack.empty() || minStack.peek() >= x )
            minStack.add(x);

    }

    public void pop() {

        if ( ! stack.isEmpty() ){

            int pop = stack.pop();
            //  Integer pop1 = stack.pop(); 这里千万需要类型装换: 改成int; 方便后面的比较 ==
            // Integer o1 == Integer o2 ; 肯定是 false;
            if ( minStack.peek() == pop )
                minStack.pop();

        }


    }

    public int top() {

        if ( !stack.isEmpty() )
            return stack.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");

    }

    public int getMin() {
        if ( !minStack.isEmpty() )
            return minStack.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

}
