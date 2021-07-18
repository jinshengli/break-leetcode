package interview;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 */
public class IsUnique01 {

    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; ++i ) {
            for (int j = i + 1; j < chars.length; ++j ) {
                if (chars[i] == chars[j])
                    return false;
            }
        }
        return true;
    }

    public boolean isUnique01(String astr) {
        for (int i = 0; i < astr.length(); ++i ) {
            for (int j = i + 1; j < astr.length(); ++j ) {
                if (astr.charAt(i) == astr.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public boolean isUnique02(String astr) {
        HashSet<Character> result = new HashSet<>();
        for (int i = 0; i < astr.length(); ++i) {
            if (result.contains(astr.charAt(i))) {
                return false;
            }
            result.add(astr.charAt(i));
        }
        return true;
    }
}
