package offer;

/**
 *
 *  剑指 Offer 58 - I. 翻转单词顺序
 *
 *   "  hello  world!  "  ---》 "world! hello"
 *
 *   1. trim() 去掉首尾字符： “hello  world!”
 *   2. split(" ") 根据空格划分成数组  ["hello", "", "world"]
 *   3. 反转遍历； 从后面先前遍历，
 *          碰到非空字符串，就加入到结果集中
 *          否者：跳过。
 *
 *  注意：多余的空格需要去掉哦；
 *
 *  使用双指针； 其实也不算是。
 *
 *
 */
public class ReverseWords_58I {

    public String reverseWords(String s) {

        if ( s == null || s.length() == 0 )
            return s;

        String[] sList = s.trim().split(" ");
        StringBuilder result = new StringBuilder();

        int i = sList.length -1;
        for ( ; i > 0; i-- ) {    // 从后往前遍历
            if ( "".equals(sList[i]) ) // 注意是 "" 不是 " "
                continue;
            result.append(sList[i] + " ");
        }

        result.append(sList[0]); // 注意最后一个字符串后 没有空格哦
        return result.toString();
    }


    public static void main(String[] args) {

        ReverseWords_58I reverseWords_58I = new ReverseWords_58I();
        String s = reverseWords_58I.reverseWords("a good   example");
        System.out.println(s);

    }

}
