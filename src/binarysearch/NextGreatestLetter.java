package binarysearch;


// todo no right
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0, right = letters.length - 1;
        while (left < right) {
            int mid = left + (right -left) / 2;
            if (letters[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (letters[left] == target) {
            return left + 1 == letters.length ? letters[0] : letters[left + 1];
        }

        // 未找到，但是找到target插入的位置
        if (letters[left] > target) {
            return letters[left];
        }

        // 查找超出范围了
        return letters[0];
    }

    public static void main(String[] args) {
        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
        char[] chars = {'c', 'f', 'j'};

        char j = nextGreatestLetter.nextGreatestLetter(chars, 'k');

        System.out.println(j);
    }
}
