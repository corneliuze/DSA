package arrays;

import java.util.*;

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
     */

    public int[] leftRotation(int[] array, int d) {
        int[] trunArray = Arrays.copyOfRange(array, 0, d);
        int[] tempArray = new int[array.length];
        int j = 0;
        for (int i = d; i < array.length; i++) {
            tempArray[j] = array[i];
            j++;
        }
        for (int i : trunArray) {
            tempArray[j++] = i;
        }
        return tempArray;
    }

    public void hfhf(String p) {
        p.split("[A-Za-z !,?._'@]+");

    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for(String s : strs) {
            int value = 0;
            for(int i = 0; i < s.length(); i++){
                value += s.charAt(i);
            }
            if(!map.containsKey(value)) map.put(value, new ArrayList<>());
            map.get(value).add(s);
        }
        return new ArrayList(map.values());

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int n = 0; n < nums2.length; n++) {
            boolean t =  map.containsKey(nums2[n]);
            if (map.containsKey(nums2[n])) {
               int kk = map.get(nums2[n]);
                if (map.get(nums2[n]) > 0) {
                    list.add(nums2[n]);
                    map.put(nums2[n], map.get(nums1[n]) - 1);
                    int kkk = map.get(nums2[n]);

                }
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;

    }


    public boolean isValidSudoku(String[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) // check base case
            return false;
        HashSet<String> hs = new HashSet<>();

        // for each 3x3 matrix

        for(int block=0;block<9;block++) // will iterate 9 times
        {
            for(int i=(block/3)*3;i<((block/3)*3) + 3;i++) // find the each blocks starting & ending row index
            {
                for(int j=(block%3)*3;j<((block%3)*3) + 3;j++) // find the each blocks starting & ending column index
                {
                    if(board[i][j] != ".")
                    {
                        if(hs.add(board[i][j]) == false)
                        {
                            return false;
                        }
                    }
                }
            }
            hs.clear();
        }

        // For row
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j] != ".") // if we find '.' the ignore this
                {
                    if(hs.add(board[i][j]) == false) // Else check the character is already present or not(in set)
                    {
                        return false;
                    }
                }
            }
            hs.clear();
        }
        // For column
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[j][i] != ".")
                {
                    if(hs.add(board[j][i]) == false)
                    {
                        return false;
                    }
                }
            }
            hs.clear();
        }


        return true;
    }





    /**
     * @2D Array - DS
     * 2020/01/20
     */

    public int hourGlassSum(int[][] arr) {
        int maxSum = 0, sum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                sum = getAnIntFromHourGlass(arr, i, j);
                if (sum > maxSum) maxSum = sum;
            }
        }
        return maxSum;
    }

    private int getAnIntFromHourGlass(int[][] arr, int i, int j) {
        return arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1]
                + arr[i][j]
                + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
    }


    /**
     * 16th April, 2020
     * Two Sum
     * https://leetcode.com/problems/two-sum/
     */

    public int[] twoSum(int[] nums, int target) {
        int[] resultIndex = new int[2];
        HashMap<Integer, Integer> numberHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numberHashMap.containsKey(complement)) {
                resultIndex[0] = numberHashMap.get(complement);
                resultIndex[1] = i;
                break;
            }
            numberHashMap.put(nums[i], i);
        }
        return resultIndex;
    }


    /**
     * 16th April, 2020
     * Two Sum II - Input array is sorted
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     */

    public int[] twoSumSortedArray(int[] nums, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (target == sum) {
                result[0] = start;
                result[1] = end;
                break;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    /**
     * 16th April, 2020
     * 3sums or sliding window problem
     * https://leetcode.com/problems/3sum/
     */

//    public List<List<Integer>> threeSum(int[] nums) {
//
//    }

    /*** -------------------------------Sliding Window Algorithm--------------------------------****/

    /**
     * smallest sub array problem.
     */
    public int smallestSubArray(int targetSum, int[] array) {
        int windowStart = 0;
        int minSubValue = Integer.MAX_VALUE;
        int currentWindowSum = 0;

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            currentWindowSum += array[windowEnd];
            while (currentWindowSum >= targetSum) {
                minSubValue = Math.min(minSubValue, windowEnd - windowStart + 1);
                currentWindowSum -= array[windowStart];
                windowStart++;
            }
        }
        return minSubValue;
    }

    /**
     * max sum of sub array
     */

    public int maxSubArray(int[] array, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currentSumValue = 0;

        for (int i = 0; i < array.length; i++) {
            currentSumValue += array[i];
            if (i >= k - 1) {
                maxValue = Math.max(currentSumValue, maxValue);
                currentSumValue -= array[i - (k - 1)];
            }
        }
        return currentSumValue;
    }

    /**
     * -----------------------End for that day-------------------/
     * <p>
     * /**
     * 17th April, 2020
     * remove element from an array
     * https://leetcode.com/problems/remove-element/
     */

    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val)
                nums[i] = nums[j--];
            else
                i++;
        }
        return j + 1;
    }


    /**
     * 26. Merge Sorted Array
     * https://leetcode.com/problems/merge-sorted-array/
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1 ;

        for(int  i = (m + n - 1); i >= 0; i--) {
            if(index1 < 0) {
                nums1[i] = nums2[i];
            }
            else if (index2 >= 0) {
                nums1[i] = ( nums1[index1] > nums2[index2] ) ? nums1[index1--] : nums2[index2--];
            }
        }
    }


    /**
     * Optimized
     * 26. Remove Duplicates from Sorted Array
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     */

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i+1;
    }



    private void ArrayUtilsSwapMethod(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


        public void duplicateZeros(int[] arr) {
            int possibleDups = 0;
            int length_ = arr.length - 1;

            // Find the number of zeros to be duplicated
            // Stopping when left points beyond the last element in the original array
            // which would be part of the modified array
            for (int left = 0; left <= length_ - possibleDups; left++) {

                // Count the zeros
                if (arr[left] == 0) {

                    // Edge case: This zero can't be duplicated. We have no more space,
                    // as left is pointing to the last element which could be included
                    if (left == length_ - possibleDups) {
                        // For this zero we just copy it without duplication.
                        arr[length_] = 0;
                        length_ -= 1;
                        break;
                    }
                    possibleDups++;
                }
            }

            // Start backwards from the last element which would be part of new array.
            int last = length_ - possibleDups;

           

            // Copy zero twice, and non zero once.
            for (int i = last; i >= 0; i--) {
                if (arr[i] == 0) {
                    arr[i + possibleDups] = 0;
                    possibleDups--;
                    arr[i + possibleDups] = 0;
                } else {
                    arr[i + possibleDups] = arr[i];
                }
            }
        }
}
