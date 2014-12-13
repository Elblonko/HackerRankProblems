import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Created by elblonko on 11/24/14.
 */

/*

Given a list containing N integers, calculate the XOR_SUM of all the non-empty subsets of the list and print the value of sum % (109 + 7).

XOR operation on a list (or a subset of the list) is defined as the XOR of all the elements present in it.
E.g. XOR of list containing elements {A,B,C} = ((A^B)^C), where ^ represents XOR.

E.g. XOR_SUM of list A having three elements {X1, X2, X3} can be given as follows.
All non-empty subsets will be {X1, X2, X3, (X1,X2), (X2,X3), (X1,X3), (X1,X2,X3)}

XOR_SUM(A) = X1 + X2 + X3 + X1^X2 + X2^X3 + X1^X3 + ((X1^X2)^X3)

Input Format
An integer T, denoting the number of testcases. 2T lines follow.
Each testcase contains two lines, first line will contains an integer N followed by second line containing N integers separated by a single space.

Output Format
T lines, ith line containing the output of the ith testcase.

Constraints
1 <= T <= 5
1 <= N <= 105
0 <= A[i] <= 109

Sample Input #00

1
3
1 2 3
Sample Output #00

12
Explanation
The given case will have 7 non-empty subsets whose XOR is given below
1 = 1
2 = 2
3 = 3
1^2 = 3
2^3 = 1
3^1 = 2
1^2^3 = 0
So sum of all such XORs is 12.
 */

 //Need to return the sum of the powersets of XOR opperations

public class BitMinipXORSumming {


    //GET THE POWERSET

    public static <T> List<List<T>> powerset(Collection<T> list) {
        List<List<T>> ps = new ArrayList<List<T>>();
        ps.add(new ArrayList<T>());   // add the empty set

        // for every item in the original list
        for (T item : list) {
            List<List<T>> newPs = new ArrayList<List<T>>();

            for (List<T> subset : ps) {
                // copy all of the current powerset's subsets
                newPs.add(subset);

                // plus the subsets appended with the current item
                List<T> newSubset = new ArrayList<T>(subset);
                newSubset.add(item);
                newPs.add(newSubset);


                //DEBUG
                /*
                System.out.println("state of newSubset: ");
                for( T currsubItem : newSubset){
                    System.out.print(currsubItem);
                }

                System.out.println();
                System.out.println("state of newPS: ");
                for(List<T> currL : newPs){

                    for( T currInt : currL){
                        System.out.print(currInt + " ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println("state of ps: ");
                for(List<T> currL : ps){

                    for( T currInt : currL){
                        System.out.print(currInt + " ");
                    }
                    System.out.println();
                }
                */

            }

            // powerset is now powerset of list.subList(0, list.indexOf(item)+1)
            ps = newPs;
        }
        return ps;
    }

    public static int xorSum(List<List<Integer>> l){
        int sum = 0;

        for(List<Integer> currL : l) {

            int tempSum = 0;
            for (Integer currInt : currL) {
                tempSum = tempSum ^ currInt;
            }
            sum = sum + tempSum;
        }

        return sum;
    }


    public static void main(String args[]){

//        ArrayList<Integer> tester = new ArrayList<Integer>();
//        tester.add(1);
//        tester.add(2);
//        tester.add(3);
//
//        List<List<Integer>> ret = powerset(tester);

//        for(List<Integer> currL : ret){
//
//            for( Integer currInt : currL){
//                System.out.print(currInt + " ");
//            }
//            System.out.println();
//        }


        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for( int i = 0; i < t; i ++){

            int n = sc.nextInt();
            ArrayList<Integer> currlist = new ArrayList<Integer>();

            for(int j = 0; j < n; j++){
                int curr = sc.nextInt();
                currlist.add(curr);

            }

            List<List<Integer>> ret = powerset(currlist);
            System.out.println(xorSum(ret));
        }

    }

}
