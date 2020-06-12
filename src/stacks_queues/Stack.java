package stacks_queues;

public class Stack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.print(stack.peek());
        stack.push(1);
        System.out.print(stack.peek());
        stack.push(2);
        System.out.print(stack.size());
        System.out.print(stack.pop());
        System.out.print(stack.size());
    }

    int MAX = Integer.MAX_VALUE;
    int[] arr;
    int top;

    public Stack() {
        arr = new int[5];
        top = -1;
    }

    public void push(int data) {
        if (top >= arr.length - 1) {
            System.out.println("Stack is full");
        } else {
            arr[++top] = data;
        }
    }

    public int pop() {
        if (top <= -1) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return arr[top--];
        }
    }

    public int size() {
        return top + 1;
    }

    public int peek() {
        if (top <= -1) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return arr[top];
        }
    }
}
