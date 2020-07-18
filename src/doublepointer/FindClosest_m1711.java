package doublepointer;

/**
 * create by ljs on 2020/7/14 10:07
 * description:
 *
 *
 *  面试题 17.11. 单词距离
 *
 *
 */
public class FindClosest_m1711 {


    public int findClosest(String[] words, String word1, String word2) {


        int index1 = -1;
        int index2 = -1;
        int minRes = Integer.MAX_VALUE;

        for ( int i = 0; i < words.length; ++i ) {

            if ( word1.equals(words[i]) ) {
                index1 = i;
            }

            if ( word2.equals(words[i]) ) {
                index2 = i;
            }

            if ( index1 != -1 && index2 != -1 ) {
                minRes = Math.min(minRes, Math.abs(index1-index2));
            }

        }


        return minRes;


    }


}
