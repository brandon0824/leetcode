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

        for(int sublen = 1; sublen < length; sublen <<= 1){
            ListNode pre = dummyNode;
            ListNode cur = dummyNode.next;
            while(cur != null){
                ListNode head_1 = cur;
                for(int i = 1; i < sublen && cur != null && cur.next != null; i++){
                    cur = cur.next;
                }

                ListNode head_2 = cur.next;
                cur.next = null;
                cur = head_2;
                for(int i = 1; i < sublen && cur != null && cur.next != null; i++){
                    cur = cur.next;
                }

                ListNode next = null;
                if(cur != null){
                    next = cur.next;
                    cur.next = null;
                }

                ListNode merged = mergeTwoList(head_1, head_2);
                pre.next = merged;
                while(pre.next != null){
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummyNode.next;
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

