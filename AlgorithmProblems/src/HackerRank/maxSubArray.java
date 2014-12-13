import java.util.Scanner;

/**
 * Created by elblonko on 11/28/14.
 */

//check for commit

public class maxSubArray {


//    public static int max_subarray(int[] arr){
//        int current_sum = 0;
//        int current_index = -1;
//        int best_sum = 0;
//        int best_start_index = -1;
//        int best_end_index = -1;
//
//        for (int i = 0; i < arr.length; i++){
//
//            int currVal = current_sum + arr[i];
//
//            if (currVal > 0){
//                if (current_sum == 0){
//                    current_index = i;
//                }
//                current_sum = currVal;
//            }
//            else{
//                current_sum = 0;
//            }
//
//            if( current_sum > best_sum){
//                best_sum = current_sum;
//                best_start_index = current_index;
//                best_end_index = i;
//            }
//        }
//
//        return best_sum;
//    }


    public static int maxSubArr(int [] arr){
        int max_here = 0;
        int max_so_far = 0;

        for (int i = 0; i < arr.length ; i++){
            max_here = max_here + arr[i];
            if( i == 0){
                max_here = arr[i];
            }
//            if(max_here < 0){
//                max_here = 0;
//            }
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

    }
}
