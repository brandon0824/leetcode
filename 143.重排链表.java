/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode midnode = middleNode(head);
        
        ListNode p1 = head;
        ListNode reverse_node = midnode.next;

        midnode.next = null;
        
        ListNode p2 = reverse(reverse_node);
        mergeTwoLists(p1, p2);
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head, pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode middleNode(ListNode head){
        int cnt = 0;
        ListNode node = head;
        while(node != null){
            cnt++;
            node = node.next;
        }
        int findnode = cnt / 2;
        node = head;
        for(int i = 0; i < findnode; i++){
            node = node.next;
        }
        return node;
    }

    public void mergeTwoLists(ListNode p1, ListNode p2){
        ListNode p1_tmp, p2_tmp;
        while(p1 != null && p2 != null){
            p1_tmp = p1.next;
            p2_tmp = p2.next;
            p1.next = p2;
            p1 = p1_tmp;
            p2.next = p1;
            p2 = p2_tmp;
        }
    }
}
// @lc code=end

