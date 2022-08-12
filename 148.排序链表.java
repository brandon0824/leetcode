/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        for(int sublen = 1; sublen < length; sublen *= 2){
            
        }
    }

    public ListNode mergeTwoList(ListNode p1, ListNode p2){
        // 合并两个有序链表
        ListNode dummyNode = new ListNode(0);
        ListNode temp = dummyNode, temp1 = p1, temp2 = p2;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 != null){
            temp.next = temp1;
        }else if(temp2 != null){
            temp.next = temp2;
        }
        return dummyNode.next;
    }
}
// @lc code=end

