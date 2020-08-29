/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k == 0){
            return null;
        }

        // 保证k小于链表长度
        int length = 0;
        ListNode count = head;
        while(count != null){
            count = count.next;
            length++;
        }
        if(k > length){
            return null;
        }

        // 双指针移动
        ListNode p1 = head;
        while(k-- > 0 && p1 != null){
            p1 = p1.next;
        }
        ListNode p2 = head;
        
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}