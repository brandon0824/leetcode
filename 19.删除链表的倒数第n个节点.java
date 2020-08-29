/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 0){
            return null;
        }

        // 保证n小于链表长度
        int length = 0;
        ListNode pointer = head;
        while(pointer != null){
            pointer = pointer.next;
            length++;
        }
        if(n > length){
            return null;
        }

        // 双指针移动
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode first = pre;
        ListNode second = pre;
        for(int i = 0; i < n+1; i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return pre.next;
        
    }
}
// @lc code=end

