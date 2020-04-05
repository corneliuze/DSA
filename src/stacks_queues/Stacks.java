package stacks_queues;

import java.util.Stack;

public class Stacks {

    public String isBalancedBrackets(String string) {
        String yes = "YES";
        String no = "NO";
        char[] s = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '{' || s[i] == '[' || s[i] == '(') {
                stack.push(s[i]);
            } else if ((s[i] == '}' || s[i] == ']' || s[i] == ')')) {
                if (stack.isEmpty()) {
                    return no;
                } else if (!isMatch(stack.pop(), s[i])) {
                    return no;
                }
            }
        }
        if (stack.isEmpty()) {
            return yes;
        } else {
            return no;
        }
    }

    public boolean isMatch(char c, char cc) {
        if (c == '{' && cc == '}') {
            return true;
        } else if (c == '[' && cc == ']') {
            return true;
        } else if (c == '(' && cc == ')') {
            return true;
        } else {
            return false;
        }
    }

    public int isTheSameHeight(int[] h1, int[] h2, int[] h3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        for (int i = h1.length - 1; i > 0; i--) {
            stack1.push(h1[i]);
            sum1 += h1[i];
        }
        for (int i = h2.length - 1; i > 0; i--) {
            stack2.push(h2[i]);
            stack2.push(2);
            stack2.push(3);
            sum2 += h2[i];
        }
        for (int i = h3.length - 1; i > 0; i--) {
            stack3.push(h3[i]);
            sum3 += h3[i];
        }
        while (true) {
            if (sum1 == sum3 && sum2 == sum3) {
                break;
            } else if (sum1 > sum2) {
                sum1 -= stack1.pop();
            } else if (sum1 > sum3) {
                sum1 -= stack1.pop();
            } else if (sum2 > sum1) {
                sum2 -= stack2.pop();
            } else if (sum2 > sum3) {
                sum2 -= stack2.pop();
            } else if (sum3 > sum1) {
                sum3 -= stack3.pop();
            } else if (sum3 > sum2) {
                sum3 -= stack3.pop();
            }
        }
        return sum1;

    }
}
