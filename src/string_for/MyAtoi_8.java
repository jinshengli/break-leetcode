package string_for;


/**
 * 8. 字符串转换整数 (atoi)
 *
 * 1、读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。
 * 必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。
 * 具体来说，小于 −231 的整数应该被固定为 −2^31 ，大于 231^− 1 的整数应该被固定为 2^31− 1 。
 * 返回整数作为最终结果.
 */
public class MyAtoi_8 {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        char[] charArray = s.toCharArray();
        int index = 0;
        while (index < charArray.length && charArray[index] == ' ') {
            index++;
        }

        if (index >= charArray.length) {
            return 0;
        }

        int flag = 1;
        if (charArray[index] == '-' || charArray[index] == '+') {
            flag = charArray[index] == '-' ? -1 : flag;
            index++;
        }

        for (; index < charArray.length; ++index) {
            if (charArray[index] < '0' || charArray[index] > '9') {
                break;
            }

            int last = ans;
            ans = ans * 10 + (charArray[index] - '0') * flag;
            if (last != ans/10) {  // 代表溢出
                return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MyAtoi_8 myAtoi_8 = new MyAtoi_8();
        int i = myAtoi_8.myAtoi("  ");
        System.out.println(i);
    }

}
