import java.util.Scanner;

/**
 * Created by elblonko on 11/28/14.
 */
public class fillingJars {


    public static void fillint (int jarA, int jarB, int numFill, int arr[]){

        for (int i = jarA -1; i <= jarB -1; i++ )
            arr[i] = arr[i] + numFill;

    }

    public static long avgArray (int arr[]){

        long sum = 0;

        for( int curr : arr){
            sum = curr + sum;
        }

        return sum / arr.length;
    }




    public static void main(String args[]){

        /*
        int arr[] = new int[]{0,0,0,0,0};

        fillint(1,2,100, arr );
        for (int curr : arr){
            System.out.print(curr + " ");
        }
        System.out.println();
        fillint(2,5,100,arr);
        for (int curr : arr){
            System.out.print(curr+ " ");
        }
        System.out.println();
        fillint(3,4,100,arr);
        for (int curr : arr){
            System.out.print(curr+ " ");
        }
        System.out.println();

        System.out.println(avgArray(arr));
        */

        Scanner sc = new Scanner(System.in);

        int numJars = sc.nextInt();
        int[] arr = new int[numJars];
        int numInputs = sc.nextInt();

        for(int i = 0; i < numInputs; i++){
            int jarA = sc.nextInt();
            int jarB = sc.nextInt();
            int fillNum = sc.nextInt();

            fillint(jarA,jarB,fillNum,arr);
        }

        System.out.println(avgArray(arr));


    }
}
