package weeken.dw83;


import java.util.*;

/**
 * 1 <= index, number <= 10^9
 * 调用 change 和 find 的 总次数 不超过 10^5 次。
 *
 */
class NumberContainers {
    Map<Integer, Integer> numsMap;
    Map<Integer, TreeSet<Integer>> numberToIndexMap;

    public NumberContainers() {
        numsMap = new HashMap<>();
        numberToIndexMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (numsMap.containsKey(index)) {
            Integer oldNumber = numsMap.get(index);
            TreeSet<Integer> oldSet = numberToIndexMap.get(oldNumber);
            oldSet.remove(index);

            numsMap.put(index, number);
            TreeSet<Integer> orDefault = numberToIndexMap.getOrDefault(number, new TreeSet<>());
            orDefault.add(index);
            numberToIndexMap.put(number, orDefault);
        } else {
            numsMap.put(index, number);
            TreeSet<Integer> orDefaultSet = numberToIndexMap.getOrDefault(number, new TreeSet<>());
            orDefaultSet.add(index);
            numberToIndexMap.put(number, orDefaultSet);
        }
    }

    public int find(int number) {
        if (numberToIndexMap.containsKey(number) ) {
            return numberToIndexMap.get(number).isEmpty() ? -1 : numberToIndexMap.get(number).first();
        }
        return -1;
    }

    public static void main(String[] args) {
        NumberContainers test = new NumberContainers();
        int i = test.find(10);
        System.out.println(i);
        test.change(1, 10);
        test.find(10);
        test.change(1, 20);
        test.find(10);
        test.find(20);
        test.find(30);

//        test.change(2, 10);
//        test.change(1, 10);
//        test.change(3, 10);
//        test.change(5, 10);
//        test.find(10);
//        test.change(1, 20);
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */