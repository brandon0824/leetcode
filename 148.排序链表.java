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
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail){
        if(head == null) return head;
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = mergeTwoList(list1, list2);
        return sorted;
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

