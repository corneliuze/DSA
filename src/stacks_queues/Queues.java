package stacks_queues;

public class Queues {
    Stack stack_one;
    Stack stack_two;
    int[] arr;
    int front;
    int rear;


    public static void main(String[] args) {
        Queues queues = new Queues();
        queues.enqueue(1);
        System.out.println(queues.dequeue());
        queues.enqueue(3);
        queues.enqueue(2);
        queues.enqueue(1);
        System.out.println(queues.dequeue());
        System.out.println(queues.dequeue());
    }

    // using two stacks
    public Queues() {
        stack_one = new Stack();
        stack_two = new Stack();
        arr = new int[5];
        front = rear = 0;
    }

    public void _enqueue(int data) {
        if (!stack_one.isEmpty()) {
            while (!stack_one.isEmpty()) {
                stack_two.push(stack_one.pop());
            }
        }
        stack_one.push(data);
        while (!stack_two.isEmpty()) {
            stack_one.push(stack_two.pop());
        }
    }

    public int _dequeue() {
        if (!stack_one.isEmpty()) {
            return stack_one.pop();
        }
        return -1;
    }


    // USING ARRAYS

    public void enqueue(int data) {
        if (rear == arr.length - 1) {
            System.out.println("Queue is full");
        }
        arr[rear++] = data;

    }

    public int dequeue() {
        if (rear != front) {
            return arr[front++];
        }
        return -1;
    }
}
