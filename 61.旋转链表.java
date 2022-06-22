/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int length = 0;
        ListNode tail = null;
        for(ListNode p = head; p != null; p = p.next) {
            tail = p;
            length++;
        }
        k = k%length;
        int move = length - k - 1;//move = 3
        ListNode p = head;
        for(int i = 0; i < move; i++){
            p = p.next;
        }
        tail.next = head;
        head = p.next;
        p.next = null;
        return head;

    }
}
// @lc code=end

