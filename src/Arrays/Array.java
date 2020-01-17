package Arrays;
/**
 * @Author Falaye Iyanuoluwa
 * 2020/01/1
 * @url : https://www.hackerrank.com/challenges/simple-array-sum/problem
 * */

public class Array {

    /**
     * Simple Array Sum
     * */

    public int addArray(int[] array){
        int sum = 0;
        for (int i = 0; i< array.length; i++){
            sum +=  array[i];
        }
        return sum;
    }

}
