package linkedlists;

public class MainNode {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4  = new Node(4);
        Node node5 = new Node(3);
        Node node6 = new Node(2);
        Node node7 = new Node(1);




        LinkedLists linkedLists = new LinkedLists(node1);
        linkedLists.insertNodeAtTheTail(node2.data);
        linkedLists.insertNodeAtTheTail(node3.data);
        linkedLists.insertNodeAtTheTail(node4.data);
        linkedLists.insertNodeAtTheTail(node5.data);
        linkedLists.insertNodeAtTheTail(node6.data);
        linkedLists.insertNodeAtTheTail(node7.data);

        boolean result = linkedLists.palindromeHelper();
       System.out.println(result);

        linkedLists.toStrings();


        Node node = linkedLists.reverseLinkedListHelper();
       System.out.println("   ");
       System.out.println(node.data + " -> " + node.next.data + " -> " + node.next.next.data + " -> " + node.next.next.next.data);


    }
}
