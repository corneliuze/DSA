package linkedlists;

/**
 * @Author Falaye Iyanuoluwa
 * 2020/002/03
 * @description : simple_linked_list_problems
 * @url :
 */

public class LinkedLists {

    /**
     * @Insert Node to the head of a linked List
     */

    public Node insertNodeAtTheHead(Node head, int data) {
        Node node = new Node(data);
        if (head != null) {
            node.next = head;
        }
        head = node;
        return head;
    }

    public Node insertNodeAtTheTail(Node head, int data) {
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
            while (current != null && i < position){
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

//    public Node deleteNodeAtAPosition(Node head, int position){
//
//    }

    //TODO
    /**
     * @reverse the elements of a  linkedlist
     * read on doubly linked list
     * reverse doubly linked list
     * https://javarevisited.blogspot.com/2017/07/top-10-linked-list-coding-questions-and.html
     * https://www.geeksforgeeks.org/top-20-linked-list-interview-question/
     */
}
