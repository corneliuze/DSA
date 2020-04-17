package hashcode;

import java.util.HashMap;
import java.util.HashSet;

public class RecursionSolution {

    public RecursionSolution() {

    }

    public void printReverse(char[] str) {
        helper(0, str);
    }

    public void helper(int index, char[] str) {
        if (str == null || index >= str.length) {
            return;
        }
        System.out.print(index);
        helper(index + 1, str);
        System.out.println(str[index]);
    }

    private void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char tmp = s[left];
        System.out.print("left 1" + left);
        s[left++] = s[right];
        System.out.print("right  " + right);
        System.out.print("left 2" + left);
        s[right--] = tmp;
        System.out.print("right 2 " + right);
        helper(s, left, right);
    }

    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }


    public void reverseStrings(char[] s) {
        helperRecursion(0, s.length - 1, s);
    }

    private void helperRecursion(int left, int right, char[] s) {
        if (left >= right) return;
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        helperRecursion(left, right, s);
        System.out.println(s);
    }


    public void isPalindrome(char[] s) {
        if (palidromeHelper(s, 0, s.length - 1)) {
            System.out.print("yes");
        } else {
            System.out.print("nah");
        }
    }

    private boolean palidromeHelper(char[] s, int front, int end) {

        //--to check if it is one character
        if (s.length == 1) return true;

        //to check if the characters are different
        if (s[front] != s[end]) return false;

        // +1 because of odd number strings
        if (front < end + 1) {
            return palidromeHelper(s, front + 1, end - 1);
        }
        return true;
    }

    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public Integer calculateFibonacci(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result;
        if (n < 2) {
            result = n;
        } else {
            result = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
        cache.put(n, result);
        return result;
    }

}


