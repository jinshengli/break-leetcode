package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * create by ljs on 2020/6/14 19:29
 * <p>
 * description:
 *
 *  生成合适的n对左右括号 子集
 *
 *
 */
public class Solution_22 {

    private List<String> list = new ArrayList<>();

    public List<String> generateParenthesis01(int n) {

        _generation01(0,0,n,"");

        return list;
    }

    /*
        1）结束条件 left == n && right == n
        2) 继续处理的情况
            left < n;
            right < left && right < n

     */
    private void _generation01(int left, int right, int n, String s){

        if ( left == n && right == n ){
            System.out.println(s);
            list.add(s);
            return;
        }

        if ( left < n )
            _generation01(left+1, right, n, s + "(");
        if ( right < n && right < left )
            _generation01(left, right+1, n, s + ")");

    }



    public List<String> generateParenthesis(int n) {

        ArrayList<String> res = new ArrayList<>();
        _generation(0, 2*n, "", res);

        return res;
    }

    private void _generation(int leve, int max, String s, List<String> res) {

        if ( leve >= max ){

            if (_checkIfValilString(s)){
                res.add(s);
            }
            return;
        }

        _generation(leve+1, max, s + "(", res);
        _generation(leve+1, max, s + ")", res);


    }

    private boolean _checkIfValilString(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i=0; i < s.length(); ++ i ) {

            if ( s.charAt(i) == '(' ) {
                stack.push(s.charAt(i));
            } else {

                if ( stack.isEmpty() )
                    return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution_22 solution = new Solution_22();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
    }



}
