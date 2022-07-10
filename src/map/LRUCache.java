package map;


import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {

    int capacity;
    Map<Integer, DListNode> map;
    DListNode headDummy;
    DListNode tailDummy;

    class DListNode {
        int key;
        int value;
        DListNode pre;
        DListNode next;

        public DListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.headDummy = new DListNode(-1, -1);
        this.tailDummy = new DListNode(-1, -1);
        this.headDummy.next = this.tailDummy;
        this.tailDummy.pre = this.headDummy;
    }

    public int get(int key) {
        DListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        deleteNode(node);
        addToHead(node);
        return node.value;
    }

    private void addToHead(DListNode node) {
        node.next = headDummy.next;
        node.pre = headDummy;
        headDummy.next.pre = node;
        headDummy.next = node;
    }

    private void deleteNode(DListNode node) {
        if (headDummy == node || tailDummy == node) {
            return;
        }
        DListNode pre = node.pre;
        DListNode nodeNode = node.next;
        pre.next = nodeNode;
        nodeNode.pre = pre;
        node.pre = null;
        node.next = null;
    }

    public void put(int key, int value) {
        DListNode node = map.get(key);
        if (node == null) {
            DListNode newNode = new DListNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            if (map.size() > capacity) {
                DListNode lastNode = tailDummy.pre;
                map.remove(lastNode.key);
                deleteNode(lastNode);
            }
        } else {
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1,1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);


        // [1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

        System.out.println(lruCache);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */