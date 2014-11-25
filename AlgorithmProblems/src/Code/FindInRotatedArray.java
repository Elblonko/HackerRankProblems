/**
 * Created by elblonko on 11/10/14.
 */

/*
Given a sorted array of n integers that has been rotated an unknown number of
times, give an O(log n) algorithm that finds an element in the array. You may assume
that the array was originally sorted in increasing order.
EXAMPLE:
Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
Output: 8 (the index of 5 in the array)
 */
public class FindInRotatedArray {


    public static int find(int[] arr, int search){
        int curr = 0;

        //Binary search variables
        int start = 0;
        int length = arr.length -1;

        while (start <= length){

            int mid = (start + length) /2;

            //found
            if(arr[mid] == search){
                return mid;
            }

            //check to know if current portion of array is rotated start < mid
            else if(arr[start] <= arr[mid] ){

                //if greater than mid move forward
                if ( search > arr[mid]){
                    start = mid +1;
                }
                //we know array is increasing from start to mid (most likely)
                // if item is greater than start and not greater than mid
                else if (search >= arr[start]){
                    length = mid -1;
                }
                // else move forward
                else{
                    start = mid +1;
                }

            }


            else if(search < arr[mid] ){
                length = mid -1;
            }
            //if item is less than the las item move forward
            else if(search <= arr[length] ){
                start = mid +1;
            }
            //else move backward
            else{
                length = mid -1;
            }

        }

        //not found
        return -1;
    }


    public static void main (String args[]){
        int[] a = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        for (int x : a) {
            System.out.println(x + " is at position " + find(a, x));
        }


    }
}
