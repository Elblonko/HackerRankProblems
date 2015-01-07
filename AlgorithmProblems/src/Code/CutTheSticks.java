import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by elblonko on 1/6/15.
 *
 * Adding text to test the commit.
 * ou are given N sticks, where each stick is of positive integral length. A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.

 Suppose we have 6 sticks of length

 5 4 4 2 2 8
 then in one cut operation we make a cut of length 2 from each of the 6 sticks. For next cut operation 4 sticks are left (of non-zero length), whose length are

 3 2 2 6
 Above step is repeated till no sticks are left.

 Given length of N sticks, print the number of sticks that are cut in subsequent cut operations.

 Input Format
 The first line contains a single integer N.
 The next line contains N integers: a0, a1,...aN-1 separated by space, where ai represents the length of ith stick.

 Output Format
 For each operation, print the number of sticks that are cut in separate line.

 Constraints
 1 ≤ N ≤ 1000
 1 ≤ ai ≤ 1000
 */
public class CutTheSticks {


    /*
    Strategy:
    Given the number of sticks and array of sticks:
    Find at each step how many sticks are left to be cut:
    Example:
    8
    5 4 4 2 2 8
     */
    public static void main(String args[]){

        boolean DEBUG = false;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        if(DEBUG){
            System.out.println("Printing input array bags");
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        int numCut = 0;
        int start = 0;
        while(true) {
            if(start >= arr.length)
                break;
            int min = arr[start];
            for (int i = start; i < N; i++) {

                arr[i] = arr[i] - min;
                if(DEBUG){
                    System.out.println("i: " + i +" arr[i]: " + arr[i] + " Start: " + start);
                }
                if (arr[i] == 0) {
                    start = i + 1;
                }
                numCut++;
            }
            System.out.println(numCut);
            numCut = 0;
        }
    }
}
