package linkedlists;

/**
 * @Author Falaye Iyanuoluwa
 * 2020/02/03
 * @description : simple_linked_list_problems
 * @url :
 */

public class LinkedLists {

    /**
     * @Insert Node to the head of a linked List
     */

    Node head;

    LinkedLists(Node head) {
        this.head = head;
    }

    public Node insertNodeAtTheHead(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }

    public Node insertNodeAtTheTail(int data) {
        Node node = new Node(data);
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        return head;
    }


    public void toStrings() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
    }

    public Node insertNodeAtAPosition(Node head, int data, int position) {
        Node node = new Node(data);
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            Node prev = null;
            int i = 0;

            /**
             * if the list is not empty yet, keep moving
             */
            while (current != null && i < position) {
                prev = current;
                current = current.next;
                i++;
            }
            /**
             *here we are at the node before the position specified
             */
            node.next = prev.next;
            prev.next = node;
        }
        return head;
    }

    public Node deleteNodeAtAPosition(Node head, int position) {
        if (position == 0) {
            return head.next;
        }
        int counter = 0;
        Node prev = null, current = head;
        while (current != null && counter < position) {
            prev = current;
            current = current.next;
            counter++;
        }
        prev.next = current.next;
        current.next = null;
        return head;
    }


    /**
     * 24 april, 2020.
     * Detect a cycle in a linked list
     * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/
     */
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node curr = head;
        Node slow = curr;
        Node fast = curr.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = curr.next;
            fast = curr.next.next;
        }
        return true;
    }

    /**
     * 24 april, 2020.
     * detect the start of the cycle
     * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
     *
     * @param head
     * @return
     */

    public Node getStartOfCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    /**
     * 25 april, 2020.
     * Given a linked list, remove the n-th node from the end of list and return its head.
     * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
     *
     * @param head
     * @param n
     * @return
     */

    public Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy, second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 25 april, 2020.
     *
     * @param  * @param n
     *             * @return
     * @reverse the elements of a  linkedlist iteration
     */

    public Node reverseList() {
        Node current = head, next = null, prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    /**
     * 25 april, 2020.
     *
     * @param head *      * @param n
     *             *      * @return
     *             *
     * @reverse the elements of a  linkedlist  recursion
     */
    public Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temps = head.next;
        Node lastNode = reverseLinkedList(head.next);
        Node temp = head.next;
        Node tempr = head;
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

    public Node reverseLinkedListHelper(){
        Node heads = head;
        return reverseLinkedList(heads);
    }

    private boolean isPalindrome(Node head) {
        Node cur = head;
        int count = 0;
        Node pre;
        while(cur != null)
        {
            count++;
            cur = cur.next;
        }
        int n = count/2;
        cur = head;
        pre = null;
        int i=0;
        while(i<n)
        {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            i++;
        }
        Node h2 = pre;
        if(count % 2 != 0)
            cur = cur.next;
        i=0;
        while(i<n)
        {
            if(h2.data != cur.data )
                return false;
            h2 = h2.next;
            cur = cur.next;
            i++;
        }
        return true;
    }


    public boolean palindromeHelper(){
        return isPalindrome(this.head);
    }
    // TODO
    /* read on doubly linked list
     * reverse doubly linked list
     * https://javarevisited.blogspot.com/2017/07/top-10-linked-list-coding-questions-and.html
     * https://www.geeksforgeeks.org/top-20-linked-list-interview-question/
     */
}
