package LeetCode.Java;

/*
    Given a linked list, remove the nth node from the end of list and return its head.

    For example,

        Given linked list: 1->2->3->4->5, and n = 2.

        After removing the second node from the end, the linked list becomes 1->2->3->5.

    Note:
    Given n will always be valid.
    Try to do this in one pass.

 */
/*
由于只允许一次遍历，所以我们不能用一次完整的遍历来统计链表中元素的个数，而是遍历到对应位置就应该移除了。
那么我们需要用两个指针来帮助我们解题，fast 和 slow 指针。首先 fast 指针先向前走 n 步，如果此时 fast
指向空，说明 n 为链表的长度，则需要移除的为首元素，那么此时我们返回 head->next 即可; 如果 fast->next
存在，我们再继续往下走，此时 slow 指针也跟着走，直到 fast 指向最后一个元素时停止，此时 slow 指向要移除
元素的前一个元素，我们再修改指针跳过需要移除的元素即可。
 */
public class RemoveNth {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=0; i<n; i++)   {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }
        //Move fast to the end, maintaining the gap
//        while(fast != null) {
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        int numNode = 10;
        ListNode node = new ListNode(numNode);
        ListNode head = node;
        int x=numNode-1;
        while (x>0){
            node = new ListNode(x);
            node.next = head;
            head = node;
            x--;
        }

        ListNode cur = head;
        while (cur != null){
            System.out.print("#");
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.print("null");
        System.out.print("\n");

        RemoveNth rn = new RemoveNth();
        cur = rn.removeNthFromEnd(head,10);
        while (cur != null){
            System.out.print("#");
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.print("null");
    }
}
