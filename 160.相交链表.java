/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA; 
        }
        return p1;
    }
}
// @lc code=end

