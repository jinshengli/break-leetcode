package offer;

/**
 * create by ljs on 2020/8/12 23:21
 * description:
 *      剑指 Offer 50. 第一个只出现一次的字符
 *
 *      在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *      s 只包含小写字母。
 *
 */
public class FirstUniqChar_50 {


    public char firstUniqChar(String s) {

        if ( s == null || s.length() == 0 )
            return  ' ';

        int[] hashTable = new int[256];
        for ( char c:s.toCharArray() ) {
            hashTable[c]++;
        }

        for ( char c:s.toCharArray() ) {
            if ( hashTable[c] == 1 )
                return (char)c;
        }
        return ' ';
    }

}
