package interview;

/**
 * 空格替换成 %20
 *
 * length 长度内有效
 */
public class ReplaceSpaces03 {

    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i ) {
            char ch = S.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String replaceSpaces01(String S, int length) {
        int countSpace = 0;
        for (int i = 0; i < length; ++i) {
            if (S.charAt(i) == ' ') {
                countSpace++;
            }
        }
        int newLength = length + countSpace*2;
        int newIndex = 0;
        char[] chars = new char[newLength];
        for (int i = 0; i < length; ++i) {
            if (S.charAt(i) == ' ') {
                chars[newIndex++] = '%';
                chars[newIndex++] = '2';
                chars[newIndex++] = '0';
            } else {
                chars[newIndex++] = S.charAt(i);
            }
        }
        return new String(chars);
    }
}
