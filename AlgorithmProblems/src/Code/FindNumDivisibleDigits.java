import java.util.Scanner;

/**
 * Created by elblonko on 11/24/14.
 */
public class FindNumDivisibleDigits {


    //Given a number N find the numbers in N that cleanly divide N
    public static int numDivisors(int num){

        //extract the digits of N in a loop
        int counter = 0;
        int currNum = num;
        while (currNum > 0){
            int divisor = currNum % 10;
            currNum = currNum / 10;

            //handle the 0 case
            if (divisor == 0){
                continue;
            }
            else if( (num%divisor == 0)){
                counter++;
            }

        }

        return counter;
    }




    public static void main(String args[]){

        /*
        System.out.println(numDivisors(12));
        System.out.println(numDivisors(1012));
        */

        Scanner finput = new Scanner(System.in);

        //get num inputs to expect
        int numInputs = finput.nextInt();

        for( int i = 0; i < numInputs; i++){
            System.out.println(numDivisors( (finput.nextInt()) ) );
        }


    }
}
