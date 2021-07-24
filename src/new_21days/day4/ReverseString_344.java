package new_21days.day4;

/**
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * @author ljs
 * @since 2021/7/21 下午11:05
 **/
public class ReverseString_344 {

    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        int left = 0, right = s.length-1;
        while (left < right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            left++;
            right--;
        }
    }

}
