package linklist;

public class MyCircularDeque_6411 {

    int[] element;
    int head;
    int tail;
    int cap;

    public MyCircularDeque_6411(int k) {
        this.cap = k + 1;
        element = new int[cap];
        head = 0;
        tail = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head - 1 + cap) % cap;
        element[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        element[tail] = value;
        tail = (tail + 1) % cap;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % cap;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + cap) % cap;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return element[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (tail - 1 + cap) % cap;
        return element[index];
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return (tail + 1) % cap == head;
    }
}
