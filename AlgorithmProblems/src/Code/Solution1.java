/**
 * Created by elblonko on 10/16/14.
 *
 * This program solves the below problem from hackerrank.com
 * Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly because it is a pangram. ( pangrams are sentences constructed by using every letter of the alphabet at least once. )

 After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

 Given a sentence s, tell Roy if it is a pangram or not.

 Input Format

 Input consists of a line containing s.

 Constraints
 Length of s can be atmost 103 (1≤|s|≤103) and it may contain spaces, lowercase and uppercase letters. Lowercase and uppercase instances of a letter are considered same.

 Output Format

 Output a line containing pangram if s is a pangram, otherwise output not pangram.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Solution1 {

    public static void main(String args[]) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String input;
        //holds the letters
        boolean[] charArry = new boolean[26];
        //initialize to false
        for(int i = 0; i < 26; i++){
            charArry[i] = false;
        }

        input = br.readLine();

        //making lower case for ascii value reasons
        input = input.toLowerCase();

        for(int i = 0; i < input.length(); i++){
            char currChar = input.charAt(i);
            //convert to #
            int charNum = (int) currChar;
            //now set letter to num range starting at 0
            charNum = charNum - 97;
            //check if its a letter
            if(charNum >= 0 && charNum <= 25){
                //Not in the array
                if(!charArry[charNum]){
                    //System.out.println("adding " + currChar);
                    charArry[charNum] = true;
                }
            }

        }

        //check if entire array is true
        for(boolean t: charArry){
            //if a false is found
            if( !t ){
                System.out.println("not pangram");
                return;
            }
        }
        System.out.println("pangram");

    }

}
