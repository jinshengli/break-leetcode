package offer;

/**
 * create by ljs on 2020/7/27 23:09
 * description:
 *
 *      请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *      完美地做法：c++中； 算出新数组最后的位置，从后面替换过来。
 *
 */
public class ReplaceSpace_05 {


    /**
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }


    /**
     *      从后面替换开始替换、
     *      %20
     *
     * @param s
     * @return
     */
    public String replaceSpace01(String s) {

        int length = s.length();
        char[] result = new char[length*3];
        int size = 0;
        for ( char c: s.toCharArray()) {
            if ( c == ' ' ) {
                result[size++] = '%';
                result[size++] = '2';
                result[size++] = '0';
            } else {
                result[size++] = c;
            }
        }
        return new String(result,0,size);
    }

}
