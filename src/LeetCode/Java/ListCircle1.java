package LeetCode.Java;

/* Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ListCircle1 {
    public boolean hasCycle(ListNode head) {
        if( head == null || head.next == null ){
            return false;
        }
        // 快指针fp和慢指针sp，
        ListNode fp = head, sp = head;
        while( fp != null && fp.next != null){
            sp = sp.next;
            fp = fp.next.next;
            if( fp == sp ){
                return true;
            }
        }
        return false;
    }
}
