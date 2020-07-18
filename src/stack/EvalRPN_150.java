package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * create by ljs on 2020/7/13 8:20
 * description:
 *
 *      150. 逆波兰表达式求值
 *      ["2", "1", "+", "3", "*"]
 *
 *      ((2 + 1) * 3) = 9
 *
 *
 *      使用栈：
 *          入栈：
 *              遇到数字
 *          出栈：
 *              遇到运算符
 *                  pop 两个。
 *
 *
 */
public class EvalRPN_150 {


    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new LinkedList<>();

        for (String s : tokens) {

            if ( s.equals("+") ) {

                Integer a = stack.pop();
                Integer b = stack.pop();

                stack.push(a+b);

            } else if ( s.equals("-")) {

                Integer a = stack.pop();
                Integer b = stack.pop();

                stack.push(b-a);

            } else if ( s.equals("*")) {

                Integer a = stack.pop();
                Integer b = stack.pop();

                stack.push(a*b);

            } else if ( s.equals("/")) {


                Integer a = stack.pop();
                Integer b = stack.pop();

                stack.push(b/a);


            } else {
                stack.push(Integer.valueOf(s));
            }

        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String s = "1293";
        Integer integer = Integer.valueOf(s);

        // Integer.parseInt(ee); 转成 int 类型

        System.out.println(integer);
    }



}
