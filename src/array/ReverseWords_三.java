package array;



/**
 * create by ljs on 2020/7/22 11:03
 * description:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 *
 */
public class ReverseWords_三 {


    public String reverseWords(String s) {

        String[] words = s.split(" +");
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < words.length; ++i ) {
            words[i] = reverseString(words[i]);
            sb.append(words[i] + " ");
        }

        return sb.toString().trim();

    }

    private String reverseString(String word) {

        char[] chars = word.toCharArray();
        for ( int i =0, j = chars.length-1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {

        String a = "abc";

        StringBuilder stringBuilder = new StringBuilder("abc");

        stringBuilder.reverse();

        System.out.println(stringBuilder);


    }


}
