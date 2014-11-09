import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by elblonko on 11/7/14.
 */
public class ReverseWords {

    public static String reverseString(String s){

        boolean punctFlag = false;

        //Get current word and check it for punctuation.
        String temp = null;
        String punctHolder = null;

        //Create Stringtoken representation of words
        StringTokenizer st = new StringTokenizer(s);
        //Create stack to pop the tokens too
        Stack popToReverse = new Stack();
        while(st.hasMoreTokens()){

            temp = st.nextToken();

            if( !st.hasMoreTokens()) {
                String tempChar = temp.substring(temp.length() -1);
                if ( ! tempChar.matches("AZaz")){
                    //set flag to append the character to the end of the string
                    punctHolder = tempChar;
                    punctFlag = true;
                    temp = temp.substring(0,temp.length()-2);
                }
            }

            popToReverse.push(temp);

        }

        //Substring builder to build new string
        StringBuilder newS = new StringBuilder();
        //Now concatinate into a string and return
        while( !popToReverse.empty() ){
            temp = popToReverse.pop().toString();
            newS.append(temp);
            //Don't add space after last word
            if( !popToReverse.empty()) {
                newS.append(" ");
            }
            else if (punctFlag){
                newS.append(punctHolder);
            }
        }

        return newS.toString();
    }


    public static void main (String args[]){

        String test1 = "I like cookies does you're mom like cookies?";
        System.out.println(reverseString(test1));

    }
}
