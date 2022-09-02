/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode end = dummyNode;
        while(end != null) {
            for(int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if(end == null) break;
            ListNode start = pre.next;
            ListNode nextnode = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = nextnode;
            pre = start;
            end = pre;
        }
        ListNode node_remain = pre.next;
        pre.next = null;
        pre.next = reverse(node_remain);
        return dummyNode.next;
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
}
// @lc code=end

