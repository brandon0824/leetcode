/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        copyNode(head);
        randomDirect(head);
        return reList(head);
    }

    private void copyNode(Node head){
        while(head != null){
            Node nextNode = head.next;
            Node newNode = new Node(head.val);
            head.next = newNode;
            newNode.next = nextNode;
            head = nextNode;
        }
    }

    private void randomDirect(Node head){
        while(head != null){
            Node nextNode = head.next;
            if(head.random != null){
                Node direct = head.random;
                nextNode.random = direct.next;
            }
            head = nextNode.next;
        }
    }

    private Node reList(Node head){
        Node newNode = head.next;
        Node newHead = newNode;
        head.next = newNode.next;
        head = head.next;
        while(head != null){
            newNode.next = head.next;
            head.next = head.next.next;
            head = head.next;
            newNode = newNode.next;
        }
        return newHead;
    }

}
// @lc code=end

