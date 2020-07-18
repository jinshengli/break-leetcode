package divide_conquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * create by ljs on 2020/7/9 20:14
 * description:
 */
public class LetterCombinations_17 {


    public List<String> letterCombinations(String digits) {

        // 填充个map
        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");



        List<String> list = new ArrayList<>();
        int level = 0;
        String tmp = "";

        if ( digits == null || digits.length() == 0 ) {
            return list;
        }

        getResult(hashMap, list, digits, level, tmp);

        return list;
    }

    private void getResult(HashMap<Character, String> hashMap,
                           List<String> list, String digits, int level, String tmp) {

        // 选择了最后的号码了;
        if ( level == digits.length() ) {
            list.add(tmp);
            return;
        }

        // 选择该层 可以选择的 字符集
        String character = hashMap.get(digits.charAt(level));
        for ( int i = 0;  i < character.length(); ++i ) {
            getResult(hashMap, list, digits, level+1, tmp+character.charAt(i) );
        }

        // 回溯

    }


    //




    public static void main(String[] args) {


        String a = "abc";

        System.out.println(a.charAt(0));


        char c = a.charAt(1);


    }




}
