/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode p1 = head.next;
        ListNode p2 = head.next.next;
        while(p1 != p2){
            if(p2 == null || p2.next == null){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return true;
    }
}
// @lc code=end

