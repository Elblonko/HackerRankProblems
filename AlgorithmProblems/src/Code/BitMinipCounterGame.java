import java.math.BigInteger;

/**
 * Created by elblonko on 11/24/14.
 */
public class BitMinipCounterGame {

    /*

    Problem Statement

Louise and Richard play a game. They have a counter set to N. Louise gets the first turn and the turns alternate thereafter. In the game, they perform the following operations.

If N is not a power of 2, they reduce the counter by the largest power of 2 less than N.
If N is a power of 2, they reduce the counter by half of N.
The resultant value is the new N which is again used for subsequent operations.
The game ends when the counter reduces to 1, i.e., N == 1, and the last person to make a valid move wins.

Given N, your task is to find the winner of the game.

Update If they set counter to 1, Richard wins, because its Louise' turn and she cannot make a move.

Input Format
The first line contains an integer T, the number of testcases.
T lines follow. Each line contains N, the initial number set in the counter.

Constraints

1 ≤ T ≤ 10
1 ≤ N ≤ 264 - 1

Note: Range of N is larger than long long int, consider using unsigned long long int.

Output Format

For each test case, print the winner's name in a new line. So if Louise wins the game, print "Louise". Otherwise, print "Richard". (Quotes are for clarity)


     */

    //Will need to create a BigInteger that is unsigned in java to solve this problem. Will revisit.

    public static int bitReduceGame(BigInteger bitnum){

        int retValue = 0;

        return retValue;

    }

    public static void main(String args[]){





    }
}
