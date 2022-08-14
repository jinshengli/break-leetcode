package offer2;


import java.util.HashMap;

/**
 * 剑指 Offer II 017. 含有所有字符的最短字符串
 * 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 *
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 *
 *
 *
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 10^5
 * s 和 t 由英文字母组成
 *
 */
public class oo17_minWindow {

    // 最直接，朴素的做法。效率低。
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] smap = new int[256];
        int[] tmap = new int[256];

        for (int i = 0; i < tc.length; ++i) {
            smap[sc[i]]++;
            tmap[tc[i]]++;
        }

        if (isContain(smap, tmap)) {
            return new String(sc, 0, tc.length);
        }

        int left = 0;
        int ans = Integer.MAX_VALUE;
        String ansStr = "";
        for (int i = tc.length; i < sc.length; ++i) {
            smap[sc[i]]++;
            while (isContain(smap, tmap)) {
                if (ans > (i - left + 1)) {
                    ans = i - left + 1;
                    ansStr = new String(sc, left, ans);
                }
                smap[sc[left]]--;
                left++;

            }
        }
        return ansStr;
    }

    private boolean isContain(int[] smap, int[] tmap) {
        for (int i = 0; i < 256; ++i) {
            if (smap[i] < tmap[i]) {
                return false;
            }
        }
        return true;
    }


    // 优化。
    // 1、如果快速判断子串都包含了t所有的字母。。   hashMap 可以统计t中每个字符出现的次数和一共有多少个不同的字符。
    // 2、用一个遍历 frequent 来记录s中一共有多少个字符，它们在s中出现的次数大于等于t中出现的次数（t中出现次数也是>=1。
    // 3、当frequent = hashMap.size(). 可以收缩窗口。
    public String minWindow01(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        HashMap<Character, Integer> tHashMap = new HashMap<>();
        HashMap<Character, Integer> sHashMap = new HashMap<>();
        for (int i = 0; i < tc.length; ++i) {
            Integer orDefault = tHashMap.getOrDefault(tc[i], 0);
            tHashMap.put(tc[i], orDefault + 1);
        }

        int frequent = 0;
        int left = 0; int len = Integer.MAX_VALUE;
        int ansLeft = -1;
        for (int i = 0; i < sc.length; ++i) {
            if (tHashMap.containsKey(sc[i])) {
                int cnt = sHashMap.getOrDefault(sc[i], 0) + 1;
                sHashMap.put(sc[i], cnt);
                if (tHashMap.get(sc[i]) == cnt) {
                    frequent++;
                }
            }
            while (frequent == tHashMap.size()) {
                if (len > i - left + 1) {
                    len = i - left + 1;
                    ansLeft = left;
                }
                char leftChar = sc[left];
                left++;
                if (tHashMap.containsKey(leftChar)) {
                    int leftCharCnt = sHashMap.get(leftChar);
                    if (tHashMap.get(leftChar) == leftCharCnt) {
                        frequent--;
                    }
                    sHashMap.put(leftChar, leftCharCnt - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : new String(sc, ansLeft, len);
    }




    public static void main(String[] args) {
        oo17_minWindow test = new oo17_minWindow();
        String s1 = "a";
        String s2 = "b";
        System.out.println(test.minWindow01(s1, s2));
    }
}
