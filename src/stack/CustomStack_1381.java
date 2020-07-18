package stack;

/**
 * create by ljs on 2020/7/12 18:03
 * description:
 */
public class CustomStack_1381 {

    int []data;
    int top;
    int maxSize;





    public CustomStack_1381(int maxSize) {
        this.data = new int[maxSize];
        this.top = -1;

    }

    public void push(int x) {
        if ( top == data.length-1 ) {
            return;
        }
        data[++top] = x;
    }

    public int pop() {
        if ( top == -1 ) {
            return -1;
        }
        return data[top--];
    }

    public void increment(int k, int val) {

        for ( int i = 0; i < Math.min(k,top+1); ++i ) {
            data[i] += val;
        }
    }
}
