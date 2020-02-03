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
 * */

public Node  insertNodeAtTheHead(Node head, int data){
    Node node = new Node(data);
    if (head != null) {
        node.next = head;
    }
    head = node;
    return head;
}
public Node insertNodeAtTheTail(Node head, int data){
    Node node = new Node(data);
    node.next = null;
    if(head == null){
        head = node;

    }else{
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = node;
    }
    return head;
}
}
