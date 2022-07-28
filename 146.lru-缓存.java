import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {

    class DlinkedNode{
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;
        public DlinkedNode(){}
        public DlinkedNode(int _key, int _value){
            key = _key;
            value = _value;
        }
    }

    public HashMap<Integer, DlinkedNode> cache = new HashMap<Integer, DlinkedNode>();
    public int size;
    public int capacity;
    public DlinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }


    // 添加node节点到头部
    public void addtoHead(DlinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除节点node
    public void removeNode(DlinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 当get()访问一个节点之后移动到队尾
    public void movetoHead(DlinkedNode node){
        removeNode(node);
        addtoHead(node);
    }

    // 移出队尾的节点
    public DlinkedNode removeTail(){
        DlinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
    
    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if(node == null) return -1;
        movetoHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);
        if(node == null){
            DlinkedNode newnode = new DlinkedNode(key, value);
            cache.put(key, newnode);
            addtoHead(newnode);
            size++;
            if(size > capacity){
                DlinkedNode deletenode = removeTail();
                cache.remove(deletenode.key);
                size--;
            }
        }
        else{
            node.value = value;
            movetoHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

