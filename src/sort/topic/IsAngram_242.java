package sort.topic;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;


/**
 * create by ljs on 2020/6/7 18:41
 *
 * 判断字母异位词。 String s, String t
 *
 * 异性单词；字母序列发生变化。
 *
 * 字母小写。
 *
 *
 * 解决方法：
 *
 * 1) 对两个字符串中的字符进行排序，再比较
 *      sort(s) == sort(t) ? true, false;
 *
 * 2) 使用哈希表；hash[26];  0 - 25的下标位置代表每个字符，值为该字符出现的次数；
 *
 *      ++; -- ; 看最后能否中和掉。
 */
public class IsAngram_242 {



    public boolean isAnagram(String s, String t) {

        int []hash = new int[26];

        if ( s.length() != t.length() )
            return false;

        for ( int i = 0; i < s.length(); ++i ){
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }

        for ( int a : hash ){
            if ( a != 0 )
                return false;
        }

        return true;
    }


    public boolean isAnagram1(String s, String t) {

        if ( s.length() != t.length() ){
            return false;
        }

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        Arrays.sort(cs);
        Arrays.sort(ct);

        boolean equals = Arrays.equals(cs, ct);
        return equals;
    }






}
