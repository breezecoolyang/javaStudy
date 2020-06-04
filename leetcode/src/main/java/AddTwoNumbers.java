 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
        {
            return l2;
        }
        if(l2 == null)
        {
            return l1;
        }
        ListNode aList = l1;
        ListNode bList = l2;
        int more = 0;
        ListNode head = null;
        ListNode current = null;
        int value = 0;
        while (aList!= null && bList!=null)
        {
            value = (aList.val + bList.val + more) %10;
            more = (aList.val + bList.val + more) / 10;
            if(head == null)
            {
                head = new ListNode(value);
                current  = head;
            }
            else {
                ListNode node = new ListNode(value);
                current.next = node;
                current = node;
            }
            aList = aList.next;
            bList = bList.next;
        }
        if(bList != null)
        {
            while (bList != null) {
                value = (bList.val + more) % 10;
                more = (bList.val + more) / 10;
                ListNode node = new ListNode(value);
                current.next = node;
                current = node;
                bList = bList.next;
            }
        }
        if(aList!=null)
        {
            while (aList != null) {
                value = (aList.val + more) % 10;
                more = (aList.val + more) / 10;
                ListNode node = new ListNode(value);
                current.next = node;
                current = node;
                aList = aList.next;
            }
        }
        if(more !=0)
        {
            ListNode node = new ListNode(more);
            current.next = node;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode two = new ListNode(9);
//        ListNode four = new ListNode(4);
//        ListNode three = new ListNode(9);
//        two.next = four;
//        four.next = three;

        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode newFour = new ListNode(4);
        five.next = six;
        six.next = newFour;

        ListNode result = new AddTwoNumbers().addTwoNumbers(two, five);
        while (result != null)
        {
            System.out.printf("%d->", result.val);
            result = result.next;
        }
    }
}
