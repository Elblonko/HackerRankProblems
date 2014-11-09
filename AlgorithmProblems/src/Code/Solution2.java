/**
 * Created by Matthew Schwegler on 10/16/14.
 *
 *
 * This is my attempt at the Planantir
 *
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2 {

    public static void main(String args[]) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String input;

        //first read in M and N
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        //Would normal use TTD but no time
        //Test m and n are as excpted
        System.out.println("Input m= " + m + " Input n= " + n);

        //Fill an array with wait times
        int[][] waitTimes= new int[m][n];

        //Use M to loop through the next M lines filling in a grid of wait times

            for (int i = 0; i < m; i++) {

                input = br.readLine();

                for (int j = 0; j < n; j++) {

                    int curr = in.nextInt();
                    waitTimes[i][j] = curr;

                    //for testing
                    System.out.println("current m " + i + " current n " + j);

                }
            }

        //Get the number of employees
        int employeeNum = in.nextInt();
        System.out.println("current number employees " + employeeNum);

        //Now to solve the problem with only 30 minutes left.....
        /*
        Concept: run through the waitTime grid and calculate a single digit value for each possible path.
        While doing this calculation keep the shortest path stored in a variable at the end of the traversal
        print the lowest value found to the screen
         */
        //get employee starting points and do calculation for quickest way to work
        for(int e = 0; e < employeeNum; e++) {
            //x corrilates to m
            int x = in.nextInt();
            int y = in.nextInt();
            //Test input
            System.out.println("Person " + e + " start position " + x + "," + y);

            int currDistance = 0;
            int shortestDistance = 0;
            /*
            Need to find a way to traverse every path in the mxn grid.
            Solution: This would be done with recursion via a function outside of main
            I will write the sudo code for this function as I have run short on time
             */

            /******************************************************************************
             * PSUEDO CODE FOR RECURSION
             * -start the recursion with each employees given start point
             *
             * int Recurse(int currDistance, int xCurr, int yCurr, int[][] waitTime)
             *  currDistance += waitTime[xCurr,yCurr]
             *  if( xCurr+1 < m)
             *     Recurse(currDistance, xCurr+1, yCurr, waitTime)
             *  if( yCurr+1 < n)
             *     Recurse(currDistance, xCurr+1, yCurr, waitTime)
             *
             *  return currDistance
             *
             */

        /*
        Now I need to find a way to compare each of final distance calculations for each employee. I have 3
        minutes left and will turn in the code here.
         */


        }

    }
}
