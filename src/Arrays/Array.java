package Arrays;

import java.util.Arrays;

/**
 * @Author Falaye Iyanuoluwa
 * 2020/01/17
 * @description : simple_arrays_problems
 * @url : https://www.hackerrank.com/challenges/simple-array-sum/problem
 */

public class Array {

    /**
     * Simple Array Sum
     * 2020/01/17
     */

    public int addArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * @Left Rotation
     * 2020/01/18
     * */

    public int[] leftRotation(int[] array){
        int a = array.length;
        int d = 3;
        Arrays.copyOfRange(array, 0, d);
        int[] tempArray = new int[array.length];
        int j = 0;
        for(int i = d; i < array.length; i++ ){
            tempArray[j] = array[i];
            j++;
        }
        




    }

    public void hfhf(String p){
        p.split("[A-Za-z !,?._'@]+");


    }

    /**
     * @2D Array - DS
     * 2020/01/20
     */

    public int hourGlassSum(int[][] arr) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < 6 ; j++) {
                sum += (arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

}
