class LinkNode {
    public int val;
    public LinkNode next;
    LinkNode(int x)
    {
        this.val = x;
    }
}
public class ReverseLink {

    public LinkNode reverseLink(LinkNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        LinkNode before = null;
        LinkNode pre = head;
        LinkNode cur = head.next;
        while(cur!=null)
        {
            pre.next = before;
            before = pre;
            pre = cur;
            cur = cur.next;
        }
        pre.next=before;
        return pre;
    }

    public LinkNode reverseLinkRecursive(LinkNode current) {
        if(current == null || current.next == null)
        {
            return current;
        }
        // save the next node and disconnect the connection
        LinkNode nextNode = current.next;
        current.next = null;
        // save the current head
        LinkNode curHead = reverseLinkRecursive(nextNode);
        // rebuild the connection
        nextNode.next = current;

        return curHead;
    }

    public static void main(String[] args) {
        LinkNode one = new LinkNode(1);
        LinkNode two = new LinkNode(2);
        LinkNode three = new LinkNode(3);
        LinkNode four = new LinkNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;
        LinkNode head = one;

        System.out.println("before reverse");
        LinkNode print = head;
        while (print!=null) {
            System.out.printf("%d->", print.val);
            print= print.next;
        }
        print = new ReverseLink().reverseLink(head);
        head = print;
        System.out.println("\nafter reverse");

        while (print!=null) {
            System.out.printf("%d->", print.val);
            print= print.next;
        }

        System.out.println("\n after recursive");
        ReverseLink link = new ReverseLink();
        print = link.reverseLinkRecursive(head);
        while (print!=null) {
            System.out.printf("%d->", print.val);
            print= print.next;
        }


    }
}
