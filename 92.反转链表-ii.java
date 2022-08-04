/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // pre走到left的前一个结点
        ListNode pre = dummyNode;
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }

        // rightNode走到right结点
        ListNode rightNode = pre;
        for(int i = 0; i < right - left + 1; i++){
            rightNode = rightNode.next;
        }

        // 切割出一个子链表并反转
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        reverseLinkedList(leftNode);

        // 重新接上这一段
        pre.next = rightNode;
        leftNode.next = cur;
        return dummyNode.next;

    }

    public void reverseLinkedList(ListNode head){
        ListNode cur = head, pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }
}
// @lc code=end

