package stacks_queues;

public class Queues {
    Stack stack_one;
    Stack stack_two;



    public static void main(String[] args) {

    }

    public Queues(){
        stack_one = new Stack();
        stack_two = new Stack();
    }


    public void enqueue(int data) {
        if (!stack_one.isEmpty()) {
            while (!stack_one.isEmpty()){
                stack_two.push(stack_one.pop());
            }
        }
        stack_one.push(data);
        while (!stack_two.isEmpty()) {
            stack_one.push(stack_two.pop());
        }
    }

    public int dequeue() {
        if (!stack_one.isEmpty()) {
           return stack_one.pop();
        }
        return -1;
    }

}
