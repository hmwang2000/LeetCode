package LeetCode.Java;

/*
Given a linked list, return the node where the cycle begins.
If there is no cycle, return null.
Example
Given -21->10->4->5, tail connects to node index 1，return 10
Challenge
Follow up:
Can you solve it without using extra space?
*/

/*
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
*/
public class ListCircle2 {
    public ListNode detectCycle( ListNode head ) {
        if( head == null || head.next == null ){
            return null;
        }
        // 快指针fp和慢指针sp，
        ListNode fp = head, sp = head;
        while( fp != null && fp.next != null){
            sp = sp.next;
            fp = fp.next.next;
            //此处应该用fp == sp ，而不能用fp.equals(sp) 因为链表为1 2 的时候容易
            //抛出异常
            if( fp == sp ){  //说明有环
                break;
            }
        }
        //System.out.println( fp.val + "   "+ sp.val );
        if( fp == null || fp.next == null ){
            return null;
        }
        //说明有环，求环的起始节点
        sp = head;
        while( fp != sp ){
            sp = sp.next;
            fp = fp.next;
        }
        return sp;
    }
}
