package sliding_window;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * 1876. 长度为三且各字符不同的子字符串
 *
 * @author ljs
 * @since 2021/7/24 下午11:28
 **/
public class CountGoodSubstrings_1876 {

    public int countGoodSubstrings(String s) {
        if (s == null || s.length() < 3) {
            return 0;
        }

        int left = 0, right = 0;
        HashMap<Character, Integer> set = new HashMap<>();
        HashSet<String> ans = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            if (set.containsKey(s.charAt(i))) {
                Integer index = set.get(s.charAt(i));
                left = index;
            }
        }

        return 0;

    }

    public static void main(String[] args) {

        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String format = simpleDateFormat.format(instance.getTime());

        instance.add(Calendar.DATE, -100);

        String format1 = simpleDateFormat.format(instance.getTime());

        System.out.println(format);

        System.out.println(format1);

    }
}
