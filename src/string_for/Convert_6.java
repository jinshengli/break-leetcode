package string_for;


/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 */
public class Convert_6 {
    public String convert(String s, int numRows) {

        if (numRows <= 1) {
            return s;
        }

        StringBuilder []str = new StringBuilder[numRows];

        for (int i = 0; i < str.length; ++i) {
            str[i] = new StringBuilder();
        }

        int row = 0;
        int flag = -1;

        for (char c : s.toCharArray()) {
            str[row].append(c);
            if (row == 0 || row == numRows - 1) {
                flag = -flag;
            }
            row = row + flag;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder stringBuilder : str) {
            ans.append(stringBuilder);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Convert_6 convert_6 = new Convert_6();
        String paypalishiring = convert_6.convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);
    }

}
