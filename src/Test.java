import java.util.PriorityQueue;

/**
 * create by ljs on 2020/6/8 8:24
 */
public class Test {


    final PriorityQueue<Integer> q ;
    final int k;

    public Test(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for(int i: nums) {
            add(i);
        }
    }

    public int add(int val) {
        if(q.size() < k) {
            q.offer(val);

        }
        else if(q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

    public static void main(String[] args) {

        System.out.println( 0 ^ 2);

        System.out.println( Math.pow(0,0));
        System.out.println( Math.pow(1,0));
        System.out.println( Math.pow(2,0));

        PriorityQueue<Integer> q = new PriorityQueue<>(2);

        q.add(2);
        q.add(4);
        q.add(43);
        q.poll();

        System.out.println(q);


    }





}
