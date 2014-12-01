import java.util.Scanner;

/**
 * Created by elblonko on 11/28/14.
 */

//check for commit

public class maxSubArray {


    public static int maxSubArr(int [] arr){
        int max_here = 0;
        int max_so_far = 0;
        for (int i = 0; i < arr.length ; i++){
            max_here = max_here + arr[i];
            if(max_here < 0){
                max_here = 0;
            }
            if(max_so_far < max_here){
                max_so_far = max_here;
            }

        }
        return max_so_far;
    }

    public static int maxSum(int[] arr){

        int sum = 0;
        for (int curr : arr){
            if(curr > 0){
                sum = sum + curr;
            }
        }
        return sum;
    }


    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for(int t = 0; t < numTests; t++){
            int sizeArr = sc.nextInt();
            //create array
            int[] arr = new int[sizeArr];

            for(int i = 0; i < sizeArr; i++){
                arr[i] = sc.nextInt();
            }
            System.out.print(maxSubArr(arr) + " ");
            System.out.print(maxSum(arr));

        }
        System.out.println();

        System.out.println();
    }
}
