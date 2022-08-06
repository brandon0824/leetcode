/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode pre = head, cur = dummyNode;
        for(int i = 0; i < n; i++){
            pre = pre.next;
        }
        while(pre != null){
            pre = pre.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummyNode.next;
        return ans;
    }
}

// @lc code=end

