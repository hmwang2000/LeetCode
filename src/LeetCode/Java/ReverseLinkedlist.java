package LeetCode.Java;

/*
Reverse a singly linked list.

Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedlist {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        /*
        pre
        head  cur
        1 ->  2 -> 3 -> 4 -> 5 -> null
         */
        ListNode cur = head.next;
        ListNode pre = head;

        /*
        pre
        head    cur
        1 -> 3   2 -> 3 -> 4 -> 5 -> null

        pre
        head    cur
        1 -> 3   2 -> 1  3 -> 4 -> 5 -> null

        head
        cur  pre
        2 -> 1 -> 3 -> 4 -> 5 -> null

        head
             pre  cur
        2 -> 1 -> 3 -> 4 -> 5 -> null
         */
        while (cur != null){
            pre.next = cur.next;
            cur.next = head;
            head = cur;
            cur = pre.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        for(int i = 1; i < 20; i++){
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = node;
        }
        print(head);
        System.out.print("\n");

        ReverseLinkedlist rl = new ReverseLinkedlist();
        head = rl.reverseList(head);
        print(head);
    }

    static void print(ListNode head){
        while(head != null){
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
        System.out.print("NULL");
    }
}
