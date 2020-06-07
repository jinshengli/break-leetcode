import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * create by ljs on 2020/6/7 20:55
 *
 * 题目描述：
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 判断括号是否有效；
 *
 * 1) 暴力; 每次找到最近的一对左右括号；判断他们是否是一对；是： replace --》 “”； 不是 return false;
 *
 * 2) 使用栈；每次遇到左括号 (, {, [ 就入栈； 遇到右括号就和 栈顶元素比较 是否是一对；是就栈顶出栈；不是 return false;
 */
public class VaildString_20 {

    public boolean isValid(String s) {

        int flag = 0;
        while ( s.length() > 0 ){

            if ( s.indexOf("()") != -1 || s.indexOf("[]") != -1 || s.indexOf("{}") != -1 ){

                s = s.replace("()", "");
                s = s.replace("[]", "");
                s = s.replace("{}", "");
                flag = 1;
            }else {
                flag = 0;
                // return false;
            }

            if ( flag == 0 )
                break;
        }
        return s.length() == 0 ? true:false;
    }


    public boolean isValid2(String s){

        Map<Character, Character> map = new HashMap<>();
        map.put('(',')'); map.put('[',']'); map.put('{','}');

        Stack<Character> stack = new Stack<>();

        for ( char c : s.toCharArray() ){
            if ( map.containsKey(c) ){
                stack.add(c);
            }else {

                if ( stack.isEmpty() )
                    return false;
                else {
                    Character leftCharacter = stack.pop();
                    // 左对应的 右是否一致
                    if ( ! map.get(leftCharacter).equals(c))
                        return false;
                }
            }
        }

        return stack.isEmpty();

    }

    // 使用栈 进行优化一波; 代码简洁了，测试结果还没demo2效果好。

    public boolean isValid3(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')','('); map.put(']','['); map.put('}','{');
        Stack<Character> stack = new Stack<>();

        for ( int i = 0; i < s.length(); ++i ) {
            char c = s.charAt(i);
            if ( map.containsKey(c) ) {
                // c 右括号
                // 取出栈顶元素
                Character topElement = stack.empty() ? '#' : stack.pop();
                if ( map.get(c).equals(topElement) == false )
                    return false;
            } else {
                // c 代表左括号
                stack.add(c);
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        VaildString_20 vaildString_20 = new VaildString_20();
        boolean valid = vaildString_20.isValid("(()(");
        System.out.println(valid);
    }

}
