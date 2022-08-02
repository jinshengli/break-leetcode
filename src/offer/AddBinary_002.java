package offer;

public class AddBinary_002 {


    public String addBinary(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int i = aChar.length - 1;
        int j = bChar.length - 1;
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int ai = i >= 0 ? aChar[i--] - '0' : 0;
            int bi = j >= 0 ? bChar[j--] - '0' : 0;
            int sum = ai + bi + carry;
            carry = sum / 2;
            ans.append(sum % 2);
        }
        return ans.reverse().toString();
    }
}
