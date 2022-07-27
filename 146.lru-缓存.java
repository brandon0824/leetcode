import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    class Node{
        public int key, val;
        public Node next, prev;
        public Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList{
        private Node head, tail;
        private int size;
        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 链表尾部添加节点
        public void addLast(Node x){
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        // 删除链表中的节点x
        public void remove(Node x){
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 删除链表中第一个节点
        public Node removeFirst(){
            if(head.next == tail) return null;
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size(){
            return size;
        }
    }
    
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    // 将某个key提升为最近使用的
    private void makeRecently(int key){
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    // 添加最近使用的元素
    private void addRecently(int key, int val){
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);        
    }

    // 删除某个key
    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    // 删除最久未使用的元素
    private void removeLeastRecently(){
        Node removeNode = cache.removeFirst();
        int deleteKey = removeNode.key;
        map.remove(deleteKey);

    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        makeRecently(key);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key, value);
            return;
        }

        if(cap == cache.size()){
            removeLeastRecently();
        }

        addRecently(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

