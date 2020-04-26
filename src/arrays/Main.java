package arrays;

import recursiontheory.RecursionSolution;
import stacks_queues.Stacks;

public class Main {
    public static void main(String[] args) {
        Array a = new Array();
        Stacks s = new Stacks();
        int[] p = a.twoSumSortedArray(new int[]{2, 7, 11, 15}, 9);
        int[] input = new int[]{4,2,2,7,8,1,2,8,10};
        int newExample = a.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        int removeDuplicates = a.removeElement(new int[] {2}, 3);
        int targetSum = 8;
        int dd  = a.smallestSubArray( targetSum, input);
        String str = "geg";


        RecursionSolution recursionSolution = new RecursionSolution();
        System.out.println(recursionSolution.calculateFibonacci(6));
        recursionSolution.isPalindrome(str.toCharArray());
        recursionSolution.reverseStrings(str.toCharArray());
        recursionSolution.printReverse(str.toCharArray());

        int q = a.hourGlassSum(new int[][]{{-9, -9, -9, 1, 1, 1}, {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3}, {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0}, {0, 0, 1, 2, 4, 0}});

        int[] res = a.leftRotation(new int[]{1, 2, 3, 4, 5, 6}, 3);

        int ans = s.isTheSameHeight(new int[]{1}, new int[]{1}, new int[]{1});

        System.out.println("result is " + " " + removeDuplicates);
    }

}
